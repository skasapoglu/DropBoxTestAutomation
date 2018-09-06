package dropbox.automation.framework.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Class for enveloping the selenium {@link ChromeDriver} instance. This class
 * will serve as single object throughout whole test no class can create a
 * WebDriver externally, only can call this class for selenium operations.
 * 
 * @author Sabahattin Kasapoglu
 *
 */
public class Driver {

	private static WebDriver driver = null;

	/**
	 * If the instance of driver is non-exist, will instantiate driver object
	 * 
	 * @return single instance of {@code ChromeDriver}
	 */
	public synchronized static WebDriver driver() {
		if (driver == null) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
		}
		return driver;
	}
	
	

	/**
	 * Closes and terminates the driver element.
	 */
	public static void quit() {
		driver.quit();
		driver = null;
	}

}
