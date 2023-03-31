package testClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import net.bytebuddy.agent.builder.AgentBuilder.Identified.Extendable;
import utilities.CaptureScreen;
import utilities.StaticBrowser;


public class BaseClass {
	WebDriver driver;
	public static ExtentReports report;
	public static ExtentHtmlReporter extent;
	public static ExtentTest logger;
	@Parameters({"browser"})
	@BeforeTest
	public void beforeClass(String browser) {
		WebDriver driver = StaticBrowser.anybrowseropen(browser,
				"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		this.driver = driver;
		extent = new ExtentHtmlReporter("test-output/Report/"+System.currentTimeMillis()+".html");
		report = new ExtentReports();
		report.attachReporter(extent);
	}

	@BeforeMethod
	public void beforeMethod() {
		
	}
	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			String source= CaptureScreen.screenshot(driver);
		//	logger.log(Status.FAIL, "Test is Failed");
		//	logger.log(Status.FAIL,"Test",MediaEntityBuilder.createScreenCaptureFromPath(source).build());
		//	logger.addScreencastFromPath(source);
			logger.fail("Test Case Failed",MediaEntityBuilder.createScreenCaptureFromPath(source).build());
			

		}
		report.flush();
	}

	@AfterTest
	public void afterclass() {
		driver.quit();
	}

}
