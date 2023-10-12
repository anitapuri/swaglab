package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser 
{
	public static WebDriver launchchrome() 
	{ 
	System.setProperty("webdriver.chrome.driver","src\\test\\resources\\BrowserFiles\\chromedriver.exe");

	WebDriver driver=new ChromeDriver();
    System.out.println("Chrome");
    return driver;
	}
    
	public static WebDriver launchFirefox()
	{
     System.setProperty("webdriver.gecko.driver","C:\\Users\\pc1\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");
    
     WebDriver driver=new FirefoxDriver();
     System.out.println("firefox");
     return driver;
     }
}