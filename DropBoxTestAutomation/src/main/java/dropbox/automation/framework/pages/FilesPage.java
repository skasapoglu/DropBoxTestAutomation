package dropbox.automation.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class for user interaction on Files menu
 * 
 * @author Sabahattin Kasapoglu
 *
 */
public class FilesPage extends PageBase {

	private By tableField = By.xpath("//tbody[contains(@class,'mc-table-body mc-table-body-culled')]");
	private By notifyField = By.xpath("//span[@id='notify-msg']");
	private By newFolderField = By.xpath("//ul[@class='mc-tertiary-list secondary-action-menu']//li[2]");


	/**
	 * Folder creation on Files menu
	 * 
	 * @param folderName
	 *            given name of the folder
	 * @throws InterruptedException 
	 */
	public void createNewFolder(String folderName) {

		click(newFolderField);
		WebElement entryField = driver.findElement(tableField).findElement(By.xpath("//tr[1]"));
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(entryField));
		
	
		Actions actions = new Actions(driver);
		actions.moveToElement(entryField);
		actions.sendKeys(folderName);
		actions.sendKeys(Keys.ENTER);
		actions.build().perform();
	}

    
    
	/**
	 * Checks if the folder creation is successful or not
	 * 
	 * @param folderName
	 * @return {@link True} if folder is created {@link False} otherwise
	 */
	public boolean isFolderCreated(String folderName) {
		waitUntil(notifyField, 10).getText().equals("Created Folder " + folderName);
		return true;
	}

	@Override
	public boolean isAt() {
		return isDisplayed(tableField);
	}

}
