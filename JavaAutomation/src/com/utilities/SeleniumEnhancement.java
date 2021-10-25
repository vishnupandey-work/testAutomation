package com.utilities;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class SeleniumEnhancement {
	
	private WebDriver driver;
	
	public SeleniumEnhancement(WebDriver driver){
		this.driver = driver;
	}
	
	public boolean waitForElement(WebDriver driver, WebElement element){
		/*		 SeleniumEnhancement enhancement = new SeleniumEnhancement(driver);
		   Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(30, TimeUnit.SECONDS)
			       .pollingEvery(5, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);
*/	
		return false;
	}
	
	public static void switchWindowByPartialTitle(WebDriver driver,String partialTitle) {
		Set<String> windowHandles = driver.getWindowHandles();
		for(String windowHandle : windowHandles) {
			boolean flag = false;
			if( driver.switchTo().window(windowHandle).getTitle().contains(partialTitle) ) {
				driver.switchTo().window(windowHandle);
				flag = true;
				break;
			}
			if(flag)
				break;
		}
	}
	
	public static void scrollIntoView(WebDriver driver, WebElement element) {
	      JavascriptExecutor js = (JavascriptExecutor)driver;
	      js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public static void scrollToTop(WebDriver driver) {
	      JavascriptExecutor js = (JavascriptExecutor)driver;
	      js.executeScript("window.scrollTo(0,0);");
	}

	public static WebElement findElementByXpath(WebDriver driverVar, String xpathExpression) {
		// TODO Auto-generated method stub
		return driverVar.findElement(By.xpath(xpathExpression));
	}

	
}
