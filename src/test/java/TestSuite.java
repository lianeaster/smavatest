import dto.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.IncomePage;
import pageObjects.LandingPage;
import pageObjects.PersonalPage;
import pageObjects.ReloginPage;

import static utils.PropertiesUtils.getProperty;

public class TestSuite extends BaseTest {
    private static final String LANDING_PAGE_URL = getProperty("base_url");
    private static final String USER = getProperty("test_user");
    private static final String PASSWORD = getProperty("test_pass");
    private final LandingPage landingPage = new LandingPage();
    private final PersonalPage personalPage = new PersonalPage();
    private final IncomePage incomePage = new IncomePage();
    private final ReloginPage reLoginPage = new ReloginPage();

    @Test
    public void checkWrongLoginAttempt() {
        landingPage.open(LANDING_PAGE_URL);
        landingPage.fillLoginForm(USER, PASSWORD);
        reLoginPage.waitForAsyncExecution();
        Assert.assertTrue(reLoginPage.isPageLoaded());
    }

    @Test
    public void checkIdPageLoaded() {
        landingPage.open(LANDING_PAGE_URL);
        landingPage.fillLoanRequest("Wohnen", "2.750", "24 Monate");
        personalPage.fillPersonalData(getUserData());
        incomePage.waitForAsyncExecution();
        Assert.assertTrue(incomePage.isPageLoaded());
    }


    private User getUserData() {
        return new User(false, "asd", "asd", "01.03.1964", "0123456789", "test@gmail.com");
    }
}
