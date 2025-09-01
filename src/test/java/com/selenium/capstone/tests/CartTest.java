package com.selenium.capstone.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.capstone.base.utils.baseTest;
import com.selenium.capstone.pages.CartPage;
import com.selenium.capstone.pages.LoginPage;
import com.selenium.capstone.pages.ProductPage;
import com.selenium.capstone.utils.WaitUtils;

public class CartTest extends baseTest{

	@Test(priority = 1)
	public void addSingleItem() {
		//TC_004: Add single item to cart
		test  = extent.createTest("Adding Single Item In Cart");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("demouser", "testingisfun99");
		//
		ProductPage productPage = new ProductPage(driver);
		WaitUtils.implicitWait(driver);
		productPage.addSingleItem();
		//
		int ActualCartCount = productPage.getCartCount();
		Assert.assertEquals(ActualCartCount, 1); 
		test.pass("Added Single item sucessfully");
		//
		WaitUtils.implicitWait(driver);
		System.out.println("Added Single item sucessfully");
		
	}
  
    @Test(priority = 2, dependsOnMethods = "addSingleItem")
    public void addMultipleItem() {
    		//TC_005: Add multiple items to cart and verify cart count
    		test = extent.createTest("Adding Multiple Items In Cart");
    		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("demouser", "testingisfun99");
		//
		ProductPage productPage = new ProductPage(driver);
		WaitUtils.implicitWait(driver);
		int itemCount = 5;
		productPage.addMultipleItem(itemCount);
		//
		int ActualCartCount = productPage.getCartCount();
		Assert.assertEquals(ActualCartCount, itemCount);  
		test.pass("Adding multiple item sucessful");
		//
		WaitUtils.implicitWait(driver);
		System.out.println("Adding Multiple item sucessfully");
    }
  
    @Test(priority = 3, dependsOnMethods = "addSingleItem")
    public void removeAllItems() {
    		//- TC_006: Remove item from cart
    		test = extent.createTest("Removing all Items from the Cart");
    		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("demouser", "testingisfun99");
		WaitUtils.implicitWait(driver);
		//
		ProductPage productPage = new ProductPage(driver);
		WaitUtils.implicitWait(driver);
		int itemCount = 5;
		productPage.addMultipleItem(itemCount);
		//
		CartPage cartPage = new CartPage(driver);
		cartPage.removeItems();
		int cartCount = cartPage.getCartCount();
		Assert.assertEquals(cartCount,0);
		test.pass("Removing all the Items sucessfully");
		//
		WaitUtils.implicitWait(driver);
		System.out.println("Removing all the Items sucessfully");
    }
}
