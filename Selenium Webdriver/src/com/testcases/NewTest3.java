package com.testcases;

import com.webdriver.DriverInstanceGenerator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

  public class NewTest3 {

	  public static void main(String[] args) {
		  WebDriver driver = DriverInstanceGenerator.DriverInstance("chrome");
		  //driver.manage().window().maximize();
		  //WebDriver driver = new PhantomJSDriver();
		  driver.get("https://www.quora.com");
		  List<WebElement> elements = driver.findElements(By.className("form_column"));
		  for( WebElement element : elements){
			  System.out.println(element.findElement(By.tagName("input")).getAttribute("id"));
			  //System.out.println(element.);
		  }
	  }
  }
