package dropbox.automation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import dropbox.automation.framework.common.Driver;
import dropbox.automation.framework.pages.LoginPage;
import dropbox.automation.tests.common.TestConfig;

public class SmokeTest {

	@Test
	public void userCanSuccesfullyLoadLoginPage() {

		// GIVEN
		LoginPage loginPage = new LoginPage();
		String homePage = TestConfig.getInstance().getBaseUrl();

		// WHEN
		loginPage.goTo(homePage);

		// THEN
		Assert.assertTrue(loginPage.isAt(), "Login Page cannot be successfully displayed");
	}

	@AfterMethod
	public void afterMethod() {
		Driver.quit();
	}

}
