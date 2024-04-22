package genericLibrary;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.WelcomePage;

public class DWBaseClass extends UtilityMethods {

	public static ExtentReports report;
	public static ExtentTest test;
	public WebDriver driver;

	@BeforeSuite(alwaysRun = true)
	public void beforesuite() {
		report = new ExtentReports(REPORT_PATH + getTime() + ".html");
		Reporter.log("Before Suite is executed successfully", true);

	}

	@BeforeTest(alwaysRun = true)
	public void beforetest() {

		Reporter.log("Before Test is Executed", true);
	}

	@BeforeClass(alwaysRun = true)
	public void beforeclass() {

		// System.setProperty("org.freemarker.loggerLibrary", "none");

		String browser = UtilityMethods.commondata("Sheet1", 0, 1);
		String url = UtilityMethods.commondata("Sheet1", 1, 1);

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		UtilityMethods.initObject(driver);
		Reporter.log("Browser is Launched", true);
	}

	@BeforeMethod(alwaysRun = true)
	public void beforemethod(Method method) throws EncryptedDocumentException, IOException {
		String methodName = method.getName();
		test = report.startTest(methodName);
		HomePage homepage = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		homepage.loginLink();
		lp.enterusername();
		lp.enterpassword();
		lp.clickloginbutton();
		Reporter.log("Before Method is executed successfully", true);
	}

	@AfterMethod(alwaysRun = true)
	public void aftermethod() {
		WelcomePage wp = new WelcomePage(driver);
		wp.clicklogoutlink();
		Reporter.log("Application Successfully logout", true);
		report.endTest(test);
	}

	@AfterClass(alwaysRun = true)
	public void afterclass() {
		driver.quit();
		Reporter.log("Browser is successfully closed", true);

	}

	@AfterTest(alwaysRun = true)
	public void aftertest() {
		Reporter.log("After Test is successfully executed", true);

	}

	@AfterSuite(alwaysRun = true)
	public void aftersuite() {
		report.flush();
		Reporter.log("After Suite is executed", true);
	}
}
