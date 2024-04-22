package ObjectRepository;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NoteBookPage extends BasePage {

	@FindBy(xpath = "//div[@class='page-title']//h1")
	WebElement NoteBookTitle;

	@FindBy(xpath = "//a[.='14.1-inch Laptop']/../..//div[@class='buttons']")
	WebElement LaptopCartButton;

	public NoteBookPage(WebDriver driver) {
		super(driver);
	}

	public void verifyTitle(String value) {
		String expectedTitle = NoteBookTitle.getText();
		String actualTitle = value;
		assertEquals(actualTitle, expectedTitle);
		Reporter.log("Note Book Title Verification is success", true);
	}

	public void laptopcartbutton() {
		LaptopCartButton.click();
		Reporter.log("LapTop cart button is clicked", true);
	}

}
