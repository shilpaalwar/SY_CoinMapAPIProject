package utility;

import java.io.File;

/*
 * This class is used to red properties from properties file
 */
public class BasePage {

	public static final String ENV_FILE_NAME = "configDetails";
	public static final String ENV_FILE_PATH = "src" + File.separator + "test" + File.separator + "resources" + File.separator +  "property" + File.separator;
	private static String applicationPath = System.getProperty("user.dir") + File.separator + ENV_FILE_PATH + ENV_FILE_NAME;
	static PropertyReader properties = new PropertyReader(applicationPath);
	
	public static String getProperty(String propName)
	{
		return properties.getProperty(propName);
	}
	
	
}
