package dropbox.automation.tests;

import java.time.Instant;

import org.testng.Assert;
import org.testng.annotations.Test;

import dropbox.automation.framework.pages.FilesPage;
import dropbox.automation.framework.pages.HomePage;
import dropbox.automation.tests.common.TestBase;

public class CreateFolderTest extends TestBase {

	@Test
	public void userCanCreateFolder() throws InterruptedException {
		HomePage homePage = new HomePage();
		FilesPage filesPage = new FilesPage();
		
		// GIVEN
		String folderName = "TestFolder" + Instant.now().toEpochMilli();

		// WHEN
		homePage.toFilesPage();

		// AND
		filesPage.createNewFolder(folderName);
		
		// THEN
		Assert.assertTrue(filesPage.isFolderCreated(folderName), "Given folder cannot be created");
	}

}
