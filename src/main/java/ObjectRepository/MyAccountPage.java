package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

	WebDriver driver;
	
	public MyAccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//*[@Class='breadcrumb']//a[text()='Account']")
	private WebElement Account;
	
	
	//private By Account= By.xpath("//*[@Class='breadcrumb']//a[text()='Account']");
	
	public WebElement Account() {
		
		return Account;
		//return driver.findElement(Account);
	}
	
	
	
}
