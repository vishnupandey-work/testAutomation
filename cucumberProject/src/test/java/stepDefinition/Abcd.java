package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import pagefactory.LandingPage;

public class Abcd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
		 FirefoxProfile geoDisabled = new FirefoxProfile();
		    geoDisabled.setPreference("geo.enabled", false);
		    geoDisabled.setPreference("geo.provider.use_corelocation", false);
		    geoDisabled.setPreference("geo.prompt.testing", false);
		    geoDisabled.setPreference("geo.prompt.testing.allow", false);
		    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		    capabilities.setCapability(FirefoxDriver.PROFILE, geoDisabled);
		WebDriver driver = new FirefoxDriver(capabilities);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("https://www.goindigo.in/");
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.acceptCookies();
		//driver.quit();
		}

}
