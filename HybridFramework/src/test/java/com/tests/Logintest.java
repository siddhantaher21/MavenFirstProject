package com.tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.BaseClass;
import com.pages.LoginPage;

public class Logintest extends BaseClass {

	LoginPage lp=null;
	@BeforeSuite
	public void setup() throws Exception{
		initialization();
		reportInit();
		lp=new LoginPage(driver);
	}



	@AfterSuite
	public void  teardown(){
		driver.close();
		report.flush(); // to save all data into the report
	}

	@AfterMethod
	public void reportsetup(ITestResult result){

		if(test.getStatus()==Status.FAIL){
			test.log(Status.FAIL,"testcased failed with name"+result.getName());
		}

		if(test.getStatus()==Status.PASS){
			test.log(Status.PASS,"testcased passed with name"+result.getName());
		}

		if(test.getStatus()==Status.SKIP){
			test.log(Status.SKIP,"testcased skipped with name"+result.getName());
		}
	}

	@Test
	public void test01(){
		Assert.assertEquals(driver.getTitle(),"JavaByKiran | Dashboard");	
	}

	@Test
	public void test02(){
		lp.loginToApplication("kiran@gmail.com", "123456");
		Assert.assertEquals(driver.getTitle(),"JavaByKiran | Dashboard");
	}

	@Test
	public void test03(){
		throw new SkipException("skipping a testcase");
	}
	@Test
	public void test04(){
		throw new SkipException("skipping a testcase");
}
}