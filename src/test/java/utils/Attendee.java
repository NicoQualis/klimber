package utils;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import java.io.*;
import java.time.Duration;
import java.util.Properties;
import java.util.regex.*;
import java.util.Random;

import enums.Browsers;

public class Attendee {

	protected static Attendee attendee;
	private static Properties properties;
	public static WebDriver driver;
	private static String OS = System.getProperty("os.name").toLowerCase();
	public static boolean IS_WINDOWS = (OS.indexOf("win") >= 0);
	public static boolean IS_MAC = (OS.indexOf("mac") >= 0);
	private static InputStream inputStream;
	private static SoftAssertions softly;

	public Attendee() {
		// cargar el archivo de propiedades
		inputStream = Attendee.class.getClassLoader().getResourceAsStream("config.properties");
		properties = new Properties();
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Attendee getInstance() {
		if (attendee == null) {
			attendee = new Attendee();
		}
		return attendee;
	}
	
	public static SoftAssertions getSoftly() {
        if (softly == null) {
            softly = new SoftAssertions();
        }
        return softly;
    }

	// Properties
	public String getProperty(String key) {
		return properties.getProperty(key);
	}

	public static void setProperty(String key, String value) {
		properties.setProperty(key, value);

		try (OutputStream outputStream = new FileOutputStream("config.properties")) {
			properties.store(outputStream, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Driver
	public WebDriver configBrowser(String browser, Boolean headless) {

		if (OS.indexOf("win") >= 0) {
			if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				if (headless)
					options.addArguments("--headless");
				options.addArguments("start-maximized");
				options.addArguments("enable-automation");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-infobars");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--disable-browser-side-navigation");
				options.addArguments("--disable-gpu");
				options.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.manage().window().maximize();
			} else if (browser.equalsIgnoreCase(Browsers.FIREFOX.name())) {
				WebDriverManager.firefoxdriver().arch64().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
			} else if (browser.equalsIgnoreCase(Browsers.EDGE.name())) {
				WebDriverManager.edgedriver().enableRecording().setup();
				EdgeOptions options = new EdgeOptions();
				if (headless)
					options.addArguments("--headless");
				options.addArguments("start-maximized");
				options.addArguments("enable-automation");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-infobars");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--disable-browser-side-navigation");
				options.addArguments("--disable-gpu");
				options.addArguments("--remote-allow-origins=*");
				driver = new EdgeDriver(options);
				driver.manage().window().maximize();
			}
		} else if (OS.indexOf("mac") >= 0) {
			if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
				WebDriverManager.chromedriver().browserVersion("108.0.5359.71").arch64().enableRecording().setup();
				ChromeOptions options = new ChromeOptions();
				if (headless)
					options.addArguments("--headless");
				options.addArguments("start-maximized");
				options.addArguments("enable-automation");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-infobars");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--disable-browser-side-navigation");
				options.addArguments("--disable-gpu");
				options.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
			} else if (browser.equalsIgnoreCase(Browsers.FIREFOX.name())) {
				WebDriverManager.firefoxdriver().arch64().enableRecording().setup();
				FirefoxOptions options = new FirefoxOptions();
				if (headless)
					options.addArguments("--headless");
				options.addArguments("start-maximized");
				options.addArguments("enable-automation");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-infobars");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--disable-browser-side-navigation");
				options.addArguments("--disable-gpu");
				options.addArguments("--remote-allow-origins=*");
				driver = new FirefoxDriver(options);
				driver.manage().window().maximize();
			} else if (browser.equalsIgnoreCase(Browsers.SAFARI.name())) {
				WebDriverManager.safaridriver().arch64().enableRecording().setup();
				SafariOptions options = new SafariOptions();
				options.setAcceptInsecureCerts(true);
				options.setAutomaticInspection(true);
				options.setCapability("disable-popup-blocking", true);
				driver = new SafariDriver(options);
				driver.manage().window().maximize();
			}
		} else {
			new Throwable("OS invalid");
		}
		return driver;
	}

	public void openPage(String url) {
		driver.get(url);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public String takeScreenshot() {
		return ((RemoteWebDriver) driver).getScreenshotAs(OutputType.BASE64);
	}

	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
		if (attendee != null) {
			attendee = null;
		}
	}

	public String formatNumber(String number) {
		StringBuilder result = new StringBuilder();
		number = new StringBuilder(number).reverse().toString();
		for (int i = 0; i < number.length(); i++) {
			if (i > 0 && i % 3 == 0) {
				result.append('.');
			}
			result.append(number.charAt(i));
		}
		return result.reverse().toString();
	}

	public String extractNumber(String text) {
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(text);
		if (matcher.find()) {
			return matcher.group();
		}
		return null;
	}

	public int randomNumber(int width) {
		Random random = new Random();
		StringBuilder randomNumber = new StringBuilder();
		for (int i = 0; i < width; i++) {
			int digit = random.nextInt(10);
			randomNumber.append(digit);
		}
		return Integer.parseInt(randomNumber.toString());
	}
}
