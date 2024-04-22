package ObjectRepository;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ElectronicsPage extends BasePage {

	@FindBy(xpath = "//div[@class='page-title']//h1[.='Electronics']")
	WebElement ElectronicsTitle;
	
	@FindBy(xpath = "//div[@class='picture']//img[@alt='Picture for category Cell phones']")
	WebElement CellPhoneLink;

	public ElectronicsPage(WebDriver driver) {
		super(driver);
	}

	public void verifytitle(String value) {
		String expectedTitle = ElectronicsTitle.getText();
		String actualTitle = value;
		assertEquals(actualTitle, expectedTitle);
		Reporter.log("Electronics Title is Verified", true);
	}
	

	
	public void cellphonelink() {
		CellPhoneLink.click();
		Reporter.log("Cell Phone Link is clicked",true);
	}

}
