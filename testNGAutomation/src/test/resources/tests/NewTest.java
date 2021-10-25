import org.testng.annotations.*;

public class NewTest {

	WebDriver driver;

	@Test(dataProvider = "dp")
	public void f(Integer n, String s) {
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, };
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void afterSuite() {
	}

}
