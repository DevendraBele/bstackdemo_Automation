package com.selenium.capstone.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReport {
	
	public static ExtentReports report() {

		ExtentSparkReporter reporter = new ExtentSparkReporter("BStack_ExtentReport1.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
	    extent.setSystemInfo("Project", "bstackdemo");
	    extent.setSystemInfo("Tester", "Devendra");
	    return extent;
	}

}
