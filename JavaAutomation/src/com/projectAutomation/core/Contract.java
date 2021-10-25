package com.projectAutomation.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Contract {

	private String PublicKey;
	private String MSISDN;
	private String SIM;
	private String IMSI;
	
	public Contract(String msisdn, String sim){
		this.MSISDN = msisdn;
		this.SIM = sim;
	}

	public Contract(){
		MSISDN = "";
		SIM = "";
		IMSI = "";
		PublicKey = "";
	}
	
	public Contract(String msisdn, String sim, String imsi){
		this.MSISDN = msisdn;
		this.SIM = sim;
		this.IMSI= imsi;
	}
	
	public void createContract(WebDriver driver) {
		System.out.println(driver.getTitle());
		driver.findElement(By.id("CustomerOverview_WorkflowId_formTag_Add_Button")).click();
		
	}
	
}
