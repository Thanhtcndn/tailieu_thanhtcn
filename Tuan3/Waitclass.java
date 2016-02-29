package Tuan3Package;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/* Tim kiem tren google voi trinh duyet FF */
public class Waitclass {

	static WebDriver driver;

    static Wait<WebDriver> wait;

    public static void main(String[] args) {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 30);
        driver.get("http://www.google.com/");
 
        boolean result;

        try {
            result = firstPageContainsQAANet();
        } catch(Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            driver.close();
        }
 
        System.out.println("Test " + (result? "passed." : "failed."));

        if (!result) {
            System.exit(1);
        }
    }
    
    private static boolean firstPageContainsQAANet() {
   
    	//type search query
        driver.findElement(By.name("q")).sendKeys("qa automation\n");

        // click search
         driver.findElement(By.name("btnG")).click();

        // Wait for search to complete
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                System.out.println("Searching ...");
                return webDriver.findElement(By.id("resultStats")) != null;
            }
        });

        // Look for QAAutomation.net in the results
        return driver.findElement(By.tagName("body")).getText().contains("qaautomation.net");
    }
    @Test
    	public void simpleTest() {
   
    	    WebDriver driver = new FirefoxDriver();
    	    driver.get("http://referencewebapp.qaautomation.net/");
    	    driver.findElement(By.linkText("Register")).click();
   
    	    // Check for body header on new page.<br />
  
    	    WebElement bodyHeader = driver.findElement(By.id("body_header"));
      	    assertEquals("Page body header match failed", "Register", bodyHeader.getText());
   
    	    driver.close();
    	}
}
