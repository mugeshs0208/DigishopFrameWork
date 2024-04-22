package DataTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {

	@DataProvider
	public String[][] loginData() {

		String[][] data = new String[2][2];
		data[0][0] = "smugesh0208@gmail.com";
		data[0][1] = "Mugesh@0208";
		
		data[1][0]="manikandan@gmail.com";
		data[1][1]="ManikanDan@123";
		

		return data;

	}
	
	@Test(dataProvider = "loginData")
	public void login_001(String username,String password) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.xpath("//a[.='Log in']")).click();
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
	}
}
