package com.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	JavascriptExecutor javascriptExecutor;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isElementLocated(WebElement element) {
		boolean isElementLocated= false;
		try {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		isElementLocated = true;
		}catch (Exception e){
		 e.printStackTrace();
		}
		return isElementLocated;
	}
	
	public boolean isElementVisible(WebElement element) {
		boolean isElementVisible = false;
		try {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		isElementVisible = true;
		}catch (Exception e){
		 e.printStackTrace();
		}
		return isElementVisible;
	}
	public boolean selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        if(isElementVisible(element)) {
            select.selectByVisibleText(value);
        return true;
        				
        }else {
        	return false;
        }
    }
	
	public void waitForElementVisibility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void popupHandle() throws InterruptedException {
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		alert.dismiss();
					
		}
	 public boolean clickUsingJS(WebElement element) {
	        javascriptExecutor  = (JavascriptExecutor)driver;
	        waitForElementVisibility(element);
	        javascriptExecutor.executeScript("arguments[0].click();", element);
	        return true;
	    }

	}


	
	
	


