package com.learning;

import org.openqa.selenium.WebDriver;

import com.utilities.WebDriverManagement;

public class Automata {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManagement driverManager = new WebDriverManagement();
		WebDriver driver = driverManager.firefox_NoProxy();
		//WebDriver driver = driverManager.chrome_NoProxy();
		
	      driver.get("http://www.goindigo.in");
	      String title = driver.getTitle();
	      System.out.print(title);
	      
	}

}
