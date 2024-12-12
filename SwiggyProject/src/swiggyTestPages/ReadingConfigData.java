package swiggyTestPages;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ReadingConfigData {
	
	WebDriver driver;
	FirefoxOptions options;
	@BeforeClass
	public void setup()
	{
	//System.setProperty("webdriver.chrom.driver", "./Driver/chormedriver.exe");
		options = new FirefoxOptions();
		//options.addArguments("disable - dialog"); // addArguments will not work with firefox
		
		// Disable the pop-up blocking in firefox using addPreference()
		options.addPreference("dom.disable_open_during_load", true);
		
		WebDriverManager.firefoxdriver().setup();
		driver = getBrowser("browser");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(getIntProperty("implicitlyWait")));
			
	}
	@Test
	public void validatePropertyFunctions()
	{
		driver.get(getProperty("baseURL"));
				
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	public WebDriver getBrowser(String key)
	{
		if(key.equalsIgnoreCase("chrome"))
		{
			return driver = new ChromeDriver();
		}
		else if(key.equalsIgnoreCase("Firefox"))
		{
			return driver = new FirefoxDriver(options);
		}
		else
		{
			//return driver = new ChromeDriver();
			return driver = new FirefoxDriver();
		}
	}
	
	public static String getProperty(String key)
	{
		Properties prop = new Properties();
		String configFile = "src/main/resources/config.properties";
		try
		{
		FileInputStream fis = new FileInputStream(configFile);
		prop.load(fis);
		}
		catch(Exception ex)
		{
			
		}
		return prop.getProperty(key);
	}
public static int getIntProperty(String key)
{
	Properties prop = new Properties();
	String ConfigFile = "src/main/resources/config.properties";
	try
	{
	FileInputStream fis = new FileInputStream(ConfigFile);
	prop.load(fis);
	}
	catch(Exception ex)
	{
		
	}
	return Integer.parseInt(prop.getProperty(key));
}
}
