package TestPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelsheetExecution {
	 public static void main(String[] args) throws InterruptedException {
			

		    
			System.setProperty("webdriver.chrome.driver","C:\\Users\\pc1\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

			WebDriver driver=new ChromeDriver();
			driver.get("https://www.saucedemo.com/");
			
			

}
}