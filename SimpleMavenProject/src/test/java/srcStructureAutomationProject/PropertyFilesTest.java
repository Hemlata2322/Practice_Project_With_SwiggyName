package srcStructureAutomationProject;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import srcStructureUtility.ConfigReader;

public class PropertyFilesTest {
	
	ConfigReader configReader;
	private static WebDriver driver;
	@BeforeClass
	public void setup()
	{
		configReader = new ConfigReader();
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(configReader.getIntProperty("implicitWait")));
			
	}
	@Test
	public void validatingPropertyReaderFunctionality()
	{		String baseUrl = configReader.getProperty("baseURL");
		driver.get(baseUrl);
		
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
