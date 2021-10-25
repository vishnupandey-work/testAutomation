package com.projectAutomation.tests;

import java.util.concurrent.TimeUnit;

/***
 * 
 * 
 * Create customer
 * 
 * 
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.projectAutomation.core.Contract;
import com.projectAutomation.core.Customer;
import com.projectAutomation.core.Login;
import com.utilities.WebDriverManagement;


public class Test2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

        WebDriverManagement drivermanagement = new WebDriverManagement();
        WebDriver driver = drivermanagement.firefox_WithProxy();
		Login login = new Login();
		Customer customer = new Customer();
		Contract contract = new Contract();
		String BU_selection = "Telechoice";
		String customer_type = "Postpaid";
		int bill_cycle = 11;
		//String customerPublicKey = "";
		String customerPublicKey = "CUST0000092676";
		
		login.login(driver,BU_selection);
		//Thread.sleep(10000);
		// customerPublicKey = customer.createCustomer(driver, BU_selection, customer_type , bill_cycle);
		customer.viewCustomer(driver, customerPublicKey);
		
	}

}
