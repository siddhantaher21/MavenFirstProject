package com.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Log;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.PropertiesUtility;

public class BaseClass {//This class should have all common code

	public static WebDriver driver=null;
	public static  Logger log=Logger.getLogger("BaseClass");

	public static ExtentReports report=null; // generated report attached by this
	public static ExtentSparkReporter spark=null; // report generate
	public static ExtentTest test=null;



	public static void initialization() throws Exception{
		System.out.println("initializing browser"); // only print  
		log.info("initializing browser");//print file on console with line no. , date and time
		String browser= PropertiesUtility.readproperty("browser");

		if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","chromedriver.exe"); 
			driver=new ChromeDriver();
		} 
		if(browser.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(PropertiesUtility.readproperty("url"));
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}	
	public void reportInit(){ // used to create report 
		report=new ExtentReports();
		spark=new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReport.html");
		report.attachReporter(spark); //screenshot ,fail cases generated
	}

	public String takeScreenshot(String name){ //used to capture and save screenshot
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/screenshots/"+name+".jpg";
		File dest=new File(path);
		try {
			FileUtils.copyFile(source, dest );
		} catch (IOException e) {
			e.printStackTrace();
		} 

		return path;
	}











}
