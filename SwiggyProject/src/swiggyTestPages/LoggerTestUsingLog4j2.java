package swiggyTestPages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoggerTestUsingLog4j2 {
	
	public static WebDriver driver;
	public static Logger log;
	@BeforeClass
	public void setup()
	{
		log = LogManager.getLogger();
		WebDriverManager.firefoxdriver().setup();
		log.info("Firefox setup is done");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		log.info("Implicitly waited for 10 secs");
		
	}
	@Test
	public void validatingLoggerUsingLog4j2()
	{
		driver.get("https://www.google.co.in/");
		log.info("Logged into Google Search Engine");
		try
		{
			boolean text = driver.findElement(By.cssSelector("img[alt = 'Google']")).isDisplayed();
		}
		catch(Exception e)
		{
			log.error("Exception Occured" + e.getMessage());
		}
	}
	@AfterClass
	public void tearDown()
	{
		//driver.quit();
	}

}
