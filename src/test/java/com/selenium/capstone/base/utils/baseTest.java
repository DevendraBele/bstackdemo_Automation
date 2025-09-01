package com.selenium.capstone.base.utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.selenium.capstone.utils.WaitUtils;
import com.selenium.capstone.utils.WebDriverFactory;
import com.selenium.capstone.utils.extentReport;

public class baseTest {
  
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	@BeforeSuite
	public void beforeSuite() {
		extent = extentReport.report();
	}
	 
	
	@BeforeMethod
	public static void launchURL() {
		driver = WebDriverFactory.getDriver();
	}
	 
	@AfterMethod
	public static void closeURL() {
		WaitUtils.implicitWait(driver);
		 WebDriverFactory.quitDriver();
	}

	
	@AfterSuite
	public void afterSuite() {
		extent.flush();
	}

}
