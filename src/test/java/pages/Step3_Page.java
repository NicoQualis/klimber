package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Step3_Page extends BasePage {
	
    @FindBy(id = "Name")
    private WebElement in_Name;
    
    @FindBy(id = "Surname")
    private WebElement in_Surname;
    
    @FindBy(id = "ID_Number")
    private WebElement in_IDNumber;
    
    @FindBy(id = "Gender")
    private WebElement sel_Gender;
    
    @FindBy(id = "IdentificationGenderType")
    private WebElement sel_IdentificationGenderType;
    
    @FindBy(id = "CivilStatus")
    private WebElement sel_CivilStatus;
    
    @FindBy(id = "txtEmail")
    private WebElement in_Email;
    
    @FindBy(id = "Password")
    private WebElement in_Password;
    
    @FindBy(id = "Street")
    private WebElement in_Street;
    
    @FindBy(id = "HouseNumber")
    private WebElement in_HouseNumber;
    
    @FindBy(id = "zipCode")
    private WebElement in_ZipCode;
    
    @FindBy(id = "city")
    private WebElement sel_City;
    
    @FindBy(id = "btnRegister")
    private WebElement btn_Next;
    
    

    public Step3_Page(){
        PageFactory.initElements(driver, this);
    }

	public void complete_Name(String name) {
			type(in_Name, name);
	}
	
	public void complete_Surname(String surname) {
		type(in_Surname, surname);
	}

	public String complete_DNI(String idNumber) {
		if(idNumber.equalsIgnoreCase("auto")){
			idNumber = Integer.toString(attendee.randomNumber(8));
		}
		type(in_IDNumber, idNumber);
		return idNumber;
	}

	public void select_Gender(String gender) {
		selectOption(sel_Gender, gender);
	}
	
	public void select_IdentificationGenderType(String identificationGenderType) {
		selectOption(sel_IdentificationGenderType, identificationGenderType);
	}
	
	public void select_CivilStatus(String civilStatus) {
		selectOption(sel_CivilStatus, civilStatus);
	}
	
	public void complete_Email(String email) {
		if(email.equalsIgnoreCase("auto")){
			String emailRandom = Integer.toString(attendee.randomNumber(6));
			email = "random_" + emailRandom + "@klimber.com";
		}
		type(in_Email, email);
	}
	
	public void complete_Password(String password) {
		type(in_Password, password);
	}
	
	public void complete_Street(String street) {
		type(in_Street, street);
	}
	
	public void complete_HouseNumber(String houseNumber) {
		type(in_HouseNumber, houseNumber);
	}
	
	public void complete_Zip(String zipCode) {
		type(in_ZipCode, zipCode);
	}
	
	public void select_City(String city) {
		selectOption(sel_City, city);
	}
	
	public void click_Next() {
		click(btn_Next);	
	}
}
