package com.selenium.capstone.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.capstone.base.utils.baseTest;
import com.selenium.capstone.pages.CartPage;
import com.selenium.capstone.pages.LoginPage;
import com.selenium.capstone.pages.ProductPage;
import com.selenium.capstone.pages.checkoutPage;


public class CheckOutTest extends baseTest{
	
	@Test (priority = 1)
	public void invalidCheckOut() {
		
		//TC_008: Checkout flow without adding items (negative test)
		test = extent.createTest("Placing order with Invalid details");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("demouser", "testingisfun99");
		
		CartPage cartPage = new CartPage(driver);
		cartPage.openCart();
		
		checkoutPage chkOut = new checkoutPage(driver);
		chkOut.clickCheckOutBtn();
		
		String failureMsg = chkOut.getFailureMessage();
		System.out.println(failureMsg);
		Assert.assertEquals(failureMsg, "Your cart is empty");
		test.pass("Order is not placed becauze cart was empty");
		System.out.println("invalid checkout successful");
		
	}

	@Test (priority = 2)
	public void validCheckOut() {
		
		//TC_007: Place order with valid details
		test = extent.createTest("Placing order with Valid details");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("demouser", "testingisfun99");
		
		ProductPage productpage = new ProductPage(driver);
		productpage.addSingleItem();
		
		checkoutPage chkOut = new checkoutPage(driver);
		chkOut.clickCheckOutBtn();
		chkOut.fillAddress("ross", "gellar", 
				"90 Bedford Street in Greenwich Village, New York City", 
				"New York", "10014");
		chkOut.submitForm();
		
		String successMsg = chkOut.getSuccessMessage();
		System.out.println(successMsg);
		Assert.assertEquals(successMsg, "Your Order has been successfully placed.");
		test.pass("Order placed successfully");
		System.out.println("valid checkout successfull");
	}
	
}
