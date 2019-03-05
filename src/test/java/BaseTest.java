import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static utils.DriverManager.getDriver;

public abstract class BaseTest {
    @BeforeTest
    public void prepareEnv(){
        getDriver().manage().deleteAllCookies();
    }

    @AfterTest
    public void closeBrowser() {
        getDriver().close();
    }
}
