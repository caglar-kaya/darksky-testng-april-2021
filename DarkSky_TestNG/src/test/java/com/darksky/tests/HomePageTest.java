package com.darksky.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.darksky.base.BasePage;
import com.darksky.pages.HomePage;
import com.darksky.util.ElementUtil;

public class HomePageTest {

	WebDriver driver;
	Properties properties;
	ElementUtil elementUtil;
	BasePage basePage;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		properties = basePage.initialize_properties();
		driver = basePage.initialize_driver(properties);
		homePage = new HomePage(driver);
		elementUtil = new ElementUtil(driver);
	}
	
	@Test(priority = 1, description = "Test for Low Temp and High Temp")
	public void isDisplayedLowAndHighTemp() {
		homePage.sendLocation("Athens");
		homePage.clickOnSearchIcon();
		Assert.assertTrue(homePage.isDisplayedLowTemp());
		Assert.assertTrue(homePage.isDisplayedHighTemp());
	}
	
	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}
}

