package dropbox.automation.tests.common;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import dropbox.automation.framework.common.Driver;
import dropbox.automation.framework.pages.LoginPage;

public class TestBase {
	
	
	@BeforeMethod
	public void beforeMethod() {
		LoginPage loginPage = new LoginPage();

		String username = TestConfig.getInstance().getUserName();
		String password = TestConfig.getInstance().getUserPassword();
		String baseUrl = TestConfig.getInstance().getBaseUrl();
		
		loginPage.goTo(baseUrl);
		loginPage.login(username, password);
	}
	
	
	@AfterMethod
	public void afterMethod() {
		Driver.quit();
	}

}
