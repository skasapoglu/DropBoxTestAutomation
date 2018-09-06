package dropbox.automation.framework.pages;

import org.openqa.selenium.By;

public class LoginPage extends PageBase {

	private By signInButtonField = By.id("sign-up-in");
	private By dropBoxLogoField = By
			.xpath("//section[@class='RebrandHero ob-grid']//img[@class='DropboxLogo--wordmark']");

	private By userNameField = By.xpath("//input[starts-with(@id,'login_email')]");
	private By passwordField = By.xpath("//input[starts-with(@id,'login_password')]");
	private By signInButonField = By.xpath("//div[@class='signin-text']");

	
	/**
	 * Signs with the configured user credentials.
	 * 
	 * @param username
	 *            given user name credential
	 * @param password
	 *            given user password credential
	 */
	public void login(String username, String password) {

		click(signInButtonField);

		enterInput(userNameField, username);
		enterInput(passwordField, password);

		click(signInButonField);

	}

	/**
	 * Goes to given page with url address
	 * 
	 * @param url
	 */
	public void goTo(String url) {
		navigatesTo(url);
	}

	@Override
	public boolean isAt() {
		return isDisplayed(dropBoxLogoField);
	}

}
