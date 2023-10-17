package utilities;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilities.webelements.CheckBox;
import utilities.webelements.Dropdown;
import utilities.webelements.Link;
import utilities.webelements.RadioButton;
import utilities.webelements.Table;

public class EnhancedWebElement {

	public static void safeClick(WebDriver driver, WebElement element) {
		try {
			(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} catch (StaleElementReferenceException sere) {
			element.click();
		} catch (TimeoutException toe) {
			System.out.println("Element identified by " + element.toString() + " was not clickable after 10 seconds");
		}

	}

}
