package dropbox.automation.framework.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dropbox.automation.framework.common.Driver;

/**
 * Class for abstracting the base functionality of all Page Elements.
 * 
 * @author Sabahattin Kasapoglu
 *
 */
abstract class PageBase {

	protected final WebDriver driver;

	PageBase() {
		driver = Driver.driver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * Navigates the given page.
	 * 
	 * @param url
	 */
	protected void navigatesTo(String url) {
		driver.get(url);
	}

	/**
	 * Common method to input entries to editable fields given with elementField
	 * 
	 * @param elementField
	 *            the input field to enter data entry
	 * @param entry
	 *            input data
	 */
	protected void enterInput(By elementField, String entry) {
		WebElement webElement = driver.findElement(elementField);
		webElement.sendKeys(entry);
	}

	/**
	 * Common method to input entries to editable fields given with element id and
	 * keyboard key action
	 * 
	 * @param elementField
	 *            the input field to enter data entry
	 * @param entry
	 *            input data
	 * @param keyAction
	 *            any key action defined after adding input
	 */
	protected void enterInput(By elementField, String entry, Keys keyAction) {
		WebElement webElement = driver.findElement(elementField);
		webElement.sendKeys(entry);
		webElement.sendKeys(keyAction);
		webElement.submit();
	}

	/**
	 * Clicks the given clickable entry field on pages, this method has an explicit
	 * wait condition to ensure the clickable field is visible.
	 * 
	 * @param elementField
	 *            given elementField
	 */
	protected void click(By elementField) {

		WebElement element = driver.findElement(elementField);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		driver.findElement(elementField).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * Waits explicitly for the web element for given timeout
	 * 
	 * @param elementField
	 *            given web element field
	 * @param timeoutInSeconds
	 *            timeout
	 * @return {@code WebElement} is visible
	 */
	protected WebElement waitUntil(By elementField, long timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		return wait.until(d -> d.findElement(elementField));
	}

	/**
	 * Waits explicitly for the visibility of the given element field on page
	 * 
	 * @param elementField
	 *            given elementField
	 */
	protected void waitForVisibilityOf(By elementField) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementField));
	}

	/**
	 * Checks if the given element field is displayed on page
	 * 
	 * @param elementField
	 *            given element field
	 * @return {@link True} if the element displays, {@link False} otherwise
	 */
	protected boolean isDisplayed(By elementField) {
		return driver.findElement(elementField).isDisplayed();
	}

	/**
	 * Outputs the text output of the given element
	 * 
	 * @param elementField
	 *            given element field
	 * @return text displayed on element field
	 */
	protected String getText(By elementField) {
		return driver.findElement(elementField).getText();
	}

	/**
	 * Checks if the page element is displayed correctly on browser.
	 * 
	 * @return {@link True} if the page is displayed {@link False} otherwise
	 */
	public abstract boolean isAt();

}
