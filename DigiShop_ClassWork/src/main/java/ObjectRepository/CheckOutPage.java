package ObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import genericLibrary.UtilityMethods;

public class CheckOutPage extends BasePage {

	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement FirstNameField;

	@FindBy(id = "BillingNewAddress_LastName")
	WebElement LastNameField;

	@FindBy(id = "BillingNewAddress_Email")
	WebElement EmailField;

	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement CountryId;

	@FindBy(id = "BillingNewAddress_City")
	WebElement CityField;

	@FindBy(id = "BillingNewAddress_Address1")
	WebElement Address1Field;

	@FindBy(id = "BillingNewAddress_Address2")
	WebElement Address2Field;

	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement ZipCodeField;

	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement PhoneNumberField;

	@FindBy(xpath = "//div[@id='billing-buttons-container']//input")
	WebElement ContinueButton;

	@FindBy(css = "input[onclick='Shipping.save()']")
	WebElement ShippingAddressContinueButton;

	@FindBy(css = "input[value='Ground___Shipping.FixedRate']")
	WebElement SelectShippingOption;

	@FindBy(css = "input[onclick='ShippingMethod.save()']")
	WebElement ShippingMethodButton;

	@FindBy(css = "input[value='Payments.CashOnDelivery']")
	WebElement PaymentOption;

	@FindBy(css = "input[onclick='PaymentMethod.save()']")
	WebElement PaymentMethodContinueButton;

	@FindBy(xpath = "//div[@id='payment-info-buttons-container']//input")
	WebElement PaymentInformation;

	@FindBy(css = "input[onclick='ConfirmOrder.save()']")
	WebElement ConfirmOrderButton;

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}

	public void firstnamefield() throws EncryptedDocumentException, IOException {
		FirstNameField.clear();
		FirstNameField.sendKeys(UtilityMethods.exceldata("Sheet1", 3, 1));
		Reporter.log("First Name is entered", true);
	}

	public void lastnamefield() throws EncryptedDocumentException, IOException {
		LastNameField.clear();
		LastNameField.sendKeys(UtilityMethods.exceldata("Sheet1", 4, 1));
		Reporter.log("Last Name is entered", true);
	}

	public void emailfield() throws EncryptedDocumentException, IOException {
		EmailField.clear();
		EmailField.sendKeys(UtilityMethods.exceldata("Sheet1", 0, 1));
		Reporter.log("Your Email address is entered", true);
	}

	public void countrydropdown() {
		UtilityMethods.getSelectByVisibleText(CountryId, "India");
		Reporter.log("Your country is selected", true);
	}

	public void cityfield() throws EncryptedDocumentException, IOException {
		CityField.sendKeys(UtilityMethods.exceldata("Sheet1", 5, 1));
		Reporter.log("Your city name is entered", true);
	}

	public void address1field() throws EncryptedDocumentException, IOException {
		Address1Field.sendKeys(UtilityMethods.exceldata("Sheet1", 6, 1));
		Reporter.log("Address1 Field is entered", true);
	}

	public void address2field() throws EncryptedDocumentException, IOException {
		Address2Field.sendKeys(UtilityMethods.exceldata("Sheet1", 7, 1));
		Reporter.log("Address2 Field is entered", true);
	}

	public void zipcodefield() throws EncryptedDocumentException, IOException {
		ZipCodeField.sendKeys(UtilityMethods.exceldata("Sheet1", 8, 1));
		Reporter.log("ZipCode Field is entered", true);
	}

	public void phonenumberfield() throws EncryptedDocumentException, IOException {
		PhoneNumberField.sendKeys(UtilityMethods.exceldata("Sheet1", 9, 1));
		Reporter.log("Phone Number Field is entered", true);
	}

	public void clickcontinuebutton() {
		ContinueButton.click();
		Reporter.log("Continue Button is clicked", true);
	}

	public void shippingaddresscontinuebutton() {
		ShippingAddressContinueButton.click();
		Reporter.log("Shiiping Address Button is clicked", true);
	}

	public void selectshippingoption() {
		SelectShippingOption.click();
		Reporter.log("Select Shipping Option is clicked", true);
	}

	public void shippingmethodbutton() {
		ShippingMethodButton.click();
		Reporter.log("Shipping method button is clicked", true);
	}

	public void paymentmethd() {
		PaymentOption.click();
		Reporter.log("Payment Method button is clicked", true);
	}

	public void paymentmethodcontinuebutton() {
		PaymentMethodContinueButton.click();
		Reporter.log("Payment Method Button is Clicked", true);
	}

	public void paymentinformation() {
		PaymentInformation.click();
		Reporter.log("Payment Information button is clicked", true);
	}

	public void confirmorderbutton() {
		ConfirmOrderButton.click();
		Reporter.log("Confirm Order button is clicked", true);
	}

}
