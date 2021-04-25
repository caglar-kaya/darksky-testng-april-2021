package com.darksky.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.darksky.base.BasePage;
import com.darksky.util.ElementUtil;


public class HomePage extends BasePage {

	// Fields
	WebDriver driver;
	ElementUtil elementUtil;

	// Locators
	By locationInput = By.xpath("//*[@id=\"searchForm\"]/input");
	By searchIcon = By.xpath("//*[@id=\"searchForm\"]/a[2]/img");
	By lowTemp = By.xpath("//*[@id=\"title\"]/span[1]/span[2]/span[2]/span[2]/span[2]");
	By highTemp = By.xpath("//*[@id=\"title\"]/span[1]/span[2]/span[2]/span[3]/span[2]");

	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	// Actions
	public void sendLocation(String location) {
		elementUtil.doSendKeys(locationInput, location);
	}

	public void clickOnSearchIcon() {
		elementUtil.doClick(searchIcon);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Boolean isDisplayedLowTemp() {
		return elementUtil.doIsDisplayed(lowTemp);
	}

	public Boolean isDisplayedHighTemp() {
		return elementUtil.doIsDisplayed(highTemp);
	}

}








