import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static utils.DriverManager.getDriver;

public abstract class BaseTest {
    @BeforeTest
    public void prepareEnv() {
        getDriver().manage().deleteAllCookies();
    }

    @AfterTest
    public void closeBrowser() {
        if (getDriver() instanceof ChromeDriver)
            getDriver().quit();
        else getDriver().close();
    }
}
