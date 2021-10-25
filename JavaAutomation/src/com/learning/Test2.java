package com.learning;

import org.openqa.selenium.*;
import com.utilities.WebDriverManagement;

public class Test2 {

  public static void main(String[] args) throws InterruptedException {
	  WebDriverManagement drivermanagement = new WebDriverManagement();
      WebDriver driver = drivermanagement.firefox_NoProxy();
      //WebDriver driver = drivermanagement.chrome_NoProxy();
      driver.get("https://www.goindigo.in/");
      String title = driver.getTitle();
      System.out.println(title);
      driver.findElement(By.name("or-src")).sendKeys("de");
      Thread.sleep(3000);
      System.out.println("EoE");
  }
}
