package TestPackage;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.LogOutPage;
import Pages.LoginPage1;
import Pages.SwagLagHomepage;
import Pages.YourCartPage;
import Utils.Utility;
import base.Browser;

public class ExecutionUsingTestNG extends Browser {
	private WebDriver driver;
	private LoginPage1 loginpage1;
	private SwagLagHomepage swaglabhomepage;
	private YourCartPage yourcartpage;
	private LogOutPage logoutpage;
	private String testID;
	static ExtentHtmlReporter reporter;
	static ExtentTest test;
	
	
	@Parameters("browser")
	@BeforeTest
	public void LaunchBrowser(String browserName) 
	
	{
		reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		if(browserName.equals("Chrome"))
		{
	      driver=launchchrome() ;
	
	     }
		
		if(browserName.equals("Firefox"))
		{
	      driver=launchFirefox();
	
	    }
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}
	
	@BeforeClass
	public void creatingPOMObject() 
	{
		 loginpage1=new LoginPage1(driver);
		 swaglabhomepage=new SwagLagHomepage(driver);
		 yourcartpage=new YourCartPage(driver);
		 logoutpage=new LogOutPage(driver);
	}
	
	@BeforeMethod
	public void OpenAddToCardPage() throws EncryptedDocumentException, IOException 
	{
	driver.get("https://www.saucedemo.com/");
	String password;
	String path="src\\test\\resources\\DataResources\\TestData.xlsx";
	String username;
	
	username=Utility.getDataFromExcelSheet(path, "Sheet1",1,0);
	password=Utility.getDataFromExcelSheet(path, "Sheet1",1,1);
	
	
	loginpage1.sendUserName(username);
	loginpage1.sendPassword(password);
	loginpage1.clickOnLogIn();

	
	swaglabhomepage.cliclOnAddToCartFirstOption();
	swaglabhomepage.cliclOnAddToCartIcon();
	}
	
	@Test(priority=1,groups="sanity")
     public void VerifyChekoutButtonFunctinality() throws InterruptedException 
	{
		testID="001";
	 System.out.println("test1");
     
     yourcartpage.clickOnCheckoutButton();
     String actual="https://www.saucedemo.com/checkout-step-one.html";
     String url= driver.getCurrentUrl();
     Assert.assertEquals(actual, url);
     

	 }
    
    
     @Test(priority=3,groups="sanity")
     public void VerifyContinueButtonFunctionality() throws InterruptedException 
     {
    	 testID="003";
     System.out.println("test3");
    
     yourcartpage.clickOnContinueButton();
     String actual="https://www.saucedemo.com/inventory.html20";
     String url= driver.getCurrentUrl();
     Assert.assertEquals(actual, url);
     }

     @Test(priority=2,invocationCount=1)
     public void VerifyRemoveButtonFunctionality() 
     {
    	 testID="002";
     System.out.println("test2");
     
     yourcartpage.clickOnRemoveButton();
     }
     @AfterMethod
     public void LogOutFromPage(ITestResult result) throws InterruptedException, IOException
     {
    	 if (ITestResult.FAILURE==result.getStatus())
    	 {
    		 Utility.CaptureScreenshot(testID);
    	 }
    	 
    	 Thread.sleep(2000);
    	 logoutpage.clickOnMenu();
    	 Thread.sleep(3000);
    	 logoutpage.clickOnLogOut();
     }
     @AfterClass
     public void closebrowser() 
     {
    	 loginpage1=null;
    	 swaglabhomepage=null;
		 yourcartpage=null;
		 logoutpage=null;
    	 
     }
     @AfterTest
     public void closeTheBrowser() throws InterruptedException 
     {
    	 Thread.sleep(3000);
    	 driver.quit();
    	 driver=null;
    	 System.gc();
     }
     



}
