package trainingDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoDataDriverLogin {
	WebDriver driver;
  @Test
  public void Login() {
	  	System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\Drivers\\chromedriver.exe");
	  	driver = new ChromeDriver();
	  	driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		readWriteExcel();
  }
  public void readWriteExcel()
  {
	  String username, password, result;
	  File file = new File("Selenium-Data.xlsx");
		try {
			InputStream inputStream = new FileInputStream(file);
			XSSFWorkbook xssf = new XSSFWorkbook(inputStream);
			XSSFSheet sheet1 = xssf.getSheet("sheet1");
			for(int i = 1; i <= sheet1.getLastRowNum(); i++) {
				username = sheet1.getRow(i).getCell(0).getStringCellValue();
				password = sheet1.getRow(i).getCell(1).getStringCellValue();
				result = mercuryAppLogin(username, password);
				sheet1.getRow(i).createCell(2).setCellValue(result);
			}
			OutputStream os=new FileOutputStream(file);
			xssf.write(os);
			xssf.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
  }
  public String mercuryAppLogin(String username, String password) {
	  	driver.findElement(By.name("userName")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();

		if(driver.getTitle().startsWith("Find"))
		{
			Assert.assertTrue(true);
			driver.findElement(By.linkText("SIGN-OFF")).click();
			return "VALID USER";
		}
		else
		{
			Assert.assertTrue(driver.getTitle().startsWith("Sign-on"));
			return "INVALID USER";
		}
  }
}
