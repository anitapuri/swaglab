package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage {
	@FindBy(xpath="//button[text()='Checkout']")
	private WebElement CheckoutButton;
	
	@FindBy(xpath="//button[text()='Remove']")
	private WebElement RemoveButton;
	
	@FindBy(xpath="//button[text()='Continue Shopping']")
	private WebElement ContinueButton;
	public YourCartPage (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	 
	public void clickOnCheckoutButton() {
		CheckoutButton.click();
	}
	
	public void clickOnRemoveButton() {
		RemoveButton.click();
	}
	public void clickOnContinueButton() {
		ContinueButton.click();
	}

}
