package dropbox.automation.tests;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import dropbox.automation.framework.pages.HomePage;
import dropbox.automation.tests.common.TestBase;

public class UploadFileTest extends TestBase {

	@Test
	public void userCanUploadAnyFileOnLocalFileSystemToDropBox() {

		HomePage homePage = new HomePage();

		// GIVEN
		String fileName = "TestFile.txt";
		File file = new File(this.getClass().getClassLoader().getResource(fileName).getFile());
		String filePath = file.getAbsolutePath();

		// WHEN
		homePage.upLoadFile(filePath);

		// THEN
		Assert.assertTrue(homePage.isFileUploaded(fileName), "File Cannot be uploaded succesffuly");

	}

}
