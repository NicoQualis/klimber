package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Step5_6_Page extends BasePage {
	
    @FindBy(id = "CardNumber")
    private WebElement in_CardNumber;
    
    @FindBy(id = "btnSubmitStep4")
    private WebElement btn_Next;   
    
    @FindBy(className = "submitFinal")
    private WebElement btn_Next6;
    

    public Step5_6_Page(){
        PageFactory.initElements(driver, this);
    }
	
	public void complete_CardNumber(String cardNumber) {
		type(in_CardNumber, cardNumber);
	}
	
	public void click_Next() {
		click(btn_Next);	
	}
	
	public void click_Next_Step6() {
		click(btn_Next6);	
	}
}
