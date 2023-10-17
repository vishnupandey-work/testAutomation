package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverProvider {
	public WebDriver driver;
	public Properties properties = new Properties();

	public WebDriver driverInstance() {

		String browserName = new String();
		int timeoutInSeconds;
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\Environment.properties");
			properties.load(fis);
			browserName = properties.getProperty("browser");
			timeoutInSeconds = Integer.parseInt(properties.getProperty("timeoutInSeconds"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			browserName = "firefox";
			timeoutInSeconds = 5;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			browserName = "firefox";
			timeoutInSeconds = 5;
		}

		switch (browserName) {
		case "CHROME":
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			/*
			 * options.addArguments("--window-size=1920,1080");
			 * options.addArguments("--no-sandbox"); options.addArguments("--headless");
			 * options.addArguments("--disable-gpu");
			 * options.addArguments("--disable-crash-reporter");
			 * options.addArguments("--disable-extensions");
			 * options.addArguments("--disable-in-process-stack-traces");
			 * options.addArguments("--disable-logging");
			 * options.addArguments("--disable-dev-shm-usage");
			 * options.addArguments("--log-level=3");
			 * options.addArguments("--output=/dev/null");
			 */
			driver = new ChromeDriver(options);
			break;
		case "FIREFOX":
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "IE":
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		default:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(timeoutInSeconds, TimeUnit.SECONDS);
		return driver;
	}

	public void driverQuit() {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("Only one browser window was open");
		}
	}

	public String takeScreenshot(WebDriver driver, String testCaseName) {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File source = scrShot.getScreenshotAs(OutputType.FILE);
		String destinationDirectoryPath = System.getProperty("user.dir") + "\\reports\\screenshots\\";

		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss.SSS");
		String formattedDateTime = currentTime.format(formatter);

		StringBuilder destinationfilename = new StringBuilder(destinationDirectoryPath)
				.append(testCaseName)
				.append("_")
				.append(formattedDateTime)
				.append(".jpg");
		File directory = new File(destinationDirectoryPath);
		if (!directory.exists()) {
			directory.mkdirs();
		} else {
			try {
				System.out.println(destinationfilename.toString());
				FileUtils.copyFile(source, new File(destinationfilename.toString()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				TestUtils.ExceptionHandler(driver, "logged exception");
				e.printStackTrace();
			}
		}
	return destinationfilename.toString();
	}

}
