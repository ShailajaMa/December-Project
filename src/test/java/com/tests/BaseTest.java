package com.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
	
	protected WebDriver driver;
	protected Properties prop;
	protected Logger log;
	protected  JavascriptExecutor javascriptExecutor;
	
	public void initDriver(String browser, String url) {
		
		switch(browser){
		 case "chrome":
			 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/src/main/resources/com/drivers/chromedriver.exe");
		     driver = new ChromeDriver();
		     break;
		     
		 case "firefox":
			 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/com/drivers/geckodriver.exe");
			 driver = new FirefoxDriver();
			 break;	
		 case "IE":
			 System.setProperty("webDriver.ie.driver", System.getProperty("user.dir")+ "/src/main/resources/com/drivers/IEDriverServer.exe");
			 driver = new InternetExplorerDriver();
			 break;
		 default:
		     System.out.println("enter correct browser name");
		
	}
		driver.get(url);
			
	
}
	
	public String initProperties(String property)  { 
		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/com/properties/OR.properties") ;
			prop = new Properties();	
			prop.load(file);
			 
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return prop.getProperty(property);
	}
	
	public void loggerInit() {
		log =  Logger.getLogger("devpinoyLogger");
	

}
	
	public void scrollToLocation(String x, String y, WebElement element) {
        javascriptExecutor = (JavascriptExecutor) driver;
        if(isElementLocated(element)) {
        javascriptExecutor.executeScript("window.scrollTo(" + x + "," + y + ");", element);
        }
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
	
	
	
	
	
	
	public void action() {
		Actions action = new Actions(driver);
		action.keyUp( Keys.SHIFT);
	}
	
	public void tearDown() {
		driver.quit();
	}
}




