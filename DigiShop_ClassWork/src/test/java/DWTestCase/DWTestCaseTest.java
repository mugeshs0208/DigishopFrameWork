package DWTestCase;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import ObjectRepository.BooksPage;
import ObjectRepository.CheckOutPage;
import ObjectRepository.ComputerPage;
import ObjectRepository.ElectronicsPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.NoteBookPage;
import ObjectRepository.RegisterPage;
import ObjectRepository.ShoppingCartPage;
import ObjectRepository.ThankYouPage;
import ObjectRepository.WelcomePage;
import genericLibrary.DWBaseClass;
import genericLibrary.UtilityMethods;

@Listeners(ListenerUtility.ListenersImplimentation.class)
public class DWTestCaseTest extends DWBaseClass {

	// Verify user able is open electronic page, it is display or not
	@Test // (enabled = false)
	public void hometest() {
		WelcomePage wp = new WelcomePage(driver);
		wp.electronicslink();
		test.log(LogStatus.INFO, "To click on Electronics link", "Click on electronics link");
		ElectronicsPage ep = new ElectronicsPage(driver);
		ep.verifytitle("Electronics");
		test.log(LogStatus.PASS, "Electronics Page Title is Verified");
	}

	// Verify user able is open Book page, it is display or not
	@Test(enabled = false)
	public void bookstitleTest() throws InterruptedException {

		WelcomePage wp = new WelcomePage(driver);
		wp.bookslink();
		BooksPage bp = new BooksPage(driver);
		try {
			bp.verifybookstitle("Books");
			test.log(LogStatus.PASS, "Books Page Title is Verified");
		} catch (AssertionError e) {
			test.log(LogStatus.FAIL, "Books Page Title is not verified");
			e.printStackTrace();
		}
		bp.sortbydropdown();
		getScreenShotWebPage(driver);

	}

	// Verify user able is open NoteBook page, it is display or not
	@Test(enabled = false)
	public void notebooktitleTest() {

		WelcomePage wp = new WelcomePage(driver);
		wp.computerslink();
		ComputerPage cp = new ComputerPage(driver);
		cp.notebooklink();
		NoteBookPage nb = new NoteBookPage(driver);
		try {
			nb.verifyTitle("Notebooks");
			test.log(LogStatus.PASS, "Note Book Title is Verified");
		} catch (AssertionError e) {
			test.log(LogStatus.FAIL, "Note Book Title is not verified");
			e.printStackTrace();
		}

	}

	// Verify user is able order one product
	@Test(enabled = false)
	public void productorder_001() throws EncryptedDocumentException, IOException, InterruptedException {
		WelcomePage wp = new WelcomePage(driver);
		wp.computerslink();
		ComputerPage cp = new ComputerPage(driver);
		cp.notebooklink();
		NoteBookPage np = new NoteBookPage(driver);
		np.laptopcartbutton();
		wp.shoppingcartlink();
		ShoppingCartPage sp = new ShoppingCartPage(driver);
		UtilityMethods.getScreenShotWebPage(driver);
		sp.clicktermscheckbox();
		sp.clickcheckoutbutton();
		CheckOutPage co = new CheckOutPage(driver);
		co.firstnamefield();
		co.lastnamefield();
		co.emailfield();
		co.countrydropdown();
		co.cityfield();
		co.address1field();
		co.address2field();
		co.zipcodefield();
		co.phonenumberfield();
		co.clickcontinuebutton();
		co.shippingaddresscontinuebutton();
		co.selectshippingoption();
		co.shippingmethodbutton();
		co.paymentmethd();
		co.paymentmethodcontinuebutton();
		Thread.sleep(2000);
		co.paymentinformation();
		co.confirmorderbutton();
		ThankYouPage tp = new ThankYouPage(driver);
		try {
			tp.verifyorderplaced("Your order has been successfully processed!");
			test.log(LogStatus.PASS, "Your order has been successfully verified");
		} catch (AssertionError e) {
			test.log(LogStatus.FAIL, "Your order has been successfully not verified");
			e.printStackTrace();
		}
		UtilityMethods.getScreenShotWebPage(driver);
		tp.thankyoucontinuebutton();
		test.log(LogStatus.PASS, "Your order is successfully done");

	}

	@Test
	public void book_001() throws InterruptedException {

		WelcomePage wp = new WelcomePage(driver);
		wp.bookslink();
		BooksPage bp = new BooksPage(driver);
		bp.sortbydropdown();
		bp.displaydropdown();
		bp.viewasdropdown();
		getScrollByAmount(0, 500);
		Thread.sleep(2000);
	}

	@Test
	public void registeraccount() throws Exception {

		WelcomePage wp = new WelcomePage(driver);
		HomePage hp = new HomePage(driver);
		RegisterPage rp = new RegisterPage(driver);
		wp.clicklogoutlink();
		hp.registerlink();
		rp.enterFirstName();
		rp.enterLastName();
		rp.enteremailtextfield();
		rp.enterpasswordfield();
		rp.enterconfirmpasswordfield();
		rp.clickregisterbutton();

	}

	@DataProvider
	public String[][] productdata() {
		return UtilityMethods.productsdata("Sheet1");
	}

	@Test(dataProvider = "productdata")
	public void productTest(String product) throws InterruptedException {
		WelcomePage wp = new WelcomePage(driver);
		wp.searchfield(product);
		Thread.sleep(2000);
		wp.searchbutton();
		Thread.sleep(2000);
		
	}
}
