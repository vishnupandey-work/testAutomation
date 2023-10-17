package vpandey;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class StandaloneTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.demoblaze.com/index.html");
		System.out.println(driver.getTitle());
		List<WebElement> cards = driver.findElements(By.cssSelector(".card"));
		WebElement myCard = cards.stream().filter(card ->
		card.findElement(By.cssSelector(".card-title a")).getText().equals("Nexus 6")).findFirst().orElse(null);
		myCard.click();
		try {
			driver.wait(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

}
