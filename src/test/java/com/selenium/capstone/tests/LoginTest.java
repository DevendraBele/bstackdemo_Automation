package com.selenium.capstone.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.capstone.base.utils.baseTest;
import com.selenium.capstone.pages.LoginPage;
import com.selenium.capstone.utils.WaitUtils;

public class LoginTest extends baseTest{

	@Test(priority = 1)
	public void emptyLogin() {
		test = extent.createTest("Login with empty credentials");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickLoginButton();
		String errorMsg = WaitUtils.waitForElementVisibilty(driver, By.className("api-error")).getText();
		Assert.assertEquals(errorMsg,"Invalid Username");
		test.pass("Empty Credential");
		WaitUtils.implicitWait(driver);
		System.out.println("empty login done");
	}
	
	
	@Test(priority = 2)
	public void invalidLogin() {
		test = extent.createTest("Login with invalid credentials");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("guest_user", "testingisfun99");
		String errorMsg = WaitUtils.waitForElementVisibilty(driver, By.className("api-error")).getText();
		Assert.assertEquals(errorMsg,"Invalid Username");
		test.pass("Invalid Login");
		WaitUtils.implicitWait(driver);
		System.out.println("invalid login done");
	}
	
	
	@Test(priority = 3)
	public void validLogin() {
		test = extent.createTest("Login with valid credentials");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("demouser", "testingisfun99");
		String successMsg = loginPage.isLoginSuccessfull();
		Assert.assertEquals(successMsg.trim(), "Logout");
   	 	test.pass("LogIn successful");
   	 	WaitUtils.implicitWait(driver);
		System.out.println("valid login done");
	}
	
	
}
