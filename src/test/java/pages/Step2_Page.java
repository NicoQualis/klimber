package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Step2_Page extends BasePage {
	
    @FindBy(xpath = "//input[@name='UnderwritingCustom[0].ResponseBool'][@value='true']")
    private WebElement check_previousIllness;
    
    @FindBy(xpath = "//input[@name='UnderwritingCustom[1].ResponseBool'][@value='true']")
    private WebElement check_assistance;
    
    @FindBy(id = "txtHeight")
    private WebElement in_txtHeight;
    
    @FindBy(id = "txtWeight")
    private WebElement in_txtWeight;
    
    @FindBy(xpath = "//input[@name='UnderwritingCustom[2].ResponseBool'][@value='true']")
    private WebElement check_covid19;
    
    @FindBy(id = "btnSaveStep2")
    private WebElement btn_Next;
    

    public Step2_Page(){
        PageFactory.initElements(driver, this);
    }

	public void complete_PreviousIllness(String previousIllness) {
		if(previousIllness.equals("si"))
			click(check_previousIllness);
	}
	
	public void complete_Assistance(String assistance) {
		if(assistance.equals("si"))
			click(check_assistance);
	}

	public void complete_Body(String height, String weight) {
		type(in_txtHeight, height);
		type(in_txtWeight, weight);
	}

	public void complete_Covid19(String insured) {
		if(insured.equals("si"))
			click(check_covid19);
	}
	public void click_Next() {
		click(btn_Next);	
	}
}
