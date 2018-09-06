package dropbox.automation.framework.pages;

import org.openqa.selenium.By;

/**
 * Class representation of log out page. This class will simulate the user
 * interactions on logout page.
 * 
 * @author Sabahattin Kasapoglu
 *
 */
public class LogOutPage extends PageBase {

	private By signInTextField = By.className("login-register-header");

	@Override
	public boolean isAt() {
		return driver.getCurrentUrl().contains("logout") && isDisplayed(signInTextField);
	}

}
