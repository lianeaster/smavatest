import org.testng.annotations.AfterTest;

import static utils.DriverManager.getDriver;

public abstract class BaseTest {

    @AfterTest
    public void closeBrowser() {
        getDriver().close();
    }
}
