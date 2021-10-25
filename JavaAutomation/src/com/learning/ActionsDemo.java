package com.learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.utilities.WebDriverManagement;

public class ActionsDemo {

	public static void main(String[] args) {
		WebDriverManagement drivermanagement = new WebDriverManagement();
		WebDriver driver = drivermanagement.firefox_NoProxy();
		// WebDriver driver = drivermanagement.chrome_NoProxy();
		driver.get("https://jqueryui.com/draggable/");
		String title = driver.getTitle();
		System.out.println(title);
		/*
		 * List<WebElement> frames = driver.findElements(By.xpath("//iframe"));
		 * for(WebElement frame : frames) { System.out.println(frame); }
		 */
		// driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
		driver.findElement(By.id("draggable")).click();

		Actions a = new Actions(driver);
		int xOffset = 50, yOffset = 50;
		a.dragAndDropBy(driver.findElement(By.id("draggable")), xOffset, yOffset).build().perform();

		System.out.println("EoE");
	}
}