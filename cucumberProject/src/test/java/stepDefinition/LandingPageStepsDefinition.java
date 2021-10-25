package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pagefactory.LandingPage;

public class LandingPageStepsDefinition {
	protected static WebDriver driver;

	@Given("user is on landing page of Indigo")
	public void user_is_on_landing_page_of_indigo() {
		// Write code here that turns the phrase above into concrete actions
		/*
		WebDriverManager.firefoxdriver().setup();
		FirefoxProfile geoDisabled = new FirefoxProfile();
		geoDisabled.setPreference("geo.enabled", false);
		geoDisabled.setPreference("geo.provider.use_corelocation", false);
		geoDisabled.setPreference("geo.prompt.testing", false);
		geoDisabled.setPreference("geo.prompt.testing.allow", false);
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability(FirefoxDriver.PROFILE, geoDisabled);
		FirefoxOptions options = new FirefoxOptions();
		options.merge(capabilities);
		driver = new FirefoxDriver(options);
		driver.get("https://www.goindigo.in/");
		LandingPage landingPage = new LandingPage(driver);
		landingPage.acceptCookies();
		*/
		System.out.println("Test Started");
		// throw new io.cucumber.java.PendingException();
	}

	@When("user wants to book a One-way ticket from {string} to {string}")
	public void user_wants_to_book_a_one_way_ticket_from_to(String source, String destination) {
		System.out.println(source+"->"+destination);
		//throw new io.cucumber.java.PendingException();
	}

	@When("Departure Date is {string} {string} {string}")
	public void departure_date_is(String date, String month, String year) {
		System.out.println("Travel-Date is "+date+"-"+month+"-"+year);
		//throw new io.cucumber.java.PendingException();
	}

	@Then("user can search for flight")
	public void user_can_search_for_flight() {
		System.out.println("Search for flight");
		//throw new io.cucumber.java.PendingException();
	}

}
