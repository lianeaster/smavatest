package pageObjects;

import dto.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PersonalPage extends AbstractPage {
	@FindBy(how = How.XPATH)
	private WebElement maleButton;
	@FindBy(how = How.XPATH)
	private WebElement femaleButton;
	@FindBy(how = How.XPATH)
	private WebElement firstNameField;
	@FindBy(how = How.XPATH)
	private WebElement surnameField;
	@FindBy(how = How.XPATH)
	private WebElement dateOfBirthField;
	@FindBy(how = How.XPATH)
	private WebElement phoneField;
	@FindBy(how = How.XPATH)
	private WebElement emailField;
	@FindBy(how = How.XPATH)
	private WebElement agreeCheckBox;
	@FindBy(how = How.XPATH)
	private WebElement nextButton;


	public void fillPersonalData(User userData) {
		if (userData.isMale())
			clickOn(maleButton);
		 else
			clickOn(femaleButton);
		fillTextField(firstNameField,userData.getFirstName());
		fillTextField(surnameField,userData.getSurname());
		fillTextField()
		fillTextField()
		fillTextField()
		fillTextField()


	}

}
