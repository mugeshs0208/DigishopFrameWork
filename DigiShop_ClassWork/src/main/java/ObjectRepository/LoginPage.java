package ObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import genericLibrary.UtilityMethods;

public class LoginPage extends BasePage {

	@FindBy(id = "Email")
	WebElement UserNameField;

	@FindBy(id = "Password")
	WebElement PasswordField;

	@FindBy(xpath = "//input[@value='Log in']")
	WebElement LoginPageLoginButton;
	

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void enterusername() throws EncryptedDocumentException, IOException {
		UserNameField.sendKeys(UtilityMethods.commondata("Sheet1", 2, 1));
		Reporter.log("UserName is Entered Successfully", true);
	}

	public void enterpassword() throws EncryptedDocumentException, IOException {
		PasswordField.sendKeys(UtilityMethods.commondata("Sheet1", 3, 1));
		Reporter.log("Password is entered successfully", true);
	}

	public void clickloginbutton() {
		LoginPageLoginButton.click();
		Reporter.log("Login button is clicked successfully", true);
	}
}
