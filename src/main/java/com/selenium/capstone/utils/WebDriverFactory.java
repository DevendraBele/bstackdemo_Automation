package com.selenium.capstone.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
  
	public static WebDriver driver;
	
	public static WebDriver getDriver() {		
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://bstackdemo.com/signin");
		return driver;
	}
  
	public static void quitDriver() {
		if(driver != null) {
			driver.quit();
		}
	}
  
  
}
