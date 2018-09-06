package dropbox.automation.tests;

import java.time.Instant;

import org.testng.Assert;
import org.testng.annotations.Test;

import dropbox.automation.framework.common.CanEdit;
import dropbox.automation.framework.pages.ShareFolderPage;
import dropbox.automation.framework.pages.HomePage;
import dropbox.automation.tests.common.TestBase;
import dropbox.automation.tests.common.TestConfig;

public class ShareFolderTest extends TestBase {

	@Test
	public void authorizedUsersCanCreateFolder() {
		// GIVEN
		String folderName = "testFolderName" + Instant.now().getEpochSecond();
		String emailAddress = TestConfig.getInstance().getEmailAddress();
		String description = "This is my test description";
		HomePage homePage = new HomePage();
		ShareFolderPage createFolderPage = new ShareFolderPage();

		// WHEN
		homePage.shareNewFolder();

		// AND
		createFolderPage.next();

		// AND
		createFolderPage.createNewFolder(folderName).withEditOption(CanEdit.CAN_VIEW).withMail(emailAddress)
				.withDescription(description).share();

		// THEN
		Assert.assertTrue(createFolderPage.isFolderShared(), "Creating new share folder has failed");
	}

}
