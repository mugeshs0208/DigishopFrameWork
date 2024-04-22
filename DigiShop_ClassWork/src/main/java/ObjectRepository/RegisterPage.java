package ObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.github.javafaker.Faker;

import genericLibrary.UtilityMethods;

public class RegisterPage extends BasePage{

	@FindBy(id = "gender-male")
	WebElement MaleGenderButton;

	@FindBy(id = "gender-female")
	WebElement FemaleGenderButton;

	@FindBy(id = "FirstName")
	WebElement FirstName;

	@FindBy(id = "LastName")
	WebElement LastName;

	@FindBy(id = "Email")
	WebElement emailField;

	@FindBy(id = "Password")
	WebElement passwordField;

	@FindBy(id = "ConfirmPassword")
	WebElement confirmPasswordField;

	@FindBy(xpath = "//input[@value='Register']")
	WebElement RegisterButton;

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	public void entermalebutton() {
		MaleGenderButton.click();
		Reporter.log("Male Gender Button is clicked", true);
	}

	public void enterfemalebutton() {
		FemaleGenderButton.click();
		Reporter.log("Female Gender Button is clicked", true);
	}

	public void enterFirstName() {
		Faker faker=new Faker();
		String firstname=faker.name().firstName();
		FirstName.sendKeys(firstname);
		Reporter.log("Your First Name is Entered");
	}

	public void enterLastName() {
		Faker faker=new Faker();
		String lastname = faker.name().lastName();
		LastName.sendKeys(lastname);
		Reporter.log("Last Name is entered", true);
	}

	public void enteremailtextfield() throws EncryptedDocumentException, IOException {
		emailField.sendKeys(UtilityMethods.exceldata("Sheet1", 0, 1));
		Reporter.log("UserName is entered successfully");
	}

	public void enterpasswordfield() throws EncryptedDocumentException, IOException {
		passwordField.sendKeys(UtilityMethods.exceldata("Sheet1", 1, 1));
		Reporter.log("Password is entered successfully",true);

	}
	
	public void enterconfirmpasswordfield() throws EncryptedDocumentException, IOException {
		confirmPasswordField.sendKeys(UtilityMethods.exceldata("Sheet1", 2, 1));
		Reporter.log("Confirm Password is entered successfully",true);
	}
	
	public void clickregisterbutton() {
		RegisterButton.click();
		Reporter.log("Register button is clicked successfully");
	}

}
