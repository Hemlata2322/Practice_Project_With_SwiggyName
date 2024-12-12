package srcStructureAutomationProject;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.*;

public class PractisingPropertyInSameClass {
	
	@BeforeClass
	public void setup()
	{
		
	}
	@Test
	public void validatePropertyFunctions()
	{
		
	}
	@AfterClass
	public void tearDown()
	{
	
	}
	
	public String getProperty(String key)
	{
		String configFile = "src/main/resources/Config.properties";
		Properties prop = new Properties();
		try
		{
		FileInputStream fis = new FileInputStream(configFile);
		}
		catch(Exception ex)
		{
			
		}
		
	}
}
