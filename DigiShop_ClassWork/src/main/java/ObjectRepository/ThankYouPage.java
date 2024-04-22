package ObjectRepository;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ThankYouPage extends BasePage {

	@FindBy(css = "input[value='Continue']")
	WebElement ThankyouContinueButton;

	@FindBy(xpath = "//div[@class='title']//strong")
	WebElement VerifySuccessTitle;

	public ThankYouPage(WebDriver driver) {
		super(driver);
	}

	public void thankyoucontinuebutton() {
		ThankyouContinueButton.click();
		Reporter.log("Thank you page continue button is clicked", true);
	}

	public void verifyorderplaced(String value) {
		String actualresult = VerifySuccessTitle.getText();
		String expectedresult = value;
		assertEquals(actualresult, expectedresult);
		Reporter.log("Order is placed successfully", true);
	}
}
