package ObjectRepository;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends BasePage {

	static Logger logger = Logger.getLogger(HomePage.class);

	@FindBy(css = "[alt='Tricentis Demo Web Shop']")
	WebElement Logo;

	@FindBy(linkText = "Register")
	WebElement RegisterLink;

	@FindBy(partialLinkText = "Log in")
	WebElement LoginLink;

	@FindBy(xpath = "//span[.='Shopping cart']")
	WebElement ShippingCart;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void registerlink() {
		RegisterLink.click();
		Reporter.log("RegisterLink is Clicked", true);
		logger.info("Register link is Clicked");
	}

	public void loginLink() {
		LoginLink.click();
		Reporter.log("LoginLink is Clicked", true);
	}

	public void verifylogo(Boolean logo) {
		logo = Logo.isDisplayed();
	}

	public void shippingcart() {
		ShippingCart.click();
		Reporter.log("Shipping cart link is clicked", true);
	}
}
