package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="input-email")
	private WebElement emailfield;
	@FindBy(id ="input-password")                        //PageFactory 
	WebElement Passwordfield ;
	@FindBy (css="input[value='Login']")
	WebElement Loginbutton;
	
	public WebElement emailfield() {
		
		return emailfield;
	}
	
	public WebElement Passwordfield() {
		
		return Passwordfield;
	}
	
	public WebElement Loginbutton() {
		
		return Loginbutton;
	}
	
	
	
	
	
//===========================PageObjectModel============================================	
	/*private By emailfield =By.id("input-email");
	private By Passwordfield =By.id("input-password");
	private By Loginbutton=By.cssSelector("input[value='Login']");
	
	public WebElement emailfield() {
		
		return driver.findElement(emailfield);
	}
	
	public WebElement Passwordfield() {
		
		return driver.findElement(Passwordfield);
	}
	
	public WebElement Loginbutton() {
		
		return driver.findElement(Loginbutton);
	} */
}
