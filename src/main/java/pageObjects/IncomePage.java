package pageObjects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@Slf4j
public class IncomePage extends BasePage {
    private static final String HEADER_NAME = "Bitte machen Sie Angaben zu Ihrer Person";
    @FindBy(how = How.TAG_NAME, using = "h1")
    private WebElement pageHeaderElement;


    @Override
    public Boolean isHeaderCorrect() {
        String text = pageHeaderElement.getText();
        return text.equals(HEADER_NAME);
    }
}
