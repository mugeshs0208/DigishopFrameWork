package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class WelcomePage extends BasePage {

	@FindBy(xpath = "//a[@href='/logout']")
	WebElement LogoutLink;

	@FindBy(xpath = "//a[@href='/books']")
	WebElement BooksLink;

	@FindBy(xpath = "//a[@href='/computers']")
	WebElement ComputersLink;

	@FindBy(linkText = "APPAREL & SHOES")
	WebElement Apparel_shoesLink;

	@FindBy(partialLinkText = "DIGITAL DOWNLOADS")
	WebElement Digital_downloadsLink;

	@FindBy(linkText = "JEWELRY")
	WebElement JewelryLink;

	@FindBy(xpath = "//ul[@class='top-menu']//a[@href='/electronics']")
	WebElement electronicsLink;

	@FindBy(xpath = "//span[.='Shopping cart']")
	WebElement ShoppingCartLink;

	@FindBy(id = "small-searchterms")
	WebElement SearchField;

	@FindBy(xpath = "//input[@value='Search']")
	WebElement SearchButton;

	public WelcomePage(WebDriver driver) {
		super(driver);
	}

	public void clicklogoutlink() {
		LogoutLink.click();
		Reporter.log("Logout the application success");
	}

	public void electronicslink() {
		electronicsLink.click();
		Reporter.log("Electronics Link is Clicked", true);
	}

	public void bookslink() {
		BooksLink.click();
		Reporter.log("Books link is clicked", true);
	}

	public void computerslink() {
		ComputersLink.click();
		Reporter.log("Computers Link is clicked", true);
	}

	public void apparel_shoeslink() {
		Apparel_shoesLink.click();
		Reporter.log("Apparel_Shoes Link is Clicked", true);
	}

	public void digitaldownloadslink() {
		Digital_downloadsLink.click();
		Reporter.log("Digital Download Link is clicked", true);
	}

	public void jewerlylink() {
		JewelryLink.click();
		Reporter.log("Jewelry Link is clicked", true);
	}

	public void shoppingcartlink() {
		ShoppingCartLink.click();
		Reporter.log("Shooping cart link is clicked", true);
	}

	public void searchfield(String text) {
		SearchField.sendKeys(text);
		Reporter.log("Text entered in textfield", true);

	}

	public void searchbutton() {
		SearchButton.click();
		Reporter.log("Search button is clicked", true);
	}

}
