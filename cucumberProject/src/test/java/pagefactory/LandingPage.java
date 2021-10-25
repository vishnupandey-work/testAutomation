package pagefactory;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//button[text()='Accept cookies']") WebElement AcceptCookies;
	@FindBy(xpath="//label[@for='oneWayTrip']") WebElement OneWay;
	@FindBy(xpath="//label[@for='roundTrip']") WebElement RoundTrip;
	
	public void clickOneWay() {
		OneWay.click();
	}
	
	public void clickRoundTrip() {
		RoundTrip.click();
	}
	
	public void acceptCookies() {
		AcceptCookies.click();
	}
	
}
