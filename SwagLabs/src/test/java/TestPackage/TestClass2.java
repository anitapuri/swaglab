package TestPackage;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.BackToProductPage;
import Pages.LoginPage1;
import Pages.SwagLagHomepage;
import Utils.Utility;

public class TestClass2 {
	private WebDriver driver;
	@BeforeMethod
	
	public void LaunchBrowser() 
	{
		
	System.setProperty("webdriver.chrome.driver","C:\\Users\\pc1\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

	 driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	driver.get("https://www.saucedemo.com/");
	}
	@Test
	public void VerifyBackToProductButton() throws InterruptedException, EncryptedDocumentException, IOException {
		
		LoginPage1 loginpage1=new LoginPage1(driver);
		String password;
		String path="C:\\Users\\pc1\\Documents\\TestData.xlsx";
		String username;
		
		username=Utility.getDataFromExcelSheet(path, "Sheet1",1,0);
		 password=Utility.getDataFromExcelSheet(path, "Sheet1",1,1);
		
		
		loginpage1.sendUserName(username);
		loginpage1.sendPassword(password);
		loginpage1.clickOnLogIn();
		SwagLagHomepage swaglabhomepage=new SwagLagHomepage(driver);
		swaglabhomepage.cliclOnSauceLabsBackpack();
		
		BackToProductPage backtoproductpage=new BackToProductPage(driver);
		Thread.sleep(2000);
        backtoproductpage.ClickOnBackToProduct();
        String actualurl="https://www.saucedemo.com/inventory.html";
        String expectedurl=driver.getCurrentUrl();
        Assert.assertEquals(actualurl, expectedurl);
        System.out.println("testclass2");
}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
