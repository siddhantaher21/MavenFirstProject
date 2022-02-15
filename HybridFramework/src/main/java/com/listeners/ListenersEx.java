package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.base.BaseClass;

public class ListenersEx extends BaseClass implements ITestListener{

	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "testcase is passed with name as"+result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "testcase is failed with name as"+result.getName());
		test.addScreenCaptureFromPath(takeScreenshot(result.getName()));
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "testcase is skipped with name as"+result.getName());
		//log method used to collect testcasedata to generate report 
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			}

	public void onStart(ITestContext context) {
			}

	public void onFinish(ITestContext context) {
	
	}

}
