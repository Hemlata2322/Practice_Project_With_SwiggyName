package swiggyTestPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webDriverManager {
	WebDriver driver;
	@BeforeClass
	public void setup()
	{
	//	WebDriverManager.chromedriver().setup(); Not working with chrome
	//	driver = new ChromeDriver();
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com/");
	}
	
	@Test
	public void validatingBrowserInsetanceUsingWebDriverManager()
	{
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		
	}

}
