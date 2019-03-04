package pageObjects;

import dto.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PersonalPage extends AbstractPage {
	@FindBy(how = How.ID, using = "applicant0.personal.salutation-MR")
	private WebElement maleButton;
	@FindBy(how = How.ID, using = "applicant0.personal.salutation-MRS")
	private WebElement femaleButton;
	@FindBy(how = How.ID, using = "applicant0.personal.firstName")
	private WebElement firstNameField;
	@FindBy(how = How.ID, using = "applicant0.personal.lastName")
	private WebElement surnameField;
	@FindBy(how = How.ID, using = "applicant0.personal.birthDate")
	private WebElement dateOfBirthField;
	@FindBy(how = How.ID,using="applicant0.contacts.phoneMobile")
	private WebElement phoneField;
	@FindBy(how = How.ID, using="applicant0.contacts.email")
	private WebElement emailField;
	@FindBy(how = How.XPATH, using = "//input[@id='applicant0.conditions" +
			".schufaAgreementAccepted']/following-sibling::span")
	private WebElement agreeCheckBox;
	@FindBy(how = How.ID, using = "cta_btn_0")
	private WebElement nextButton;


	public void fillPersonalData(User userData) {
		if (userData.isMale())
			clickOn(maleButton);
		 else
			clickOn(femaleButton);
		fillTextField(firstNameField,userData.getFirstName());
		fillTextField(surnameField,userData.getSurname());
		fillTextField(dateOfBirthField,userData.getDateOdBirth());
		fillTextField(phoneField,userData.getPhoneNumber());
		fillTextField(emailField,userData.getEmail());
		checkCheckbox(agreeCheckBox);
		clickOn(nextButton);
	}
}
