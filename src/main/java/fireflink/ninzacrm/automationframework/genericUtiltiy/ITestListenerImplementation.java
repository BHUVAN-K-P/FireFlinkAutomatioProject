package fireflink.ninzacrm.automationframework.genericUtiltiy;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
/*
 * These class implements ITestListener interface
 */
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ITestListenerImplementation implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {

		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"-----------test execution started");
		//Intimate Extent report for @test start
		test=report.createTest(methodName);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"---------------test execution success");
		//log the @test as pass for report
		test.log(Status.PASS, methodName+"test execution passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		System.out.println("-----------test execution failed");
		//capture the exception
		System.out.println(result.getThrowable());
		test.log(Status.WARNING, result.getThrowable());
		//capture the screenshot
		JavaUtility j=new JavaUtility();
		WebDriverUtility w=new WebDriverUtility();
		//ScreenShotName--->method name and date and time
		String screenshotName=methodName+j.getSystemDate();
		try {
		String path=w.captureScreenShot(BaseClass.sdriver, screenshotName);
		test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//log the @test as pass for report
				test.log(Status.FAIL, methodName+"test execution failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println("-----------test execution skipped");
		test.log(Status.INFO, result.getThrowable());
		test.log(Status.SKIP, methodName+"test execution skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("----------suite execution started");
		ExtentSparkReporter esr=new ExtentSparkReporter(".\\ExtentRepoter\\Extent-Report-"+new JavaUtility().getSystemDate());
		esr.config().setDocumentTitle("Ninza CRM Automation report");
		esr.config().setTheme(Theme.DARK);
		esr.config().setReportName("Web automation execution report");
		report=new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Microsoft Edge");
		report.setSystemInfo("Base Platform", "Windoww");
		report.setSystemInfo("Base Url", "Test Env");

		report.setSystemInfo("Reporter Name", "Bhuvna ");
		
		

	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("---------suite executin finished");
		//report generation
		report.flush();
	}

}
