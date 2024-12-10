package swiggyTestPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ParallelExecutionUsingTestngxml {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver localDriver = new ChromeDriver();
		driver.set(localDriver);
		localDriver.get("http://www.facebook.com/");
		
	}
	
	@Test(dataProvider = "getData")
	public void checkingParallelExecution(String userName, String password)
	{
		driver.get().findElement(By.id("email")).sendKeys(userName);
		driver.get().findElement(By.id("pass")).sendKeys(password);
	}
	
	@DataProvider(parallel = true)
	public Object[][] getData()
	{
		Object[][] arr = {{"email1", "pass"},{"email2", "pass"}};
		
		return arr;
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		//driver.get().quit();
	}
}
