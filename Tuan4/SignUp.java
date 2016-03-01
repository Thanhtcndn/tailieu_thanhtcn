package Tuan4;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* Example for: Signup at http://business.toancauxanh.vn:7664 with a random email */
public class SignUp {

	public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // Open website
        driver.get("http://business.toancauxanh.vn:7664");

        // Find the link to registration form
        driver.findElement(By.cssSelector("[ng-click='header.showSelectAccount()']")).click();
        
        //Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[ng-click='header.showSignUp()']")));
        
        // Find the link Let's start
        driver.findElement(By.cssSelector("[ng-click='header.showSignUp()']")).click();

         
        // Generate a random email
        final String randomEmail = randomEmail();
        
        // Find the email form field
        WebElement email = driver.findElement(By.name("signup_email"));
        
        // Type the random email to the form
        email.sendKeys(randomEmail);
        
        
        // Find the password form field
        WebElement password = driver.findElement(By.name("signup_password"));
        password.sendKeys("123456");
         
        //Nhap lai password
        WebElement repassword = driver.findElement(By.name("signup_repassword"));
        repassword.sendKeys("123456");
        
        // Check agree
        driver.findElement(By.cssSelector("#check4")).click();
        driver.findElement(By.cssSelector(".login-button")).submit();
        
    	wait.pollingEvery(10, TimeUnit.SECONDS);

    	//Store and Print the name of the First window on the console
    	String handle= driver.getWindowHandle();
        System.out.println("Name of window: " + handle);
    	
    	System.out.println("Sign up with account: " + randomEmail);
        System.out.println("Password is: " + driver.findElement(By.name("signup_password")).getAttribute("value"));

        //Close the browser
        driver.close();
    }

	 private static String randomEmail() {
         return UUID.randomUUID().toString() + "@example.com";
     }
	
}
