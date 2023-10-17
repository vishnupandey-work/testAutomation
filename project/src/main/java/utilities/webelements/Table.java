package utilities.webelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface Table {

	
	public String valueAtPosition(int row,int column);
	void safeClick(WebDriver driver, WebElement element);
	
}
