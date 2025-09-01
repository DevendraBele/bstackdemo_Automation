package com.selenium.capstone.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	private static int fiveSeconds = 5;
	private static int tenSeconds = 10;
	
	public static Boolean waitForURLIncludesWord(WebDriver driver, String urlWord) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(tenSeconds));
		return wait.until(ExpectedConditions.urlContains(urlWord));
	}
	
	
	public static WebElement waitForElementVisibilty(WebDriver driver, By locator) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(tenSeconds));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	
	public static WebElement waitForBtnClickability(WebDriver driver, By locator) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(tenSeconds));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	
	public static void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(fiveSeconds));
	}
	
	
	public static void jsScrollThreeHundred(WebDriver driver) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(300, 0)");
	}
	
	public static void jsScrollFiveHundred(WebDriver driver) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(500, 0)");
	}
	
	public static void jsBtnClick(WebDriver driver, By locator) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(locator);
		js.executeScript("arguments[0].click();", element);
	}
	

}
