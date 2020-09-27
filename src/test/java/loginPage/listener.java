package loginPage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.relevantcodes.extentreports.LogStatus;

import resources.ExtentReporter;
import resources.baseURL;

public class listener extends baseURL implements ITestListener {
	
	ExtentTest test;
	ExtentReports extent=ExtentReporter.getReport();
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=extent.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
		extentTest.get().log(Status.PASS, "TEST PASSED");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().fail(result.getThrowable());
		extentTest.get().log(Status.FAIL, "TEST FAILED");
		WebDriver driver=null;
		String failedtestname=result.getMethod().getMethodName();
				
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			} catch (Exception e)
		{
			
		}
				
		try {
			
			extentTest.get().addScreenCaptureFromPath(getscreenshot(failedtestname,driver ), result.getMethod().getMethodName());
			//getscreenshot(failedtestname, driver );
			} catch (IOException e) {
						e.printStackTrace();
		}
		
		//ITestListener.super.onTestFailure(result);
	}

	public void onTestSkipped(ITestResult result) {
		extentTest.get().skip(result.getThrowable());
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
		extent.flush();
	}
	

	
	
	

}
