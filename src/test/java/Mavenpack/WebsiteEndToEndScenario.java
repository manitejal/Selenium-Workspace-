package Mavenpack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebsiteEndToEndScenario {

	public static void main(String[] args) {

		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
     
		driver.get("http://tutorialsninja.com/demo");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Navigating to login page
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();

		// logging to website with valid credentilas
		driver.findElement(By.id("input-email")).sendKeys("Tejal1@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("tejal");
		driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();

		// checking whether we logged into account or not
		System.out.println(driver.findElement(By.xpath(" //a[text()='Account']")).isDisplayed()); // true
		// searching for iphone
		driver.findElement(By.name("search")).sendKeys("iphone");
		driver.findElement(By.cssSelector("i[class$='fa fa-search']")).click();
		System.out
				.println(driver.findElement(By.xpath("//*[@class='product-thumb']//a[text()='iPhone']")).isDisplayed()); // true
		driver.findElement(By.xpath("//*[@class='product-thumb']//a[text()='iPhone']")).click();
		// adding the item from product display page to cart

		System.out
				.println(driver.findElement(By.xpath("//ul[@class=\"breadcrumb\"]//a[text()='iPhone']")).isDisplayed()); // true
		WebElement quantity = driver.findElement(By.id("input-quantity"));
		quantity.clear();
		quantity.sendKeys("2");
		driver.findElement(By.id("button-cart")).click();
		System.out.println(
				driver.findElement(By.cssSelector("div[class=\"alert alert-success alert-dismissible\"]")).getText());
		System.out.println(driver.findElement(By.cssSelector("div[class=\"alert alert-success alert-dismissible\"]"))
				.getText().contains("Success: You have added iPhone to your shopping cart!"));
		// true
		driver.findElement(By.linkText("shopping cart")).click();
		System.out.println(driver.findElement(By.linkText("Shopping Cart")).isDisplayed()); // true
		// Navigating to checkout page
		driver.findElement(By.xpath("//a[@class=\"btn btn-primary\"]")).click();

	}

}
