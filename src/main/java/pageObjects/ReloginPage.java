package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ReloginPage extends AbstractPage {
    private static final String HEADER_NAME = "Bitte loggen Sie sich ein";
    @FindBy(how = How.TAG_NAME, using = "h1")
    private WebElement pageHeaderElement;

    @Override
    public Boolean isPageLoaded() {
        return super.isPageLoaded() && pageHeaderElement.getText().equals(HEADER_NAME);
    }
}
