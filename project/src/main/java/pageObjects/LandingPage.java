package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class LandingPage {
	private  WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//input[@name='field-keywords']")
	private WebElement SearchBox;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement SearchButton;
	
	@FindAll(value={@FindBy(xpath="") , @FindBy(id="") })
	private WebElement e;

	public WebElement getSearchBox() {
		return SearchBox;
	}

	public WebElement getSearchButton() {
		return SearchButton;
	}
	
	
	
}
