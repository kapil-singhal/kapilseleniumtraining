package trainingDemo;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataDriverLoginUsingXML {
	private WebDriver driver;
	@Test
	  public void Login() {
		  	System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\Drivers\\chromedriver.exe");
		  	driver = new ChromeDriver();
		  	driver.manage().window().maximize();
			driver.get("http://newtours.demoaut.com/");		
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			readXML();
	  }
	public void readXML()
	  {
		try {
			JAXBContext jaxb=JAXBContext.newInstance(TestUsers.class);
			Unmarshaller unmarsh=jaxb.createUnmarshaller();
			TestUsers testuser=(TestUsers) unmarsh.unmarshal(new File("users.xml"));
			List<Users> users=testuser.getUser();
			
			for (Users u:users) {
				mercuryAppLogin(u.getUsername(),u.getPassword());
				System.out.println(u.getType());
			}
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
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
