package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LandingPage extends AbstractPage {
	private final String     LOGIN_SELECTOR    = "";
	private final String     PASSWORD_SELECTOR = "";
	@FindBy(how = How.XPATH, using = ".//label[./div/span[text()='Verwendung']]//div[@class='Select-value']")
	private       WebElement useDpopdown;
	@FindBy(how = How.XPATH, using = ".//label[./div/span[text()='Nettokreditbetrag']]//div[@class='Select-value']")
	private       WebElement amountDropDown;
	@FindBy(how = How.XPATH, using = ".//label[./div/span[text()='Laufzeit']]//div[@class='Select-value']")
	private       WebElement runnigTimeDropDown;
	@FindBy(how = How.XPATH, using = "//a[//span[@text()='Jetzt Kreditvergleich starten']]")
	private       WebElement comparisonButton;
	@FindBy(how = How.XPATH, using = "//a[1]")
	private       WebElement loginForm;
	@FindBy(how = How.XPATH, using = "//a[2]")
	private       WebElement loginButton;

	public void fillLoanRequest(String use, String amount, String runningTime) {
		chooseDropdownListItem(useDpopdown, use);
		chooseDropdownListItem(amountDropDown, amount);
		chooseDropdownListItem(runnigTimeDropDown, runningTime);
		clickOn(comparisonButton);
	}


	public void fillLoginForm(String login, String password) {
		WebElement loginElement = loginForm.findElement(By.xpath(LOGIN_SELECTOR));
		WebElement passElement  = loginForm.findElement(By.xpath(PASSWORD_SELECTOR));
		fillTextField(loginElement, login);
		fillTextField(passElement, password);
		clickOn(loginButton);
	}
}
