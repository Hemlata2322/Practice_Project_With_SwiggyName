package srcStructureAutomationProject;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoggerTest {
	
	public static WebDriver driver;
	public static Logger log;
	@BeforeClass
	public void setup()
	{
		log = LogManager.getLogger();
		WebDriverManager.firefoxdriver().setup();
		log.info("Setting up Firefox Browser");
		driver = new FirefoxDriver();
		log.info("Initiating the Firefox driver");
		driver.manage().window().maximize();
		log.info("Maximizing the window");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		log.info("Implicitly waiting for 10 secs");	
		
	}
	@Test
	public void validatingLogger()
	{
		driver.get("https://www.google.co.in/");
		log.info("Navigating to Google Search Engine");
		try
		{
			boolean text = driver.findElement(By.cssSelector("img[alt = 'Google']")).isDisplayed();			
			log.info("Navigated to Google");
		}
		catch(Exception ex)
		{
			log.error("Exception occured", new Exception("URL not found"));
			//log.error("Exception occured" + ex.getMessage());
			
		}		
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
