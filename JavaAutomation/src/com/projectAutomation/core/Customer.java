package com.projectAutomation.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.time.LocalDateTime; 


public class Customer {
	private String customerPublicKey;
	
	public Customer(){
		customerPublicKey = "";
	}
	
    public String getCustomerPublicKey() {
		return customerPublicKey;
	}

    public void setCustomerPublicKey(String customerPublicKey) {
		this.customerPublicKey = customerPublicKey;
	}

	public String createCustomer(WebDriver driver,String bu_name, String customer_type ,int bill_cycle) throws InterruptedException{

    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy-HHmmss");  
    	LocalDateTime now = LocalDateTime.now();  
    	//driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div[1]/div[2]/form/div/a[1]")).click();
        driver.findElement(By.linkText("Customers")).click();
//        if(driver.findElement(By.linkText("Create customer")).isDisplayed()) {
//        }
        driver.findElement(By.linkText("Create customer")).click();
        driver.findElement(By.linkText("Private customer")).click();
        String timestamp = dtf.format(now);
        driver.findElement(By.id("ADR_LNAME")).sendKeys(bu_name+"-autoScript-"+timestamp);
        driver.findElement(By.id("Contact_Information_Form_SuNextStepButton")).click();
        driver.findElement(By.id("CS_PASSWORD")).sendKeys("test1234");
        
        WebDriverWait wait1 = new WebDriverWait(driver,20);
        wait1.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("CustomerGroup_Combobox"))));
        
        Select drpCustomerGroup = new Select(driver.findElement(By.id("CustomerGroup_Combobox")));
        drpCustomerGroup.selectByVisibleText(customer_type);
        
        WebDriverWait wait2 = new WebDriverWait(driver,20);
        wait2.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("CS_BILLCYCLE"))));
        
        Select billCycleGroup = new Select(driver.findElement(By.id("CS_BILLCYCLE")));
        billCycleGroup.selectByVisibleText("BC "+Integer.toString(bill_cycle));
        Select occ_RP_Group = new Select(driver.findElement(By.id("RPCODE")));
        occ_RP_Group.selectByVisibleText("EU OCC Plan");
        driver.findElement(By.id("BillingAndPaymentInfoWorkflow_formTag_SuNextStepButton")).click();
        driver.findElement(By.id("PaymentArrDisplayMode_formTag_SuNextStepButton")).click();
        driver.findElement(By.id("form_formTag_SuNextStepButton")).click();
        Select StatusCombobox = new Select(driver.findElement(By.id("StatusCombobox_Name")));
        StatusCombobox.selectByVisibleText("Active");
        
        WebDriverWait wait3 = new WebDriverWait(driver,20);
        wait3.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("RS_CODE"))));
        
        Select ReasonValue = new Select(driver.findElement(By.id("RS_CODE")));
        ReasonValue.selectByVisibleText("activation");
        driver.findElement(By.id("form_formTag_SuFinishButton")).click();
        String publicKey="" ;
        WebDriverWait wait4 = new WebDriverWait(driver,20);
        wait4.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("KIBarTxt")));
        publicKey=driver.findElement(By.xpath("//span[contains(text(),'Customer public key')]/following::span[1]")).getText();
        List<WebElement> cust_details = driver.findElements(By.className("KIBarTxt"));
//        for(WebElement element : cust_details) {
//        	if(element.getText().contains("CUST")) {
//        		publicKey = element.getText();
//        		System.out.println("created key is " + publicKey);
//        		break;
//        	}
//        }
        return publicKey;
    }
 
    public void viewCustomer(WebDriver driver, String customerPublicKey) throws InterruptedException {
    	//driver.findElement(By.linkText("Home")).click();
    	driver.findElement(By.linkText("Customers")).click();
    	driver.findElement(By.linkText("Search for customer")).click();
    	driver.findElement(By.id("CS_ID_PUB")).sendKeys(customerPublicKey);
    	driver.findElement(By.id("FLAG_MATCHCODE")).click();
    	driver.findElement(By.id("IGNORE_BU_IND")).click();
    	driver.findElement(By.id("form_formTag_Search_Button")).click();
    	driver.findElement(By.xpath("//table[@id='Customer_TableModel']/tbody/tr[1]/td[1]/a")).click();

    }
    
}
