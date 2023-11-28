package org.vedha.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.vedha.baseclass.BaseTest;
import org.vedha.corecomponents.SeleniumUtils;
import org.vedha.reports.ExtentTestReports;

import com.aventstack.extentreports.Status;

public class ExtentReportListeners extends ExtentTestReports implements ITestListener{
	public void onTestStart(ITestResult result) {
	    extenttest= extent.createTest(result.getMethod().getMethodName());
	  }

	  /**
	   * Invoked each time a test succeeds.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SUCCESS
	   */
	  public void onTestSuccess(ITestResult result) {
	   extenttest.log(Status.PASS, result.getMethod().getMethodName());
	  }

	  /**
	   * Invoked each time a test fails.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#FAILURE
	   */
	  public void onTestFailure(ITestResult result) 
		{
			extenttest.log(Status.FAIL, "Test Case Failed is ::: " +result.getMethod().getMethodName());
			extenttest.log(Status.FAIL, result.getThrowable());
			
			try 
			{
				extenttest.addScreenCaptureFromPath(SeleniumUtils.getScreenshot(BaseTest.instance(), result.getMethod().getMethodName()));
			} 
			catch(IOException e) 
			{
				e.printStackTrace();
			}
		}

	  /**
	   * Invoked each time a test is skipped.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SKIP
	   */
	  public void onTestSkipped(ITestResult result) {
		  extenttest.log(Status.SKIP, result.getMethod().getMethodName());
	  }

	  /**
	   * Invoked each time a method fails but has been annotated with successPercentage and this failure
	   * still keeps it within the success percentage requested.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
	   */
	 

	  /**
	   * Invoked before running all the test methods belonging to the classes inside the &lt;test&gt; tag
	   * and calling all their Configuration methods.
	   *
	   * @param context The test context
	   */
	  public void onStart(ITestContext context) {
            extent = ExtentTestReports.extentReportSetup();
	  }

	  /**
	   * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have run
	   * and all their Configuration methods have been called.
	   *
	   * @param context The test context
	   */
	  public void onFinish(ITestContext context) {
	    // not implemented
		  extent.flush();
	  }

}
