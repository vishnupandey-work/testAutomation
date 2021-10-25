package com.learning;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.utilities.SeleniumEnhancement;
import com.utilities.WebDriverManagement;

public class FluentWaitExample {

	public static <T> void main(String[] args) throws InterruptedException {
		WebDriverManagement drivermanagement = new WebDriverManagement();
		WebDriver driver = drivermanagement.firefox_NoProxy();
		// WebDriver driver = drivermanagement.chrome_NoProxy();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		String title = driver.getTitle();
		// System.out.println(title);

		driver.findElement(By.xpath("//div[@id='start']/button")).click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

		// WebElement element = driver.findElement(By.xpath("//div[@id='finish']/h4"));
		String xpathValue = "//div[@id='finish']/h4";

		// IMPORTANT CONCEPT
		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver t) {
				if (SeleniumEnhancement.findElementByXpath(t, xpathValue).isDisplayed())
					return SeleniumEnhancement.findElementByXpath(t, xpathValue);
				return null;
			}
		});

		System.out.println(SeleniumEnhancement.findElementByXpath(driver, xpathValue).isDisplayed());
		System.out.println(SeleniumEnhancement.findElementByXpath(driver, xpathValue).getText());
		System.out.println("EoE");
	}
}
