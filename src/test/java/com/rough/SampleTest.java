package com.rough;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tests.BaseTest;

public class SampleTest extends BaseTest {
	
	//before method
	//after method
	//test
	//get gooble.com and click on one button
	
	
	@BeforeMethod
	@org.testng.annotations.Parameters(value = {"browser", "url"})
	public void openBrowser(String browser, String url) throws InterruptedException, IOException {
		 //initDriver(initProperties("browser"));
        // driver.get(initProperties("url"));
		//initDriver(initProperties("url"));
		initDriver(browser, url);
		driver.get(url);
		loggerInit();
		log.info("opened url");
		
	}
	
	@Test
	public void clickOnSearch() throws IOException {
		driver.findElement(By.className(initProperties("docclass"))).click();
	}
	
	@Test (dataProviderClass = com.dataUtils.TestData.class, dataProvider ="testData")
	public void method1(String name) {
		System.out.println(name);
	}
	@Test (dataProviderClass = com.dataUtils.TestData.class, dataProvider = "dataTest")
	public void method2(String username) {
		System.out.println(username);
	}
	
	@AfterMethod
	public void close(){
	tearDown() ;
	}

}
