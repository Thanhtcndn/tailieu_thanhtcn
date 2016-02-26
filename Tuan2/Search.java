package Tuan2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Search {

	public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\selenium-java-2.49.1\\selenium-2.49.1\\chromedriver.exe");

         WebDriver driver = new ChromeDriver(); 
         driver.get("http://www.bing.com/"); 
         WebElement element = driver.findElement(By.name("q"));
         element.sendKeys("Happy New Year");
         element.submit();
         
         if (driver.findElement(By.name("q")).getAttribute("value").equals("Happy New Year"))
         {
         	System.out.println("Successfull ^_^ ");
         }else
         	System.out.println("Failed :( ");

         driver.close();
    }
	
}
