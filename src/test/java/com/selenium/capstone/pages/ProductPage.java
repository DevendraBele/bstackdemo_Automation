package com.selenium.capstone.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.capstone.utils.WaitUtils;

public class ProductPage {

	private WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By singleItem = By.cssSelector("*[id='4'] [class=\"shelf-item__buy-btn\"]");
	By multipleItem = By.cssSelector("*[class=\"shelf-item__buy-btn\"]");		// adding all products
	By cartCount = By.className("bag__quantity");
	
	public void addSingleItem() {
		WaitUtils.jsScrollThreeHundred(driver);
		WaitUtils.waitForBtnClickability(driver, singleItem);
		WaitUtils.jsBtnClick(driver, singleItem);
	}
	
	public void addMultipleItem(int itemCount) {
		
		List<WebElement> products = driver.findElements(multipleItem);
		for(int i = 1; i <= itemCount && i < products.size(); i++) {
			By addMultipleProduct = By.cssSelector("*[id='" + i + "'] [class=\"shelf-item__buy-btn\"]");
			WaitUtils.waitForBtnClickability(driver, addMultipleProduct);
			WaitUtils.jsBtnClick(driver, addMultipleProduct);
		}	
	}
	
	public int getCartCount() {
		WaitUtils.implicitWait(driver);
		WaitUtils.jsScrollFiveHundred(driver);
		String countText = WaitUtils.waitForElementVisibilty(driver, cartCount).getText();
		return Integer.parseInt(countText);
	}
	
}
