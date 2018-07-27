package trainingDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDemoTours {
	
	private WebElement inputUsername;
	private WebElement inputPassword;
	private WebElement buttonSignin;
	
	@Test
	public void Login() {
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
		inputUsername = driver.findElement(By.name("userName"));
		inputUsername.sendKeys("marcury");
		inputPassword = driver.findElement(By.name("password"));
		inputPassword.sendKeys("marcury");
		buttonSignin = driver.findElement(By.name("login"));
		buttonSignin.click();
		Assert.assertTrue(!driver.findElement(By.linkText("SIGN-OFF")).isDisplayed());
	}
}