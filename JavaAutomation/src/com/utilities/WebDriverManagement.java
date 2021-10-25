package com.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverManagement {
	String webdriver_path = System.getProperty("user.dir")+"\\selenium-libraries\\";
	
	public WebDriver firefox_NoProxy() {
		//String webdriver_path = System.getProperty("user.dir")+"\\selenium-libraries\\";
		//System.out.println(webdriver_path);
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, webdriver_path+"\\logs.txt");
        System.setProperty("webdriver.gecko.driver", webdriver_path + "geckodriver.exe");
        
        //disable geolocation
        FirefoxOptions newProfile = new FirefoxOptions();
        newProfile.addPreference("geo.enabled", false);
        newProfile.addPreference("geo.provider.use_corelocation", false);
        newProfile.addPreference("geo.prompt.testing", false);
        newProfile.addPreference("geo.prompt.testing.allow", false);
        //DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        //capabilities.setCapability(FirefoxDriver.PROFILE, newProfile);
       
        WebDriver driver = new FirefoxDriver(newProfile);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        return driver;
	}
	
	public WebDriver firefox_WithProxy() {
		//String webdriver_path = System.getProperty("user.dir")+"\\selenium-libraries\\";
		//System.out.println(webdriver_path);
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "C:\\temp\\logs.txt");
        System.setProperty("webdriver.gecko.driver", webdriver_path + "geckodriver.exe");
        FirefoxOptions profile = new FirefoxOptions();
        profile.addPreference("network.proxy.socks", "localhost");
        profile.addPreference("network.proxy.type", 1);
        profile.addPreference("network.proxy.socks_port", 3077);
        profile.addPreference("network.proxy.socks_version", 5);
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        //firefoxOptions.setProfile(profile);
        WebDriver driver = new FirefoxDriver(profile);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        return driver;
	}
	
	public WebDriver chrome_NoProxy() {
		System.setProperty("webdriver.chrome.driver", webdriver_path + "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		return driver;
	}

}
