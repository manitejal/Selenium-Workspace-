package AutoIT;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploading {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver =new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://omayo.blogspot.com/");
		
		Actions action =new Actions(driver);
		action.moveToElement(driver.findElement(By.id("uploadfile"))).click().build().perform();
		
		//We need to use autoIT for fileuploading 
		Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Selenium workspace training\\MAVENproject\\AutoITExecutableFiles\\BrowsingExcelFile.exe");
		
		
	}

}
