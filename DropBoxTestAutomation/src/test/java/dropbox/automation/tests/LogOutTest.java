package dropbox.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import dropbox.automation.framework.pages.HomePage;
import dropbox.automation.framework.pages.LogOutPage;
import dropbox.automation.tests.common.TestBase;

public class LogOutTest extends TestBase {

	@Test
	public void loggedInUserCanSuccessfullyLogsOut() {

		// GIVEN
		HomePage homePage = new HomePage();
		LogOutPage logOutPage = new LogOutPage();

		// WHEN
		homePage.logOut();

		// THEN
		Assert.assertTrue(logOutPage.isAt(), "User cannot logout successfully");
	}

}
