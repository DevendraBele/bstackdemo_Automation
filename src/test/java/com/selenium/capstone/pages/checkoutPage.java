package com.selenium.capstone.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.capstone.utils.WaitUtils;

public class checkoutPage {
	
	private WebDriver driver;
	
	public checkoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By checkoutBtn = By.className("buy-btn");
	private By firstnameField = By.cssSelector("#firstNameInput");
	private By lastnameField = By.id("lastNameInput");
	private By addressField = By.id("addressLine1Input");
	private By stateField = By.id("provinceInput");
	private By postalCodeField = By.id("postCodeInput");
	private By submitBtn = By.id("checkout-shipping-continue");	
	
	
	public void clickCheckOutBtn() {
		WaitUtils.waitForElementVisibilty(driver, checkoutBtn);
		WaitUtils.jsBtnClick(driver, checkoutBtn);
	}

	public void fillAddress(String firstName, String lastName, String address, String state, String postalCode) {
		
		WaitUtils.waitForElementVisibilty(driver, firstnameField).sendKeys(firstName);
		WaitUtils.waitForElementVisibilty(driver, lastnameField).sendKeys(lastName);
		WaitUtils.waitForElementVisibilty(driver, addressField).sendKeys(address);
		WaitUtils.waitForElementVisibilty(driver, stateField).sendKeys(state);
		WaitUtils.waitForElementVisibilty(driver, postalCodeField).sendKeys(postalCode);
	}
	
	public void submitForm() {
		WaitUtils.waitForElementVisibilty(driver, submitBtn);
		WaitUtils.jsBtnClick(driver, submitBtn);
	}
	
	public String getSuccessMessage() {
		
		WaitUtils.waitForURLIncludesWord(driver, "confirmation");
		String currentURL = driver.getCurrentUrl();
		if(currentURL.contains("confirmation")) {
			return "Your Order has been successfully placed.";
		}
		return null; 
	}

	public String getFailureMessage() {
		
		//url = https://bstackdemo.com/?signin=true
		WaitUtils.waitForURLIncludesWord(driver, "signin=true");
		String currentURL = driver.getCurrentUrl();
		if(currentURL.contains("signin=true")) {
			return "Your cart is empty";
		} 
		return null;
	}

	
}
