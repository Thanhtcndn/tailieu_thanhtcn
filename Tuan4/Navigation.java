package Tuan4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Navigation {

	public static void main(String[] args) throws InterruptedException {

		 WebDriver driver =new FirefoxDriver();
		 driver.get("http://seleniumhq.org/");
		 driver.manage().window().maximize();
		 
		 driver.findElement(By.linkText("Download")).click();
		//delay
		 Thread.sleep(3000);            
		 
		 driver.navigate().back();
		 System.out.println("Navigate to back! ");
		 
		 driver.navigate().forward();
		 System.out.println("Navigate to forward! ");
	 
		 driver.close();
	 }
}
