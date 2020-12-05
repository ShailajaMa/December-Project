package com.rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tests.BaseTest;

public class FindDoctor extends BaseTest {
	
	@BeforeMethod
	@org.testng.annotations.Parameters(value = {"browser", "url"})
	public void openUrl(String browser, String url) {
		//initProperties("url");
		initDriver(browser, url);
		driver.get(url);
		driver.manage().window().maximize();
			
	}
	@Test
	public void findADoctor() {
		scrollToLocation("112", "", driver.findElement(By.xpath(initProperties("findPharmacy"))));
		//System.out.println(driver.findElement(By.xpath(initProperties("findPharmacy"))).getLocation());
		driver.findElement(By.xpath(initProperties("findPharmacy"))).click(); 
		/*
		 * WebElement pharDrop =
		 * driver.findElement(By.id(initProperties("pharDropDown_Id")));
		 * selectByValue(pharDrop, "pharmacy"); WebElement typeDrop =
		 * driver.findElement(By.id(initProperties("typeDrop_Id")));
		 * selectByValue(typeDrop, "Select a Type");
		 * driver.findElement(By.xpath("//input[@value='zip']"));
		 * driver.findElement(By.xpath("//input[@id='zipcode']")).
		 * sendKeys("150 linda lane");; WebElement distance =
		 * driver.findElement(By.xpath("//input[@id='miles']")); selectByValue(distance,
		 * "10 miles"); WebElement selectPlan =
		 * driver.findElement(By.id("pharmacy_plans")); selectByValue(selectPlan,
		 * "FSTP|Rx Discount Programs"); driver.findElement(By.id("advanced_submit"));
		 * //wrong locator
		 */		
	}
	

}
