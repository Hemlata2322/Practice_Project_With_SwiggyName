package swiggyTestPages;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class SwiggyRegistrationWithHardCodedDataProvider {
	
	WebDriver driver;
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider = "sendData")
	public void validateRegistration(String userName, String password) throws Exception
	{
	//	DesiredCapabilities cap = null; --> Deprecated in selenium 4.0
		//if(browserName.equalsIgnoreCase("chrome"))
		{
			// cap = new DesiredCapabilities();
		//	cap = DesiredCapabilities.chrome();
		//	cap.setBrowserName("chrome");
		//	cap.setPlatform(Platform.ANY);
			
			

	     //   if (browserName.equalsIgnoreCase("chrome")) {
	      //      ChromeOptions options = new ChromeOptions();
	        //    options.setBrowserVersion("chrome");
	        //    options.setPlatformName(Platform.ANY.toString());
	        
						
		//	RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
			driver.get("http://www.facebook.com/");
			driver.findElement(By.id("email")).sendKeys(userName);
			driver.findElement(By.id("pass")).sendKeys(password);
		}
		
	}
	
	@DataProvider(parallel = false)
	public Object[][] sendData()
	{
		Object arr[][] = new Object[2][2];
		
		arr[0][0] = "dataPro";
		arr[0][1] = "dp1";
		
		arr[1][0] = "dataPro";
		arr[1][1] = "dp2";
		
		return arr;
				
	}
	@AfterClass
	public void tearDown()
	{
		
	}

}
