package com.learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.SeleniumEnhancement;
import com.utilities.WebDriverManagement;

public class GreenKart_AddToCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManagement drivermanagement = new WebDriverManagement();
		WebDriver driver = drivermanagement.firefox_NoProxy();
		// WebDriver driver = drivermanagement.chrome_NoProxy();
		GreenKart_AddToCart basket = new GreenKart_AddToCart();
		String[] expectedCart = { "Carrot", "Potato", "Onion", "Mango" };
		int[] expectedQuantity = { 7, 2, 4, 9 };
		int expectedCartValue = 0;
		int counter = 0;
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		List<WebElement> products = driver.findElements(By.className("product"));
		//System.out.println(expectedCart.length);
		//System.out.println(products.size());
		WebDriverWait w = new WebDriverWait(driver,2);
		for (WebElement product : products) {
			for (int i = 0; i < expectedCart.length; i++) {
				String prodName = product.findElement(By.className("product-name")).getText();
				if (prodName.toLowerCase().contains(expectedCart[i].toLowerCase())) {
					String prodPrice = product.findElement(By.className("product-price")).getText();
					System.out.println(prodName + "\t" + prodPrice);
					SeleniumEnhancement.scrollIntoView(driver, product);
					try {
						Thread.sleep(500);
					} catch (Exception e) {
						System.out.println(e.getStackTrace());
					} finally {
						// does nothing
					}
					if (basket.addToCart(driver, product, expectedQuantity[i])) {
						expectedCartValue = expectedCartValue + Integer.parseInt(prodPrice) * expectedQuantity[i];
						counter = counter + 1;
						//System.out.println("counter = " + counter);
					}
				} else
					continue;
			}
			if (counter == expectedCart.length)
				break;
		}
		
		//Cart Validation starts
		System.out.println("Expected Cart value : " + expectedCartValue);
		int actualCartValue = Integer.parseInt(
				driver.findElement(By.xpath("//div[@class='cart-info']/table/tbody/tr[2]/td[3]")).getText().trim());
		int actualCartLength = Integer.parseInt(
				driver.findElement(By.xpath("//div[@class='cart-info']/table/tbody/tr[1]/td[3]")).getText().trim());
		if (expectedCart.length == actualCartLength && expectedCartValue == actualCartValue) {
			System.out.println("Cart Value and quantity is validated");
		}
		//Cart Validation ends
		
		driver.findElement(By.xpath("//a[@class='cart-icon'")).click();
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//"))));

	}

	public boolean addToCart(WebDriver driver, WebElement element, int quantity) {
		WebElement increment = element.findElement(By.className("increment"));
		WebElement value = element.findElement(By.className("quantity"));
		while (Integer.parseInt(value.getAttribute("value")) < quantity) {
			increment.click();
		}
		// System.out.println(value.getAttribute("value"));
		if (Integer.parseInt(value.getAttribute("value")) == quantity) {
			element.findElement(By.tagName("button")).click();
			return true;
		}
		return false;
	}
}
