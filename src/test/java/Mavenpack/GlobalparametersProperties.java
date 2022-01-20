package Mavenpack;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GlobalparametersProperties {

	public static void main(String[] args) throws IOException, InterruptedException {
	
		Properties prop =new Properties();
		FileInputStream Fil=new FileInputStream("data.properties");
		prop.load(Fil);
	
		
		WebDriverManager.edgedriver().setup();
      WebDriver driver=new EdgeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.get(prop.getProperty("Url"));
      
      
      driver.findElement(By.linkText("My Account")).click();
      Thread.sleep(3000);
      driver.findElement(By.linkText("Login")).click();
      driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("email"));
      driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("password"));
      driver.findElement(By.xpath("//input[@value=\"Login\"]")).sendKeys(Keys.ENTER);
      
     driver.quit(); 
	}

}
