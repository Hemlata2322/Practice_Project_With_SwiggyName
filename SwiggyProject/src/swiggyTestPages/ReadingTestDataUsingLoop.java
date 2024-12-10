package swiggyTestPages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ReadingTestDataUsingLoop {
	
	WebDriver driver;
	@BeforeClass
	public void setup()
	{
		System.getProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	@Test(dataProvider = "getData")
	public void validateReadingDataFromExecelUsingLoop(String userName, String password)
	{
		driver.get("http://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(userName);
		driver.findElement(By.id("pass")).sendKeys(password);
		
	}

	@DataProvider
	public Object[][] getData() throws IOException
	{
		File dataFile = new File("./TestData/TestData.xlsx");
		FileInputStream fis = new FileInputStream(dataFile);
		XSSFWorkbook wk = new XSSFWorkbook(fis);
		XSSFSheet sh = wk.getSheet("UserLoginTestData");
		System.out.println(sh.getSheetName());
		
		Object[][] arr = new Object[4][2];
		for(int i=1; i<arr.length; i++)
		{
			if(sh.getRow(i) != null)
			{
				if(sh.getRow(i).getCell(0) != null)
				{
					arr[i][0] = sh.getRow(i).getCell(0).getStringCellValue();
				}
				if(sh.getRow(i).getCell(1) != null)
				{
					arr[i][1] = sh.getRow(i).getCell(1).getStringCellValue();
				}
				if(sh.getRow(i).getCell(2) != null)
				{
					arr[i][2] = sh.getRow(i).getCell(2).getStringCellValue();
				}
			}
		}
		wk.close();
		return arr;
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
