package dropbox.automation.tests.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Class for loading and distributing parameterized configuration info through
 * out framework.
 * 
 * @author Sabahattin Kasapoglu
 *
 */
public class TestConfig {

	private static TestConfig instance = null;
	private Properties properties;

	private TestConfig() {
		try {
			loadConfigFile();
		} catch (IOException ex) {
			System.out.println("Error while loading configuration file /config.properties");
		}
	}

	/**
	 * Gets single instance of {@code Config}.
	 * 
	 * @return instance of configuration.
	 */
	public static synchronized TestConfig getInstance() {

		if (instance == null) {
			instance = new TestConfig();
		}

		return instance;

	}

	public String getBaseUrl() {
		return properties.getProperty("baseUrl");
	}

	public String getUserName() {
		return properties.getProperty("username");
	}

	public String getUserPassword() {
		return properties.getProperty("password");
	}
	
	public String getEmailAddress() {
		return properties.getProperty("useremail");
	}

	private void loadConfigFile() throws IOException {
		properties = new Properties();
		InputStream is = TestConfig.class.getClassLoader().getResourceAsStream("config.properties");

		properties.load(is);

	}


}
