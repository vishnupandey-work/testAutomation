package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class SearchResultsPage {

	private WebDriver driver;

	public SearchResultsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//a[@target='_blank']/span[contains(@class,'a-size-medium')]")
	private List<WebElement> results;

	public List<WebElement> getResults() {
		return results;
	}
	
	
	
}
