package Tuan3Package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Test;

public class WaitAction {

	private WebDriver driver;

	@Test
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
		//driver.findElement(By.name("email")).sendKeys("thanhtcn1@gmail.com");
		emailEl.sendKeys("thanhtcn1@gmail.com");
		driver.findElement(By.name("password")).sendKeys("123456");
		
		driver.findElement(By.cssSelector("#check4")).click();
        driver.findElement(By.cssSelector(".login-button")).click();
		
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        WebDriverWait wait1 = new WebDriverWait(driver, 10);
//		WebElement notifEl = wait1.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.dropdown-notify-container")));
       System.out.println("Sign in is Successful ^-^!");
       driver.close();
	}
	
}
