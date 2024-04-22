package TestNgBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiDimensionalArray {

	@DataProvider
	public String[][]registerData(){
	
		
		String[][] a=new String[5][5];
		
		a[0][0]="Mugesh";
		a[0][1]="S";
		a[0][2]="smugesh0208@gmail.com";
		a[0][3]="Mugesh@0208";
		a[0][4]="Mugesh@0208";
		
		a[1][0]="Manikandan";
		a[1][1]="A";
		a[1][2]="manikandanece@gmail.com";
		a[1][3]="Manikandan@123";
		a[1][4]="Manikandan@123";
		
		a[2][0]="Vijay";
		a[2][1]="T";
		a[2][2]="vijay123@gmail.com";
		a[2][3]="Vijay@123";
		a[2][4]="Vijay@123";
		
		a[3][0]="Vijay";
		a[3][1]="P";
		a[3][2]="vijay@gmail.com";
		a[3][3]="Vijay@123";
		a[3][4]="Vijay@123";
		
		a[4][0]="Vignesh";
		a[4][1]="A";
		a[4][2]="vignesh@gmail.com";
		a[4][3]="Vignesh@123";
		a[4][4]="Vignesh@123";
		
		return a;
		
	}
		
		
		@Test(dataProvider = "registerData")
		public void register_001(String firstName, String lastName, String email, String password, String confirmPassword ) {
			
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://demowebshop.tricentis.com/");
			driver.findElement(By.linkText("Register")).click();
			driver.findElement(By.id("gender-male")).click();
			driver.findElement(By.id("FirstName")).sendKeys(firstName);
			driver.findElement(By.id("LastName")).sendKeys(lastName);
			driver.findElement(By.id("Email")).sendKeys(email);
			driver.findElement(By.id("Password")).sendKeys(password);
			driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmPassword);
			driver.findElement(By.id("register-button")).click();
			driver.quit();
		}

	}


