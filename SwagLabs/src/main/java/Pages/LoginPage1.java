package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage1 {
	@FindBy(xpath="//input[@id='user-name']")
    private WebElement UserName;
	
	@FindBy(xpath="//input[@id='password']")
    private WebElement Password;
	
	@FindBy(xpath="//input[@id='login-button']")
    private WebElement LogIn;
	
	public LoginPage1(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	public void sendUserName(String user) {
		UserName.sendKeys(user);
	}
	public void sendPassword(String pass) {
		Password.sendKeys(pass);
	}
	public void clickOnLogIn() {
		LogIn.click();
	}
   }
