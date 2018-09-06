package dropbox.automation.framework.common;

import dropbox.automation.framework.pages.ShareFolderPage;

/**
 * Class for creating for shared folder command with the fields required.
 * 
 * @author Sabahattin Kasapoglu
 *
 */
public class ShareFolderCommand {

	private String folderName;
	private String toMail;
	private CanEdit canEdit;
	private String description;

	public ShareFolderCommand withMail(String mail) {
		this.toMail = mail;
		return this;
	}

	public ShareFolderCommand withDescription(String description) {
		this.description = description;
		return this;
	}

	public ShareFolderCommand withEditOption(CanEdit canEditOption) {
		this.canEdit = canEditOption;
		return this;
	}

	public void share() {
		ShareFolderPage createFolderMenu = new ShareFolderPage();
		createFolderMenu.share(this);
	}

	public String getFolderName() {
		return folderName;
	}

	public String getToMail() {
		return toMail;
	}

	public CanEdit getCanEdit() {
		return canEdit;
	}

	public String getDescription() {
		return description;
	}

	public ShareFolderCommand(String folderName) {
		this.folderName = folderName;
	}

}
