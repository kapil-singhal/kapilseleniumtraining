package trainingDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestWemart {
	WebDriver driver;
	@BeforeTest
	public void InitialiseDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\Drivers\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.addExtensions(paths);
		this.driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		
	}
	@Test(priority=1)	
	public void LoginTMS() {
		driver.get("https://india.etransport.accenture.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(driver.findElement(By.id("userNameInput")).isEnabled()) {
			driver.findElement(By.id("userNameInput")).sendKeys("kapil.a.singhal");
			driver.findElement(By.id("passwordInput")).sendKeys("#9Corelegs");
			driver.findElement(By.id("submitButton")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed(), "Unsuccessful Login.");
		}
	}
	@Test(priority=2)
	public void NavigateToVehicleMaster() {
		//Actions action = new Actions(driver);
		driver.findElement(By.xpath("img[@src='Lib/UI/img/icon-Admin-home.png']")).click();		
	}
	

}
