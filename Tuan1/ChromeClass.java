package Tuan1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver; 

//sử dụng Selenium WebDriver thao tác mở trang với trình duyệt Chrome
public class ChromeClass {
	public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\selenium-java-2.49.1\\selenium-2.49.1\\chromedriver.exe");

         WebDriver driver = new ChromeDriver(); 
         driver.manage().window().maximize();
         driver.get("http://google.com");
	}
	
}
