package com.webdrivercases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdriver.DriverInstanceGenerator;

public class WebdriverCase_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  WebDriver driver = DriverInstanceGenerator.DriverInstance("firefox");
		  //driver.manage().window().maximize();
		  //WebDriver driver = new PhantomJSDriver();
		  driver.get("https://www.quora.com");
		  WebElement tempElement = null;
		  List<WebElement> elements = driver.findElements(By.className("form_column"));
		  for( WebElement element : elements){
			  System.out.println(element.findElement(By.tagName("input")).getAttribute("id"));
			  String elementID = element.findElement(By.tagName("input")).getAttribute("id");
			  if(elementID.contains("email")){
				  element.click();
				  element.sendKeys("email ID is set");  
			  }
			  if(elementID.contains("password")){
				  element.click();
				  element.sendKeys("password is set");
			  }
			  if(elementID.contains("submit_button"))
					tempElement = element;
	}
		  if(tempElement.isEnabled()){
			  tempElement.click();
		  }
	}
}

