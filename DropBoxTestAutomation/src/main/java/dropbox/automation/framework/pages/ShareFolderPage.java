package dropbox.automation.framework.pages;

import org.openqa.selenium.By;

import dropbox.automation.framework.common.ShareFolderCommand;

/**
 * Page object model for user interaction on page create folder menu.
 * 
 * @author Sabahattin Kasapoglu
 *
 */
public class ShareFolderPage extends PageBase {

	private By shareButtonField = By.xpath(" //button[@class='unified-share-modal__share-send c-btn c-btn--primary']");
	private By folderNameField = By.id("unified-share-modal-title");
	private By emailToField = By.id("unified-share-modal-contacts-tokenizer");
	private By textAreaField = By.xpath("//textarea[@placeholder='Add a message (optional)']");
	private By canEditField = By.xpath("//button[@aria-label='Can edit']");
	private By nextField = By.xpath("//button[@class='c-btn c-btn--primary']");
	private By emptyFolderField = By.xpath("//h3[@class='u-font-strong empty-folder-table-title']");

	/**
	 * Clicks share button action on the page.
	 * 
	 * @param createCommand
	 *            given {@Code CreateFolderCommand}
	 */
	public void share(ShareFolderCommand createCommand) {

		enterInput(folderNameField, createCommand.getFolderName());
		enterInput(emailToField, createCommand.getToMail());

		click(canEditField);
		click(createCommand.getCanEdit().getValue());

		enterInput(textAreaField, createCommand.getDescription());

		click(shareButtonField);
	}

	/**
	 * Creates a new shared folder with given folder name.
	 * 
	 * @param folderName
	 *            the name folder to create
	 * @return instance of {@link ShareFolderCommand}
	 */
	public ShareFolderCommand createNewFolder(String folderName) {
		return new ShareFolderCommand(folderName);
	}

	@Override
	public boolean isAt() {
		return isDisplayed(folderNameField);
	}

	public void next() {
		click(nextField);
	}

	/**
	 * Checks the display message displayed on successful create folder operation.
	 * 
	 * @return {@link True} if message is successfully created, {@link False}
	 *         otherwise
	 */
	public boolean isFolderShared() {
		return isDisplayed(emptyFolderField);
	}

}
