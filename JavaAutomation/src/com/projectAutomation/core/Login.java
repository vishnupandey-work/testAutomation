package com.projectAutomation.core;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
**/

public class Login {

    public void login(WebDriver driver, String BU_selection) throws InterruptedException {
        
        driver.get("http://10.31.119.149:48890/custcare_cu/login");
        driver.findElement(By.id("j_username")).sendKeys("ESARJXX");
        driver.findElement(By.id("j_password")).sendKeys("SY");
        driver.findElement(By.id("j_password")).submit();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("form_formTag_SuOkButton"))));
        List<WebElement> table_rows = driver.findElements(By.tagName("tr"));
        for (WebElement rowElement : table_rows) {
            boolean breakpoint = false;
            List<WebElement> columns = rowElement.findElements(By.tagName("td"));
            for (WebElement col : columns) {
                if (col.getText().equals(BU_selection)) {
                    rowElement.findElement(By.id("TCB_BUSINESS_UNITS")).click();
                    breakpoint = true;
                }
                if (breakpoint)
                    break;
            }
            if (breakpoint)
                break;
        }
        driver.findElement(By.id("form_formTag_SuOkButton")).click();
    }

}
