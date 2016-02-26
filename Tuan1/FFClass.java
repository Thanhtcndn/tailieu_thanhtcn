package Tuan1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// sử dụng Selenium WebDriver thao tác mở trang với trình duyệt FF
public class FFClass {


	public static void main(String[] args){
      
        WebDriver driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://google.com"); 
	}
	
}
