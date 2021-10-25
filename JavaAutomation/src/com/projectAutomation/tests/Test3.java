package com.projectAutomation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.SeleniumEnhancement;
import com.utilities.WebDriverManagement;

public class Test3 {
	
	public static final void print(Object x) { System.out.println(x); }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		  WebDriverManagement drivermanagement = new WebDriverManagement();
	      WebDriver driver = drivermanagement.firefox_NoProxy();
	      driver.get("https://www.amazon.in");
	      driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung galaxy m30s mobile");
	      driver.findElement(By.id("twotabsearchtextbox")).submit();
	      driver.findElement(By.linkText("Samsung Galaxy M30s (Blue, 6GB RAM, 128GB Storage)")).click();
	      System.out.println(driver.getWindowHandle());
	      System.out.println("xxxx");
	      SeleniumEnhancement.switchWindowByPartialTitle(driver,"Samsung Galaxy M30s (Blue, 6GB RAM, 128GB Storage)");
	      System.out.println(driver.getWindowHandle());
	      System.out.println(driver.findElement(By.xpath("//div[@id='ddmDeliveryMessage']/span[@class='a-text-bold']")).getText());
	      System.out.println("----");
	}

}
