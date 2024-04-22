package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ComputerPage extends BasePage {

	@FindBy(css = "img[alt='Picture for category Notebooks']")
	WebElement NoteBookLink;
	
	public ComputerPage(WebDriver driver) {
		super(driver);
	}
	
	public void notebooklink() {
		NoteBookLink.click();
		Reporter.log("NoteBook link is clicked");
	}
}
