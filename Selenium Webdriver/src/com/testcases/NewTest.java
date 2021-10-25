package com.testcases;

import org.openqa.selenium.WebDriver;
import com.webdriver.DriverInstanceGenerator;

public class NewTest {

public static void main(String[] args) {
	WebDriver driver = DriverInstanceGenerator.DriverInstance("sada");
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com");
//	String expectedTitle = "nnOnline recharge | mobile recharge for prepaid & pay postpaid bill@Paytm.com";
//	Assert.assertEquals(driver.getTitle(),expectedTitle);
	
  }
}
