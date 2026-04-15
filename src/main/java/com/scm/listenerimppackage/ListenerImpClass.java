package com.scm.listenerimppackage;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.scm.baseclasses.UtilityClassObject;
import com.scm.generic_utilities.Java_Utility_True;

public class ListenerImpClass implements ITestListener, ISuiteListener {

	ExtentSparkReporter spark;
	ExtentReports report;
	ExtentTest test;
	String date;

	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		test = report.createTest(testName);
		test.log(Status.INFO, testName + " Test Execution started");
		UtilityClassObject.setTest(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		test.log(Status.PASS, testName + "Test Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot) UtilityClassObject.getDriver();
		String scrshot = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(scrshot, "screenshot_" + date);
		test.log(Status.FAIL, testName + " Test Fail");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		test.log(Status.SKIP, testName + " Test Skipped");
	}

	@Override
	public void onStart(ISuite suite) {
		Java_Utility_True ju = new Java_Utility_True();
		date = ju.getSystemDate();
		spark = new ExtentSparkReporter("./advanced_report/report" + date + ".html");
		spark.config().setDocumentTitle("scm_advanced_report");
		spark.config().setReportName("scm_report");
		spark.config().setTheme(Theme.DARK);
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Operating System", "Windows11");
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
		System.out.println("Report saved");
	}
}
