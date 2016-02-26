package Tuan1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

//sử dụng Selenium WebDriver thao tác mở trang với trình duyệt IE
public class IEClass {

	public static void main(String[] args){
        
		System.setProperty("webdriver.ie.driver","C:\\selenium-java-2.49.1\\selenium-2.49.1\\IEDriverServer32.exe");
        WebDriver driver = new InternetExplorerDriver();
        driver.manage().window().maximize();
        driver.get("http://google.com");
        
	}
}
