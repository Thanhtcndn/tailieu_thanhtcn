package Tuan5Test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* Example for: update user at http://business.toancauxanh.vn:7664 */
public class edituser {

	private WebDriver driver;

	@Before
	public void setUp() throws Exception
	{
		this.driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://business.toancauxanh.vn:7664");
				
		driver.findElement(By.cssSelector("[ng-click='header.showSignIn()']")).click();
		// wait for showing login dialog
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement emailEl = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		
		// fill out values to inputs
		emailEl.sendKeys("thanhtcn1@gmail.com");
		driver.findElement(By.name("password")).sendKeys("123456");
		
		//Click button
		driver.findElement(By.cssSelector("#check4")).click();
        driver.findElement(By.cssSelector(".login-button")).click();
		
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.dropdown-notify-container")));
	}
	
	  @Test
	  public void edituserbm() throws Exception {
		
		driver.navigate().to("http://business.toancauxanh.vn:7664/edit-profile/profile");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		WebElement inputname = wait2.until(ExpectedConditions.presenceOfElementLocated(By.name("inputFirstName")));
		
		inputname.clear();
		inputname.sendKeys("Minh Chau");
		
		WebElement inputlastname = driver.findElement(By.name("inputLastName"));
		inputlastname.clear();
		inputlastname.sendKeys("Le");
		
		WebElement inputposition = driver.findElement(By.id("inputPosition"));
		inputposition.clear();
		inputposition.sendKeys("USA");
		
		WebElement inputphone = driver.findElement(By.id("inputTelephoneNumber"));
		inputphone.clear();
		inputphone.sendKeys("+61411 222 555");
 		
		Thread.sleep(1000);
		WebElement bntSave = driver.findElement(By.cssSelector("button[ladda='editManagementProfile.loading']"));
		bntSave.click();

		// Check data
		if (inputname.getAttribute("value").equals("Minh Chau")){
			System.out.println("Firstname is: " + inputname.getAttribute("value"));
		}else
			System.out.println("Firstname is not edit :( ");
		
		if (inputlastname.getAttribute("value").equals("Le")){
			System.out.println("Lastname is: " + inputlastname.getAttribute("value"));
		}else
			System.out.println("Lastname is not edit :( ");
		
		if (inputposition.getAttribute("value").equals("USA")){
			System.out.println("Position is: " + inputposition.getAttribute("value"));
		}else
			System.out.println("Position is not edit :( ");
		
		if (inputphone.getAttribute("value").equals("+61411 222 555")){
			System.out.println("Numberphone is: " + inputphone.getAttribute("value"));
		}else
			System.out.println("Numberphone is not edit :( ");
   	
		driver.close();
	}
	
}
