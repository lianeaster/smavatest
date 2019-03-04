import dto.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.IncomePage;
import pageObjects.LandingPage;
import pageObjects.PersonalPage;
import pageObjects.ReloginPage;

import static utils.PropertiesUtils.getProperty;

public class TestSuite {
	private static final String       LANDING_PAGE_URL = getProperty("base_url");
	private final        LandingPage  landingPage      = new LandingPage();
	private final        PersonalPage personalPage     = new PersonalPage();
	private final        IncomePage   incomePage       = new IncomePage();
	private final        ReloginPage  reLoginPage      = new ReloginPage();

	@Test
	public void checkIdPageLoaded() {
		landingPage.open(LANDING_PAGE_URL);
		landingPage.fillLoanRequest("Live", "2750", "24 month");
		personalPage.fillPersonalData(getUserData());
		Assert.assertTrue(incomePage.isPageLoaded());
	}

	@Test
	public void checkWrongLoginAttempt() {
		landingPage.fillLoginForm("asd@gmail.com", "sdf");
		Assert.assertTrue(reLoginPage.isPageLoaded());
	}

	private User getUserData() {
		return new User();
	}

}
