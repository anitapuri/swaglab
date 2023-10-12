package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLagHomepage {
	@FindBy(xpath="(//button[text()='Add to cart'])[1]")
	private WebElement AddToCart;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
    private WebElement AddToCartIcon;
	
	@FindBy(xpath="//div[text()='Sauce Labs Backpack']")
    private WebElement SauceLabsBackpack;
	
	
	public SwagLagHomepage (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	public void cliclOnAddToCartFirstOption() {
		 AddToCart.click();
		 
	}
	public void cliclOnAddToCartIcon() {
		AddToCartIcon.click();
	}

	public void cliclOnSauceLabsBackpack() {
		SauceLabsBackpack.click();
	}
}
