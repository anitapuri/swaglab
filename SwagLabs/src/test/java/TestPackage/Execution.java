package TestPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import Pages.LoginPage1;
import Pages.SwagLagHomepage;
import Pages.YourCartPage;

public class Execution {
	 public static void main(String[] args) throws InterruptedException {
		

	    
		System.setProperty("webdriver.chrome.driver","C:\\Users\\pc1\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
		LoginPage1 loginpage1=new LoginPage1(driver);
		loginpage1.sendUserName();
		loginpage1.sendPassword();
		loginpage1.clickOnLogIn();
	
		SwagLagHomepage swaglabhomepage=new SwagLagHomepage(driver);
		swaglabhomepage.cliclOnAddToCartFirstOption();
		swaglabhomepage.cliclOnAddToCartIcon();
	 
	     YourCartPage yourcartpage=new YourCartPage(driver);
	     yourcartpage.clickOnCheckoutButton();
	     Thread.sleep(5000);
	     driver.navigate().back();
	     
	    
	     
	    yourcartpage.clickOnRemoveButton();
	  yourcartpage.clickOnContinueButton();
	 String url= driver.getCurrentUrl();
	 if(url.equals("https://www.saucedemo.com/inventory.html")) {
		 System.out.println("pass");
	 }
	 else {
		 System.out.println("fail");
	 }
	 }
	

}
