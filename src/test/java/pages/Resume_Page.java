package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Resume_Page extends BasePage {
	
    @FindBy(xpath = "//*[@id='frmSummary']/div[3]/div[2]/div/div[1]/input")
    private WebElement txt_Name;
    
    @FindBy(id = "ID_Number")
    private WebElement txt_IDNumber;
    
    @FindBy(xpath = "//*[@id='frmSummary']/div[3]/div[2]/div/div[3]/input")
    private WebElement txt_Birthday;
    
    @FindBy(xpath = "//*[@id='frmSummary']/div[3]/div[4]/div[1]/div[1]/input")
    private WebElement text_Amount;
    
    @FindBy(id = "txtSummaryTotalPremium")
    private WebElement txt_Total;
    
    @FindBy(id = "chkTC")
    private WebElement chk_TC;
    
    @FindBy(id = "btnSummarySubmit")
    private WebElement btn_Next;
    
    @FindBy(id= "frmSummary")
    private WebElement form_Finished;
    

    public Resume_Page(){
        PageFactory.initElements(driver, this);
    }

	public String resume_getName() {
		return getAttributeValue(txt_Name, "value");
	}
	
	public String resume_getIDNumber() {
		return getAttributeValue(txt_IDNumber, "value");
	}

	public String resume_getBirthday() {
		return getAttributeValue(txt_Birthday, "value");
	}
	
	public String resume_getAmount() {
		return getAttributeValue(text_Amount, "value");
	}
	
	public String resume_getTotal() {
		return getAttributeValue(txt_Total, "value");
	}
	
	public void check_TC() {
		click(chk_TC);
	}
	
	public void click_Next() {
		click(btn_Next);	
	}
	
	public boolean finishedSteps() {
		return existElement(form_Finished);
	}
}
