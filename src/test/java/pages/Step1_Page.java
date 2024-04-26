package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Step1_Page extends BasePage {
	
    @FindBy(id = "BirthdayStep1")
    private WebElement in_birthdayS1;
    
    @FindBy(id = "province")
    private WebElement sel_province;
    
    @FindBy(id = "txtPhoneCode")
    private WebElement in_txtPhoneCode;
    
    @FindBy(id = "txtPhoneNumber")
    private WebElement in_txtPhoneNumber;
    
    @FindBy(xpath = "//label[contains(text(),'Celular')]")
    private WebElement lbl_Cel;
    
    @FindBy(id = "ajaxSpinner")
    private WebElement spinner;
    
    @FindBy(xpath = "//div[@class='slider slider-horizontal']")
    private WebElement slider;
    
    @FindBy(xpath = "//div[@role='slider'][1]")
    private WebElement txt_DynamicAmount;
    
    @FindBy(id = "chkDisability")
    private WebElement chk_Disability;
    
    @FindBy(id = "chkAccident")
    private WebElement chk_Accident;
    
    @FindBy(id = "chkIllness")
    private WebElement chk_Illness;
        
    @FindBy(id = "btnSaveStep1")
    private WebElement btn_Contract;
    

    public Step1_Page(){
        PageFactory.initElements(driver, this);
    }

	public void complete_birthday(String birthday) {
		type(in_birthdayS1, birthday);
	}
	
	public void select_Prov(String province) {
		selectOption(sel_province, province);
	}

	public void complete_Cell(String phoneCode, String cellNum) {
		type(in_txtPhoneCode, phoneCode);
		type(in_txtPhoneNumber, cellNum);
		click(lbl_Cel);
	}

	public void slide_insured(String insured) {
		waitForElementNoExist(spinner);
		int insuredValue = Integer.parseInt(insured);
		moveSliderToValue(slider,txt_DynamicAmount, insuredValue);
	}

	public void check_additional(String additional) {
		switch(additional) {
		case "invalidez":
			click(chk_Disability);
			break;
		case "accidente":
			click(chk_Accident);
		case "enfermedad":
			click(chk_Illness);
			break;
		default:
			break;
		}
	}
	
	public String step1_getTotal() {
		return textOf(btn_Contract);
	}

	public void click_Contract() {
		click(btn_Contract);	
	}
}
