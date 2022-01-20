package Mavenpack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EXTentReportsTest {

	WebDriver driver;
	ExtentReports extent;

	
	@BeforeMethod
	public void config() {
		
		//for getting path of the project 
		String pathoftheProject =System.getProperty("user.dir");  //this is a dynamic path
		System.out.println(pathoftheProject);
		
		//creating a path for reports 
		String reportpath  =System.getProperty("user.dir")+"\\reports\\index.html";  
		
		//code for ExtentReport 
		ExtentSparkReporter reporter =new ExtentSparkReporter(reportpath);
		reporter.config().setReportName("Omayo Test Report");
		reporter.config().setDocumentTitle("Omayo Test report Title");
		
        extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("OperatingSystem", "Windows10");
		extent.setSystemInfo("Testted By", "Maniteja");
		
	}
	@Test
	public void methodone() {
		
	ExtentTest etest = extent.createTest("method one created");

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		etest.info("Edge browser launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://omayo.blogspot.com/");
		etest.info("navigated to application");
		String Stringactualtext = driver.findElement(By.id("pah")).getText();

		Assert.assertEquals(Stringactualtext, "PracticeAutomationHere");
		
		//etest.fail("Test got failed "); //this is for failing the extent report 

	}

	@AfterMethod
	public void closure() {

		driver.close();
		extent.flush();

	}
}
