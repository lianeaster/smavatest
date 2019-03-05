package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import javax.swing.*;

public class LandingPage extends AbstractPage {
    private static final String HEADER_NAME ="Deutschlands günstige Top Kredite" ;
    @FindBy(how = How.XPATH, using = ".//label[./div/span[text()='Verwendung']]//div[@class='Select-value']")
    private WebElement useDpopdown;
    @FindBy(how = How.XPATH, using = ".//label[./div/span[text()='Nettokreditbetrag']]//div[@class='Select-value']")
    private WebElement amountDropDown;
    @FindBy(how = How.XPATH, using = ".//label[./div/span[text()='Laufzeit']]//div[@class='Select-value']")
    private WebElement runnigTimeDropDown;
    @FindBy(how = How.XPATH, using = "//span[text()='Jetzt Kreditvergleich starten']")
    private WebElement comparisonButton;
    @FindBy(how = How.CLASS_NAME, using = "TopMenu__item-title")
    private WebElement openLoginFormButton;
    @FindBy(how = How.XPATH, using = "//*[@class[contains(.,'LoginForm__form')]]")
    private WebElement loginForm;
    @FindBy(how=How.TAG_NAME,using = "h1")
    private WebElement pageHeaderElement;

    public void fillLoanRequest(String use, String amount, String runningTime) {
        chooseDropdownListItem(useDpopdown, use);
        chooseDropdownListItem(amountDropDown, amount);
        chooseDropdownListItem(runnigTimeDropDown, runningTime);
        checkCheckbox(comparisonButton);
    }


    public void fillLoginForm(String login, String password)  {
        openLoginFormButton.click();
        WebElement emailElement = loginForm.findElement(By.name("email"));
        WebElement passElement = loginForm.findElement(By.name("password"));
        WebElement loginButtonWithLock = loginForm.findElement(By.xpath("./button/i"));
        fillTextField(emailElement, login);
        fillTextField(passElement, password);
        clickOn(loginButtonWithLock);
    }

    @Override
    public Boolean isPageLoaded() {
        return super.isPageLoaded() && pageHeaderElement.getText().equals(HEADER_NAME);
    }
}
