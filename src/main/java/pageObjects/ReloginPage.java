package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ReloginPage extends BasePage {
    private static final String HEADER_NAME = "Bitte loggen Sie sich ein";
    @FindBy(how = How.TAG_NAME, using = "h1")
    private WebElement pageHeaderElement;


    public Boolean isHeaderCorrect() {
        return  pageHeaderElement.getText().equals(HEADER_NAME);
    }
}
