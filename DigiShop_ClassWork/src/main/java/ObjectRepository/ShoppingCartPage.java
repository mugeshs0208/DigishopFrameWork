package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ShoppingCartPage extends BasePage {

	@FindBy(xpath = "//td[@class='remove-from-cart']//input[@type='checkbox']")
	WebElement ProductRemoveCheckBox;

	@FindBy(id = "termsofservice")
	WebElement TermsCheckBox;

	@FindBy(id = "checkout")
	WebElement CheckOutButton;

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	public void clicktermscheckbox() {
		TermsCheckBox.click();
		Reporter.log("Terms checkbox is clicked", true);
	}

	public void productremovecheckbox() {
		ProductRemoveCheckBox.click();
		Reporter.log("Remove Product button is clicked", true);
	}

	public void clickcheckoutbutton() {
		CheckOutButton.click();
		Reporter.log("CheckOut Button is Clicked", true);
	}

}
