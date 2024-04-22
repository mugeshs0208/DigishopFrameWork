package ObjectRepository;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import genericLibrary.UtilityMethods;

public class BooksPage extends BasePage {

	@FindBy(xpath = "//div[@class='page-title']//h1")
	WebElement BooksTitle;

	@FindBy(id = "products-orderby")
	WebElement SortByDropDown;

	@FindBy(id = "products-pagesize")
	WebElement displayDropDown;

	@FindBy(id = "products-viewmode")
	WebElement viewAsDropDown;

	public BooksPage(WebDriver driver) {
		super(driver);
	}

	public void verifybookstitle(String value) {
		String actualTitle = BooksTitle.getText();
		String expectedTitle = value;
		assertEquals(actualTitle, expectedTitle);
		Reporter.log("Books Page Title is Verified", true);
	}

	public void sortbydropdown() throws InterruptedException {
		UtilityMethods.getSelectByIndex(SortByDropDown, 1);
		Thread.sleep(1500);
		UtilityMethods.getSelectByIndex(SortByDropDown, 2);
		Reporter.log("SortBy DropDown is Executed",true);

	}

	public void displaydropdown() {
		UtilityMethods.getSelectByIndex(displayDropDown, 2);
		Reporter.log("Display DropDown is Executed",true);
	}
	
	public void viewasdropdown() {
		UtilityMethods.getSelectByVisibleText(viewAsDropDown, "List");
		Reporter.log("ViewAs DropDown is Executed",true);
	}
	

}
