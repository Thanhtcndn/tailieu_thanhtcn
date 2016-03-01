package Tuan4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Test;

/* Example for: Signin at http://business.toancauxanh.vn:7664 */  
public class SignIn {

	private WebDriver driver;

	@Test
	public void setUp() throws Exception
	{
		this.driver = new FirefoxDriver();
		driver.get("http://business.toancauxanh.vn:7664");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("[ng-click='header.showSignIn()']")).click();
		
		// wait for showing login dialog
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement emailEl = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		
		// fill out values to inputs
		emailEl.sendKeys("thanhtcn1@gmail.com");
		driver.findElement(By.name("password")).sendKeys("123456");
		
		driver.findElement(By.cssSelector("#check4")).click();
        driver.findElement(By.cssSelector(".login-button")).click();
		
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.dropdown-notify-container")));
		
		WebElement username = driver.findElement(By.xpath("html/body/div[1]/header/div/div/div/div/div[3]/div/ul/li[4]/a/span[2]"));
		if (username.getText().isEmpty())
	       {
			   System.out.println("Sign in is Failed :( "); 
			   
	       }else
	    	   System.out.println("Sign in is successful ^-^!");
			   System.out.println("Username is: " + username.getText());
		
		driver.close();
	}
	
}
