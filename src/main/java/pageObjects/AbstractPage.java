package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.DriverManager;

//TODO: make class abstract
public class AbstractPage {
	private WebDriver driver = DriverManager.getDriver();

	public AbstractPage(){
		PageFactory.initElements(driver,AbstractPage.class);
	}

	public void open(String url) {
		driver.get(url);
	}

	public void clickOn(WebElement button) {
		button.click();
	}

	public void chooseDropdownListItem(WebElement dropdownElement, String itemName) {
		Select select = new Select(dropdownElement);
		select.selectByVisibleText(itemName);
	}

	public void fillTextField(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

}
