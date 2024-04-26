package steps;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.*;
import utils.Attendee;
import utils.StepDetails;

import java.util.Arrays;

import org.assertj.core.api.SoftAssertions;

public class Hooks {

	private static Attendee attendee;
	private static ExtentReports extent;
	private static ExtentTest extentTest;
	private SoftAssertions softly = Attendee.getSoftly();
	private boolean isApi = false;

	@BeforeAll
	public static void beforeAll() {
		attendee = Attendee.getInstance();
		extent = new ExtentReports();
		String reportFolder = attendee.getProperty("klimber.report.folder");
		String reportName = attendee.getProperty("klimber.report.name");
		String path = System.getProperty("user.dir") + String.format("\\%s\\%s.html", reportFolder, reportName);
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
		extent.attachReporter(sparkReporter);
	}

	@Before("@web")
	public void beforeScenario(Scenario scenario) {
		attendee.configBrowser(attendee.getProperty("klimber.driver.browser"),
				Boolean.valueOf(attendee.getProperty("klimber.driver.headless")));
		extentTest = extent.createTest(scenario.getName());
		isApi = false;
	}

	@Before("@api")
	public void beforeScenarioApi(Scenario scenario) {
		extentTest = extent.createTest(scenario.getName());
		isApi = true;
	}

	@AfterStep
	public void afterStep() {
		String stepName = StepDetails.name;
		try {
			if (!isApi) {
				String screenshot = attendee.takeScreenshot();
				extentTest.createNode(new GherkinKeyword(StepDetails.keyword), stepName).info("Screenshot")
						.addScreenCaptureFromBase64String(screenshot);
			}else {
				extentTest.createNode(new GherkinKeyword(StepDetails.keyword), stepName);
			}

		} catch (Exception e) {
			System.out.println(Arrays.toString(e.getStackTrace()));
		}
	}

	@After
	public void afterScenario(Scenario scenario) {
		Status status = scenario.getStatus();
		if (status.equals(Status.PASSED)) {
			extentTest.pass("passed");
		} else if (status.equals(Status.FAILED)) {
			extentTest.fail("failed");
		} else if (status.equals(Status.SKIPPED)) {
			extentTest.skip("skipped");
		}

		if (softly.errorsCollected().isEmpty()) {
			extentTest.pass("All assertions passed");
		} else {
			String errorMessage = "\n" + softly.errorsCollected();
			extentTest.fail("Assertions failed:\n" + errorMessage);
		}

		attendee.teardown();
	}

	@AfterAll
	public static void afterAll() {
		attendee.teardown();
		extent.flush();
	}
}
