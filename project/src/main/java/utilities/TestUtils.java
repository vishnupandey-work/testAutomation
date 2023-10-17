package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtils {

	public static Logger log = LogManager.getLogger(WebDriverProvider.class.getName()); 
	
	public static void takeScreenshot(WebDriver webdriver,String filePath) {
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(filePath);
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			TestUtils.ExceptionHandler(webdriver,"logged exception");
			
		}
	}
	static void ExceptionHandler(WebDriver webdriver , String string) {
		// TODO Auto-generated method stub
		
	}
	
	
}
