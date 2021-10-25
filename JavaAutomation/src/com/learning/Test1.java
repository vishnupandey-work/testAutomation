package com.learning;

import org.openqa.selenium.WebDriver;

import com.utilities.WebDriverManagement;

public class Test1 {

  public static void main(String[] args) {
	  WebDriverManagement drivermanagement = new WebDriverManagement();
      WebDriver driver = drivermanagement.firefox_NoProxy();
      driver.get("https://www.facebook.com");
      String title = driver.getTitle();
      assert "Facebook � log in or sign up".equals(title) : "Expected name title, for" + title;
  }
}
