package dropbox.automation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import dropbox.automation.framework.common.Driver;
import dropbox.automation.framework.pages.HomePage;
import dropbox.automation.framework.pages.LoginPage;
import dropbox.automation.tests.common.TestConfig;

public class LoginTest {

	@Test
	public void authorizedUsedCanSuccessfullyLogin() {
		
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();

		// GIVEN
		String username = TestConfig.getInstance().getUserName();
		String password = TestConfig.getInstance().getUserPassword();
		String url = TestConfig.getInstance().getBaseUrl();

		// WHEN
		loginPage.goTo(url);
		loginPage.login(username, password);

		// THEN
		Assert.assertTrue(homePage.isAt(), "User cannot login successfully");
	}
	
	@AfterMethod
	public void afterMethod() {
		Driver.quit();
	}

}
