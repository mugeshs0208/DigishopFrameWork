package genericLibrary;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

public class UtilityMethods implements FrameConstants {

	static Select select;
	static Actions action;
	static JavascriptExecutor jse;
	static TakesScreenshot ts;

	public static String getTime() {

		return LocalDateTime.now().toString().replace("-", "_").replace(":", "_");
	}

	public static void initObject(WebDriver driver) {
		jse = (JavascriptExecutor) driver;

		action = new Actions(driver);
		ts = (TakesScreenshot) driver;
	}

	public static String getProperty(String key) throws IOException {
		FileInputStream fis = new FileInputStream("");
		Properties property = new Properties();
		property.load(fis);
		return property.getProperty(key);

	}

	public static String getScreenShotWebPage(WebDriver driver) {
		String imagepath = SCREENSHOT_PATH+ getTime() + ".png";
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File perm = new File(imagepath);
		try {
			FileHandler.copy(temp, perm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "." + imagepath;
	}

	public static String getScreenShotWebElement(WebElement element) {
		String imagePath = SCREENSHOT_PATH + getTime() + ".png";
		File temp = element.getScreenshotAs(OutputType.FILE);
		File perm = new File(imagePath);
		try {
			FileHandler.copy(temp, perm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "." + imagePath;
	}

	public static void getSelectByIndex(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);

	}

	public static void getSelectByVisibleText(WebElement element, String text) {
		select = new Select(element);
		select.selectByVisibleText(text);
	}

	public static void getSelectByValue(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);
	}

	public static void getAllSelectedOptions(WebElement element) {
		select = new Select(element);
		select.getAllSelectedOptions();
	}

	public static void getFirstSelectedOption(WebElement element) {
		select = new Select(element);
		select.getFirstSelectedOption();
	}

	public static void verifyelement(String actual, String expected) {
		assertEquals(actual, expected);
	}

	public static String exceldata(String sheetname, int rownum, int cellnum)
			throws EncryptedDocumentException, IOException {

		File fileName = new File(USER_DETAILS);

		FileInputStream fis = new FileInputStream(fileName);

		Workbook workbook = WorkbookFactory.create(fis);

		Sheet sheet = workbook.getSheet(sheetname);

		Row row = sheet.getRow(rownum);

		Cell cell = row.getCell(cellnum);

		String data = cell.getStringCellValue();

		return data;
	}

	public static String commondata(String sheetname, int rownum, int cellnum) {

		File fileName = new File(COMMONDATA_PATH);

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Sheet sheet = workbook.getSheet(sheetname);

		Row row = sheet.getRow(rownum);

		Cell cell = row.getCell(cellnum);

		String data = cell.getStringCellValue();

		return data;
	}

	public static String[][] productsdata(String sheetname) {

		File file = new File(PRODUCT_DATA);

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet = workbook.getSheet(sheetname);

		int rowcount = sheet.getPhysicalNumberOfRows();

		int cellcount = sheet.getRow(0).getPhysicalNumberOfCells();

		String[][] data = new String[rowcount - 1][cellcount];

		for (int i = 1; i < rowcount; i++) {
			for (int j = 0; j < cellcount; j++) {
				data[i - 1][j] = sheet.getRow(i).getCell(j).toString();

			}
		}
		return data;
	}

	public static void getWindowHandleByTitle(WebDriver driver, String title) {
		Set<String> allwindow = driver.getWindowHandles();

		for (String window : allwindow) {
			driver.switchTo().window(window);

			if (driver.getTitle().contains(title)) {
				break;
			}
		}
	}

	public static void getWindowHandleByUrl(WebDriver driver, String url) {
		Set<String> allwindow = driver.getWindowHandles();

		for (String window : allwindow) {
			driver.switchTo().window(window);

			if (driver.getCurrentUrl().contains(url)) {
				break;
			}
		}
	}

	public static void handleDisabledOrHiddenTextField(WebElement element, String value) {

		jse.executeScript("agruments[0].value='" + value + "';", element);
	}

	public static void getScrollBy(int x, int y) {
		jse.executeScript("Window.ScrollBy(" + x + "," + y + ");");
	}

	public static void getScrollTo(int x, int y) {
		jse.executeScript("Window.ScollTo(" + x + "," + y + ");");
	}

	public static void getMoveToElement(WebElement element) {
		action.moveToElement(element).perform();
	}

	public static void getClick(WebElement element) {
		action.click(element).perform();
	}

	public static void getContextClick(WebElement element) {
		action.contextClick(element).perform();
	}

	public static void getDoubleClick(WebElement element) {
		action.doubleClick(element).perform();
	}

	public static void getClickAndHold(WebElement element) {
		action.clickAndHold(element).perform();
	}

	public static void getRelease(WebElement element) {
		action.release(element).perform();
	}

	public static void getDrogAndDrop(WebElement source, WebElement target) {
		action.dragAndDrop(source, target).perform();
	}

	public static void getScrollByAmount(int x, int y) {
		action.scrollByAmount(x, y).perform();
	}

	public static void getScrollToElement(WebElement element) {
		action.scrollToElement(element).perform();
	}

	public static void getScrollFromOrigin(WebElement element, int x, int y) {
		ScrollOrigin origin = ScrollOrigin.fromElement(element);
		action.scrollFromOrigin(origin, x, y).perform();
	}

	public static void keyPress(Keys key) {
		action.keyDown(key);
	}

	public static void keyRelease(Keys key) {
		action.keyUp(key);
	}

}