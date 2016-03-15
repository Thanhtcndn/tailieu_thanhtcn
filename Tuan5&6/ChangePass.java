package Tuan5Test;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangePass {

	private WebDriver driver;

	@Before
	public void setUp() throws Exception
	{
		this.driver = new FirefoxDriver();
		driver.get("http://business.toancauxanh.vn:7664");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("[ng-click='header.showSignIn()']")).click();
		// wait for showing login dialog
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement emailEl = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		
		// fill out values to inputs
		emailEl.sendKeys("thanhtcn1@gmail.com");
		driver.findElement(By.name("password")).sendKeys("654321");
		
		//Click button
		driver.findElement(By.cssSelector("#check4")).click();
        driver.findElement(By.cssSelector(".login-button")).click();
		
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.dropdown-notify-container")));
	}
	
	  @Test
	  public void ChangePassword() throws Exception {
		
		driver.navigate().to("http://business.toancauxanh.vn:7664/account/recovery");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		
		WebElement currentpass = wait2.until(ExpectedConditions.presenceOfElementLocated(By.name("inputCurrentPassword")));
		currentpass.sendKeys("654321");
		
		WebElement newpass = wait2.until(ExpectedConditions.presenceOfElementLocated(By.name("inputNewPassword")));
		newpass.sendKeys("123456");
		
		WebElement confirmpass = wait2.until(ExpectedConditions.presenceOfElementLocated(By.name("inputConfirm")));
		confirmpass.sendKeys("123456");
		
		WebElement uploadbnt = driver.findElement(By.cssSelector("[ladda='account.passwordLoading']"));
		uploadbnt.click();
		
		System.out.println("Change Password is successful!");
		driver.close();
	}
	
}
