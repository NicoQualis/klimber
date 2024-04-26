package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Step4_Page extends BasePage {
	
    @FindBy(id = "Nationality")
    private WebElement sel_Nationality;
    
    @FindBy(id = "PlaceOfBirth")
    private WebElement in_PlaceOfBirth;
    
    @FindBy(id = "txtOccupation")
    private WebElement in_Occupation;
    
    @FindBy(id = "txtSalaryAnual")
    private WebElement in_SalaryAnual;
    
    @FindBy(id = "txtFullName")
    private WebElement in_FullName;
    
    @FindBy(id = "txtNumberId")
    private WebElement in_NumberId;
    
    @FindBy(id = "txtAnnualIncome")
    private WebElement sel_AnnualIncome;
    
    @FindBy(id = "btnSaveInfo")
    private WebElement btn_Next;    
    

    public Step4_Page(){
        PageFactory.initElements(driver, this);
    }

	public void select_Nationality(String nationality) {
		selectOption(sel_Nationality, nationality);
	}
	
	public void complete_PlaceOfBirth(String placeOfBirth) {
		type(in_PlaceOfBirth, placeOfBirth);
	}

	public void complete_Occupation(String occupation) {
		type(in_Occupation, occupation);
	}
	
	public void complete_SalaryAnual(String salaryAnual) {
		type(in_SalaryAnual, salaryAnual);
	}
	
	public void complete_FullName(String fullName) {
		type(in_FullName, fullName);
	}
	
	public void complete_NumberId(String numberId) {
		type(in_NumberId, numberId);
	}
	
	public void select_AnnualIncome(String annualIncome) {
		selectOption(sel_AnnualIncome, annualIncome);
	}
	
	public void click_Next() {
		click(btn_Next);	
	}
}
