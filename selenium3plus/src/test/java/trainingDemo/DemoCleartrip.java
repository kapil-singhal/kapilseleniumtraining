package trainingDemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DemoCleartrip {
  @Test
  public void testClearTrip() throws InterruptedException {
	  	System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebElement from, to;
		from = driver.findElement(By.id("FromTag"));
		to = driver.findElement(By.id("ToTag"));
		Actions action = new Actions(driver);
		//action.keyDown(from, Keys.SHIFT).perform();
		//Thread.sleep(1000);
		action.sendKeys(from, "hyd").perform();
		Thread.sleep(2000);
		//action.keyUp(Keys.SHIFT);
		//Thread.sleep(1000);
		action.sendKeys(Keys.ENTER).perform();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		action.sendKeys(to, "bang").perform();
		Thread.sleep(2000);
		List<WebElement> cities = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
		for(WebElement e:cities) {
			System.out.println(e.getText());
			if(e.getText().contains("BKK")) {
				e.click();
				break;
			}
		}
  }
}
