package PageObjectModelPageFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import ObjectRepository.LoginPage;
import ObjectRepository.MyAccountPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	WebDriver driver;
	
	@Test
	public void Login() {

		WebDriverManager.edgedriver().setup();
		 driver =new EdgeDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");
		
		LoginPage loginpage =new LoginPage(driver);
		loginpage.emailfield().sendKeys("tejal@gmail.com");
		loginpage.Passwordfield().sendKeys("tejal");
		loginpage.Loginbutton().click();
		
		MyAccountPage accountpage =new MyAccountPage(driver);
		Assert.assertTrue(accountpage.Account().isDisplayed());
		
	}
     @AfterMethod
	public void closure() {
		driver.close();
	}
}
