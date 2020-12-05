package com.rough;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/src/main/resources/com/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	       
        //Navigate to the demo site
        driver.get("https://demoqa.com/text-box");
       
        // Enter the Full Name
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Mr.Peter Haynes");
        
        //Enter the Email
        WebElement email=driver.findElement(By.id("userEmail"));
        email.sendKeys("PeterHaynes@toolsqa.com");
        
        // Enter the Current Address
        WebElement currentAddress=driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("43 School Lane London EC71 9GO");
       
        // Copy the Current Address
        Thread.sleep(3000);
        currentAddress.sendKeys(Keys.chord(Keys.CONTROL, "a"));
 
        Thread.sleep(3000);
        currentAddress.sendKeys(Keys.chord(Keys.CONTROL, "C"));
       
       
        //Press the TAB Key to Switch Focus to Permanent Address
        currentAddress.sendKeys(Keys.TAB);
        
        //Paste the Address in the Permanent Address field
        WebElement permanentAddress=driver.findElement(By.id("permanentAddress"));
        Thread.sleep(3000);
        permanentAddress.sendKeys(Keys.chord(Keys.CONTROL, "V"));
       
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
       
        
        //Compare Text of current Address and Permanent Address
       // assertEquals(currentAddress.getAttribute("value"),permanentAddress.getAttribute("value"));
        
        driver.close();
 
 }

	}
	
