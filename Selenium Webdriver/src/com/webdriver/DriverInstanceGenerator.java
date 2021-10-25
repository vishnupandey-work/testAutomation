package com.webdriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.ie.*;

public class DriverInstanceGenerator {

	private static WebDriver driver;
		
	public static WebDriver DriverInstance(String browser){
		browser = browser.toLowerCase();
		switch(browser){
			case "chrome" :
				 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\webdrivers\\chromedriver.exe");
				 driver = new ChromeDriver();
				 break;
			case "ie" :
				System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\webdrivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\webdrivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				break;
			default :
				DriverInstance("firefox");
				break;
		}
		return driver;
	}
		
}
