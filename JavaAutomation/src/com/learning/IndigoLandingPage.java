package com.learning;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.utilities.WebDriverManagement;

public class IndigoLandingPage {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManagement drivermanagement = new WebDriverManagement();
		WebDriver driver = drivermanagement.firefox_NoProxy();
		// WebDriver driver = drivermanagement.chrome_NoProxy();
		driver.get("https://www.goindigo.in/");
		String title = driver.getTitle();
		System.out.println(title);

		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[contains(text(),'Accept cookies')]")).click();

		driver.findElement(By.name("or-src")).sendKeys("DE");
		List<WebElement> autosuggest_src = driver.findElements(
				By.cssSelector("div.autocomplete-results.autocomplete-main.station-results div.wrap div[data-name]"));
		Thread.sleep(1000);
		for (WebElement webElement : autosuggest_src) {
			// System.out.println(webElement.getAttribute("data-name"));
			if (webElement.getAttribute("data-name").equalsIgnoreCase("Delhi")) {
				webElement.click();
				break;
			}
		}

		driver.findElement(By.name("or-dest")).sendKeys("CHE");
		List<WebElement> autosuggest_dest = driver.findElements(
				By.cssSelector("div.autocomplete-results.autocomplete-main.station-results div.wrap div[data-name]"));
		Thread.sleep(1000);
		for (WebElement webElement : autosuggest_dest) {

			// System.out.println(webElement.getAttribute("data-name"));
			if (webElement.getAttribute("data-name").equalsIgnoreCase("Chennai") && webElement.isDisplayed()) {
				webElement.click();
			}
		}

		driver.findElement(
				By.xpath("//td[@data-handler='selectDay' and @data-month='8' and @data-year='2020']/a[text()='7']"))
				.click();

		System.out.println("EoE");
	}
}
