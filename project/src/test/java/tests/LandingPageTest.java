package tests;

import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.SearchResultsPage;
import utilities.WebDriverProvider;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class LandingPageTest extends WebDriverProvider {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(WebDriverProvider.class.getName());
	
	@BeforeTest
	void init() {
		driver = driverInstance();
		log.info("info message");
		log.debug("debug message");
		log.trace("trace message");
	}

	@Test(priority = 1, dataProvider = "getData")
	void searchBar(String toSearch, String displayValue) {
		log.info("info message: Test Started");
		log.debug("debug message: Test Started");
		log.trace("trace message: Test Started");
		driver.get(properties.getProperty("url"));
		LandingPage lp = new LandingPage(driver);
		lp.getSearchBox().isDisplayed();
		lp.getSearchBox().isEnabled();
		lp.getSearchBox().sendKeys(toSearch);
		//System.out.println(displayValue);
		lp.getSearchButton().click();
		SearchResultsPage srp = new SearchResultsPage(driver);
		WebElement myElem = srp.getResults().get(1);
		//System.out.println(myElem.getText());
		Assert.assertTrue( myElem.getText().contains(displayValue),"failure");
	}

	@Test(priority = 1, dataProvider = "getData")
	void searchBar2(String toSearch, String displayValue) {
		log.info("info message: Test Started");
		log.debug("debug message: Test Started");
		log.trace("trace message: Test Started");
		driver.get(properties.getProperty("url"));
		LandingPage lp = new LandingPage(driver);
		lp.getSearchBox().isDisplayed();
		lp.getSearchBox().isEnabled();
		lp.getSearchBox().sendKeys(toSearch);
		//System.out.println(displayValue);
		lp.getSearchButton().click();
		SearchResultsPage srp = new SearchResultsPage(driver);
		WebElement myElem = srp.getResults().get(1);
		//System.out.println(myElem.getText());
		Assert.assertTrue(myElem.getText().contains(displayValue),"failure");
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "GTX 1660"; 		data[0][1] = "GTX 1660";
		data[1][0] = "GTX 1650";		data[1][1] = "GTX 1650";
		data[2][0] = "RTX 2060";		data[2][1] = "RTX 2060";

		return data;
	}

	@AfterTest
	void terminate() {
		driver.quit();
	}
}
