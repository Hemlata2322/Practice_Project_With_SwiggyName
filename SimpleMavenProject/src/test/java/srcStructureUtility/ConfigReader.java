package srcStructureUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.Logger;

public class ConfigReader {

	
	public  Properties prop;
	public static String configFile = "src/main/resources/Config.properties";
	
public ConfigReader() 
{	
	try
	{
	prop = new Properties();
	FileInputStream fis = new FileInputStream(configFile);
	prop.load(fis);
	}
	catch(Exception ex)
	{
		
	}
}
public String getProperty(String key)
{
	return prop.getProperty(key);	 
}
public int getIntProperty(String key)
{
	return Integer.parseInt(prop.getProperty(key));
}
}

