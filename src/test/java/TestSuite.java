import dto.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;

import static pageObjects.BasePage.isPageLoaded;
import static pageObjects.BasePage.waitForAsyncExecution;
import static utils.PropertiesUtils.getProperty;

public class TestSuite extends BaseTest {
    private static final String LANDING_PAGE_URL = getProperty("base_url");
    private static final String USER = getProperty("test_user");
    private static final String PASSWORD = getProperty("test_pass");
    private  LandingPage landingPage = new LandingPage();
    private  PersonalPage personalPage = new PersonalPage();
    private  IncomePage incomePage = new IncomePage();
    private  ReloginPage reLoginPage = new ReloginPage();

    @Test
    public void checkWrongLoginAttempt() {
        landingPage.open(LANDING_PAGE_URL);
        landingPage.fillLoginForm(USER, PASSWORD);
        String s = BasePage.identifyPage();
        waitForAsyncExecution();
        Boolean isHeaderCorrect = s.equals(LANDING_PAGE_URL) ?
                landingPage.isHeaderCorrect() : reLoginPage.isHeaderCorrect();
        Assert.assertTrue(isPageLoaded()&&isHeaderCorrect);
    }

    @Test
    public void checkIdPageLoaded() {
        landingPage.open(LANDING_PAGE_URL);
        landingPage.fillLoanRequest("Wohnen", "2.750", "24 Monate");
        personalPage.fillPersonalData(getUserData());
        IncomePage.waitForAsyncExecution();
        Assert.assertTrue(isPageLoaded()&&incomePage.isHeaderCorrect());
    }


    private User getUserData() {
        return new User(false, "asd", "asd", "01.03.1964", "0123456789", "test@gmail.com");
    }
}
