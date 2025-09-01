package com.selenium.capstone.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.selenium.capstone.utils.WaitUtils;

public class LoginPage {
  
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By usernameField = By.id("react-select-2-input");
	private By passwordField = By.id("react-select-3-input");
	private By loginBtn = By.id("login-btn");
	
	public void enterUsername(String username) {
		driver.findElement(usernameField).sendKeys(username + Keys.ENTER);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password + Keys.ENTER);
	}
	
	public void clickLoginButton() {
		driver.findElement(loginBtn).click();
	}
	
	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLoginButton();
	}
	
	public String isLoginSuccessfull() {
		return WaitUtils.waitForElementVisibilty(driver, By.cssSelector("*[role='link']")).getText();
	}
	
}
