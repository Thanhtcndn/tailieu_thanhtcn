package Tuan4;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/* Example for: check buttons are disabled.
 Copy folder Html_Demo in C:\ to run this example */

public class Objects {

	WebDriver driver;
	 @Before
	  public void setUp() {
		 driver = new FirefoxDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.get("C:\\Html_Demo\\Register.html");
		  driver.manage().window().maximize();
	  }
	 
	 @Test
	  public void InputEmail() throws Exception {
		  
		  //Nhap email
		  String element = "#mail";
		  driver.findElement(By.cssSelector(element)).sendKeys("thanhtcn@greenglobal.vn");
		  
		  if (element.isEmpty()) {
			  System.out.println("No Email!");
		  } else {
		  
			  System.out.println("Email: " + driver.findElement(By.cssSelector(element)).getAttribute("value"));
		  }
		  
		  // kiem tra password co disabled
		  String elementp = "#password"; // use CSS
		  if (isElementEnabled(driver, elementp)) {
			  System.out.println("Password is enabled");
		  } else {
			  System.out.println("Password is disabled");
		  }
		
		  //chon 18 or hơn 18 tuoi
		  driver.findElement(By.cssSelector("#over_18")).click();
		  
		  //kiem tra radio button disabled
		  String elementr = "//input[@id='radio-disabled']";
		  if (isElementEnabled(driver, elementr)) {
			  System.out.println("Age Radio button is enabled");
		  } else {
			  System.out.println("Age Radio button is disabled");
		  }
		  
		  // nhap Education
		  String elementE = "#edu";
		  driver.findElement(By.cssSelector("#edu")).sendKeys("Noi dung");
		  if (elementE.isEmpty()) {
			  System.out.println("No Education!");
		  } else {
			  System.out.println("Education: " + driver.findElement(By.cssSelector(elementE)).getAttribute("value"));
		  }
		  
		  //kiem tra Text Area is disabled
		  String elementTA = "//textarea[@id='bio']";
		  if (isElementEnabled(driver, elementTA)) {
			  System.out.println("Biography - Text Area is enabled");
		  } else {
			  System.out.println("Biography - Text Area is disabled \n");
		  }
		  
		  //select combobox
		  Select dropdownJob = new Select(driver.findElement(By.id("job1")));
			dropdownJob.selectByVisibleText("Manual Tester");
		  
		  //Kiem tra combo is disabled
		  String elementC = "//*[@id='job2']";
		  if (isElementEnabled(driver, elementC)) {
		  System.out.println("Job Role 02 - Dropdown List is enabled");
		  } else {
		  System.out.println("Job Role 02 - Dropdown List is disabled \n");
		  }
		  
		//click checkbox 
		  driver.findElement(By.cssSelector("#development")).click();
		  		  
		  //kiem tra checkbox is disabled
		  String elementCB = "//*[@id='check-disbaled']";
		  if (isElementEnabled(driver, elementCB)) {
			  System.out.println("Interests - Checkbox is enabled");
		  } else {
			  System.out.println("Interests - Checkbox is disabled \n");
		  }
		  
		 //Move Slider  
			WebElement dragElementFrom = driver.findElement(By.cssSelector("#slider-1"));  
			new Actions(driver).dragAndDropBy(dragElementFrom, 70, 0).build().perform(); 
			Thread.sleep(5000); 
			new Actions(driver).clickAndHold(dragElementFrom).moveByOffset(70,0).release().perform(); 
			  if (dragElementFrom.getLocation().x !=0)
			  {
				  System.out.println("Slider 01 is Moved!");
			  }else {
				  System.out.println("Slider 01 is not move");
			  }		  
		 
		  //Kiem tra slider is disabled
		  String elementS = "//*[@id='slider-2']";
		  if (isElementEnabled(driver, elementS)) {
			  System.out.println("Slider 02 is enabled");
		  } else {
			  System.out.println("Slider 02 is disabled \n");
		  }
		  
		  //Kiem tra button is disabled
		  String elementBt = "//*[@id='button-disabled']";
		  if (isElementEnabled(driver, elementBt)) {
			  System.out.println("Button is enabled");
		  } else {
			  System.out.println("Button is disabled");
		  }
	  }
	 
		 
	 //kiem tra object is disabled
	 public boolean isElementEnabled(WebDriver driver, String yourLocator) {
		 try {
			  WebElement locator; // khoi tao
			  locator = driver.findElement(By.xpath(yourLocator)); // kiem tra hien thi
			  return locator.isEnabled();
		  } catch (NoSuchElementException e) {
			  return false;
		  }
	  }
	 
	 @After
	  public void tearDown() {
		 driver.quit();
	  }
}
