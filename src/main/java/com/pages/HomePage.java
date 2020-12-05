package com.pages;

import java.awt.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(className ="aap-main-header__logoimg")
	WebElement logo;
	
	@FindBy(xpath ="//*[contains(@class, \"yellow aap-primary-search__btn\")]")
	//@FindBy(className = "aap-btn aap-btn--yellow aap-primary-search__btn aap-js-primary-search-btn")
	java.util.List<WebElement> searchBar;
	
	@FindBy(xpath = "//span[@class='aap-dheader-store__storecitytxt']/span")
	WebElement addressCheckBox;
	
	@FindBy(className  ="aap-storelist__h2")
	WebElement storeLocator;
	
	
	@FindBy(id = "aap-primary-search-input")
	WebElement placeHolder;
	
	@FindBy(id = "addfs-type-select1")
	WebElement carType;
	
	@FindBy(className = "aap-main-header__garage aap-js-dheader-garage-hover")
	WebElement addAVehicle;
	
	@FindBy(id = "addfs-type-select")
	WebElement addaCarOrTruck;
	
	@FindBy(id = "aap-flyout-ymme-year")
	WebElement selectYear;
	
	@FindBy(id = "addf-vehicle-make")
	WebElement selectMake;
	
	@FindBy(id = "aap-flyout-ymme-model")
	WebElement selectModel;
	
	@FindBy(id = "aap-flyout-ymme-engine")
	WebElement selectEngine;
	
	@FindBy(className = "aap-allbtns-div")
	WebElement addAVehicleButton;
	
	@FindBy(xpath ="//button[contains(text),'CLOSE']")
	WebElement close;
	
	@FindBy(className = "aap-js-header-primary-veh" )
	WebElement vehicleSelected;
	
	@FindBy(id = "bx-element-1127409-CuSf2c6")
	WebElement popUp;
	
	public boolean clickOnLogo() throws InterruptedException {
		Thread.sleep(3000);
		if(isElementLocated(logo)) {
			return true;
		}else {
			return false;
		}	
	
	}
	
	public boolean clickOnSearchBar() throws InterruptedException {
		Thread.sleep(3000);
		clickUsingJS(searchBar.get(2));
		return true;
		
	}
	

	
	public boolean clickOnddressCheckBox() throws InterruptedException {
		addressCheckBox.click();
		Thread.sleep(3000);
		return storeLocator.isDisplayed(); 
	}
	
	
	public boolean  validatePlaceHolder() throws InterruptedException {
		String expected1 = "What part do you need today?";
		String actual1 = searchBar.get(2).getAttribute("placeholder");
		System.out.println(actual1);
		if (actual1.equals(expected1)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public String addVehicle() throws InterruptedException {
		popupHandle();
		String text = "";
		if(isElementVisible(addAVehicle))
		   addAVehicle.click();
		if(selectByValue(carType, "Car/Truck") && selectByValue(selectYear, "2018")
		 && selectByValue(selectMake, "BMW") && selectByValue(selectMake, "230i")) {
			Thread.sleep(3000);
			addAVehicleButton.click();
			close.click();
			text = vehicleSelected.getText();
		}
		return text;
	}
	
	
}
