package dropbox.automation.framework.pages;

import org.openqa.selenium.By;

/**
 * Class for user interactions on home page
 * 
 * @author Sabahattin Kasapoglu
 *
 */
public class HomePage extends PageBase {

	private static final String HomePageTitle = "Home";
	private static final String UploadedText = "Uploaded";

	private By homePageTitleField = By.xpath("//h1[@class='page-header__heading']");
	private By avatarField = By.cssSelector("button[aria-label='Account menu']");
	private By logoutField = By.cssSelector("a[href='https://www.dropbox.com/logout']");
	private By sharedFolderField = By.xpath("//div[contains(@class, 'new-shared-folder')]");
	private By inputFileField = By.xpath("/html[1]/body[1]/div[8]/div[1]/input[1]");
	private By inputFileResultField = By.className("mc-snackbar-title");
	private By dropBoxFolderField = By.xpath("//li[contains(@id, 'tree-view-')]");
	private By uploadField = By.xpath("//span[@class='mc-button-content'][contains(text(),'Upload')]");
	private By filesPageField = By.cssSelector("a[href='https://www.dropbox.com/home']");

	/**
	 * Logs out the current user from the application
	 */
	public void logOut() {
		click(avatarField);
		click(logoutField);
	}

	/**
	 * Opens up the files menu displayed on home page
	 * 
	 */
	public void toFilesPage() {
		waitForVisibilityOf(filesPageField);
		click(filesPageField);
	}

	@Override
	public boolean isAt() {
		return isDisplayed(homePageTitleField) && getText(homePageTitleField).equals(HomePageTitle);
	}

	/**
	 * Clicks share new folder button on page
	 */
	public void shareNewFolder() {

		click(sharedFolderField);

	}

	/**
	 * Uploads the given file with path.
	 * 
	 * @param filePath
	 *            the path in local file system.
	 */
	public void upLoadFile(String filePath) {

		enterInput(inputFileField, filePath);
		click(dropBoxFolderField);
		click(uploadField);

	}

	/**
	 * Checks if the given File with file name successfully uploaded
	 * 
	 * @param fileName
	 *            file name of the File
	 * @return {@link True} if correct text message is displayed, {@link False}
	 *         otherwise
	 */
	public boolean isFileUploaded(String fileName) {

		waitUntil(inputFileResultField, 20).getText().equals(UploadedText + " " + fileName);

		return true;
	}

}
