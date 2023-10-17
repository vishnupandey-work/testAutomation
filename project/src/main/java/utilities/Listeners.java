package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.*;
import utilities.WebDriverProvider;

import org.openqa.selenium.TakesScreenshot;

public class Listeners extends WebDriverProvider implements ITestListener {
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); // Thread safe

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String testMethodName = result.getMethod().getMethodName();
		test = extent.createTest(testMethodName);
		extentTest.set(test); // Thread safe
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test Passed"); // Thread safe
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testMethodName = result.getMethod().getMethodName();
		extentTest.get().fail(result.getThrowable()); // Thread Safe
		try {
			WebDriver driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
			String filename = takeScreenshot(driver, testMethodName);
			extentTest.get().addScreenCaptureFromPath(filename);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}
}
