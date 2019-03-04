package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
	private static WebDriver driver;
	public static WebDriver getDriver() {
		if(driver==null){
			System.setProperty("webdriver.chrome.driver", "src/test/resounces/chromedriver.exe");
			driver=new ChromeDriver();
		}
		return driver;
	}
}
