package com.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pages.HomePage;

import freemarker.core._SortedArraySet;

public class TestHomePage extends BaseTest{
	
	
	@BeforeMethod
	@org.testng.annotations.Parameters(value = {"browser","url"})
	public void lauchBrowser(String browser, String url) {
		initDriver(browser, url);
	}
	@Test (enabled = false)
	public void testClickOnLogo() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(homePage.clickOnLogo());
	}
	@Test
	public void testClickOnSearchBar() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(homePage.clickOnSearchBar());
		softAssert.assertAll();
	}
	@Test(enabled = false)
	public void testValidatePlaceHolder() throws InterruptedException {
	try {
		
			HomePage homePage = new HomePage(driver);
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(homePage.validatePlaceHolder());
			softAssert.assertAll();
			
			
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	@Test(enabled = false)
	public void testClickOnAddressCheckBox() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(homePage.clickOnddressCheckBox());
		softAssert.assertAll();
		

	}
	
	@Test(enabled = false)
	public void testAddVehicle() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		SoftAssert softAssert;
		try {
			softAssert = new SoftAssert();
			softAssert.assertEquals(homePage.addVehicle(), "2018 BMW 230i", "vehicle info is not seclected as expected");
			softAssert.assertAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@AfterMethod
	public void closeBrowser() {
		tearDown();
}
	
}
