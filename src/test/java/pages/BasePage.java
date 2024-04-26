package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Attendee;

import java.time.Duration;

public abstract class BasePage {

    protected Attendee attendee = Attendee.getInstance();
    protected WebDriver driver = Attendee.getInstance().getDriver();
    long seconds = Long.parseLong(attendee.getProperty("klimber.driver.timeout"));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

    public void click(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }
    
    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementNoExist(WebElement element) {
    	try {
			Thread.sleep(3);
		}catch(InterruptedException e) {			
		}
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void type(WebElement element, String text) {
        click(element);
        element.sendKeys(text);
    }

    public String textOf(WebElement element) {
    	waitForElementToBeVisible(element);
        return element.getText();
    }
    
    public String getAttributeValue(WebElement element, String value) {
    	waitForElementToBeVisible(element);
        return element.getAttribute(value);
    }
    
    public void moveSliderToValue(WebElement slider, WebElement dataElememt, int value) {

        int minValue = Integer.parseInt(dataElememt.getAttribute("aria-valuemin"));
        int maxValue = Integer.parseInt(dataElememt.getAttribute("aria-valuemax"));
        
        int totalPixels = slider.getSize().getWidth();
        int difValuesMinMax = maxValue - minValue;
        double pixelsPerAmount = (double) totalPixels / difValuesMinMax;
        int difValuesMinExpected = value - minValue;
        double targetPixels = (pixelsPerAmount * difValuesMinExpected);
        
        Actions actions = new Actions(driver);
        actions.clickAndHold(dataElememt).moveByOffset((int)targetPixels-4, 0).release().build().perform();//sin explicacion para el -4, quizas son bordes de los elementos o el redondeo
    }
    
    public void selectOption(WebElement element, String opc) {
    	waitForElementToBeClickable(element);
    	Select select = new Select(element);
    	select.selectByVisibleText(opc);
    }
    
    public boolean existElement(WebElement element) {
    	try {
    		wait.until(ExpectedConditions.visibilityOf(element));
    		return true;
    	}catch(Exception e) {
    		return false;
    	}
        
    }
}
