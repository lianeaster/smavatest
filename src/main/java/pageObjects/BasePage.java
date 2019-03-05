package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

public abstract class BasePage {
    private static WebDriver driver = DriverManager.getDriver();


    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    public static String identifyPage() {
        return driver.getCurrentUrl();
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
                "'" + itemName + "')]"));
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

    public static void waitForAsyncExecution() {
        final WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(e -> isPageLoaded());
    }

    public static Boolean isPageLoaded() {
        final Object scriptResult = ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        return Boolean.parseBoolean(String.valueOf(scriptResult));
    }

    public abstract Boolean isHeaderCorrect();
}
