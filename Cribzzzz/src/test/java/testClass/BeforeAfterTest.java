package testClass;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

//import report.ExtentManager;
import testBase.TestBase;

public class BeforeAfterTest extends TestBase {

	static {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		System.setProperty("current.date.time", dateFormat.format(new Date()));
	}

	public static Logger log = Logger.getLogger(BeforeAfterTest.class);

	@BeforeSuite
	public void beforeSuite() {
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/main/java/log.properties");
//		ExtentManager.onStart();
	}

	@BeforeMethod
	public void beforeMethod(ITestResult result) {
//		ExtentManager.onTestSuccess(result.getMethod().getMethodName());
		prerequisite();
		log.info("Driver triggered");
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
//			ExtentManager.onTestFailure(result.getMethod().getMethodName());
			Assert.fail(result.getThrowable().getMessage());
		} else if (result.getStatus() == ITestResult.SKIP) {
//			ExtentManager.onTestSkipped(result.getMethod().getMethodName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {

		}

		driver.close();
	}

	@AfterSuite
	public void afterSuite() {
//		ExtentManager.onFlush();
	}

}
