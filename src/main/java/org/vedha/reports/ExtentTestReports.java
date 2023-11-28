package org.vedha.reports;

import org.vedha.constants.Constants;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentTestReports {
	public static ExtentReports extent;
	public static ExtentTest extenttest;
	public static ExtentSparkReporter sparkReporter;
	 
	public static ExtentReports extentReportSetup() {
		
		sparkReporter= new ExtentSparkReporter(Constants.TestReportsPath);
		extent= new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Host Name", "Vedha");
		extent.setSystemInfo("Environment", System.getenv("USERNAME"));
		extent.setSystemInfo("User Name", "Kiran SM");
		
		
		sparkReporter.config().setTimeStampFormat("MM/dd/yyyy");
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setDocumentTitle("Regression");
		sparkReporter.config().setReportName("TestAutomationReport");
		
		return extent;
	}

}
