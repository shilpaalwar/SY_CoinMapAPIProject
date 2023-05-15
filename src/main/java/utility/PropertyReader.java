package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
private static Properties properties = new Properties();

public PropertyReader(String fileName)
{
	loadProperties(fileName);
}

private void loadProperties(String fileName)
{
	try {
		FileInputStream fileInputStream = new FileInputStream (new File(fileName).getAbsoluteFile());
		properties.load(fileInputStream);	
	}
	catch(FileNotFoundException ex)
	{
		
	}
	catch(IOException ex)
	{
		
	}
}


public String getProperty(String propertyName)
{
	return properties.getProperty(propertyName);
}

}


