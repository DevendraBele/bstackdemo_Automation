package com.selenium.capstone.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.capstone.utils.WaitUtils;

public class CartPage {
	
	private WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
//	By cartIcon = By.cssSelector("*[class=\"bag bag--float-cart-closed\"]");
	By cartIcon = By.xpath("//*[@id=\"__next\"]/div/div/div[2]/span");
	By cartQuantity = By.className("bag__quantity");
	By removeItem = By.cssSelector("*[class=\"shelf-item__del\"]");
	
	public void openCart() {
		WaitUtils.waitForElementVisibilty(driver, cartIcon).click();
	}
	
	public int getCartCount() {
		return Integer.parseInt(driver.findElement(cartQuantity).getText());
	}
	
	public void removeItems() {
		List<WebElement> remove = driver.findElements(removeItem);
		for(WebElement button : remove) {
			button.click();
		}
	}

}
