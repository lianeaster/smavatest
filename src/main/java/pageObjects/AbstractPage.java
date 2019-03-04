package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.util.StringJoiner;

//TODO: make class abstract
public abstract class AbstractPage {
	private static String    scriptToCheck;
	private static WebDriver driver = DriverManager.getDriver();


	public AbstractPage() {
		PageFactory.initElements(driver,this);
	}

	public void open(String url) {
		driver.get(url);
	}

	protected void clickOn(WebElement button) {
		button.click();
	}

	protected void chooseDropdownListItem(WebElement dropdownElement, String itemName) {
		clickOn(dropdownElement);
		WebElement element = driver.findElement(By.xpath(".//div[@class='Calulator__form-inputs']//*[contains(text()," +
				"'"+itemName+"')]"));
		clickOn(element);
	}

	protected void fillTextField(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	protected void checkCheckbox(WebElement checkBox) {
		if (!checkBox.isSelected())
			checkBox.click();
	}

	public  void waitForAsyncExecution() {
		scriptToCheck = new StringJoiner(System.lineSeparator())
				.add("return ((typeof jQuery !== 'undefined') && (jQuery.active == 0))")
				.toString();
		final WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(e -> isPageLoaded());
	}

	public Boolean isPageLoaded() {
		final Object scriptResult = ((JavascriptExecutor) driver)
				.executeScript(scriptToCheck);
		return Boolean.parseBoolean(String.valueOf(scriptResult));
	}

}
