

package com.adpushup.mavenproject;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;


/*TEST CASE: Validate BOX2 is displaying on webpage or not
 * 
 * 
 * 
 * */



public class TC02_Box2_30sec_display {
	WebDriver driver;
	WebElement box2_ele;
	String xpath_box2 = "//span[contains(text(),'Box-2')]";
	@BeforeMethod
	void launchbrowser() {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		
	
	}
	
	@Test
	void box2_validation() {
		
		driver.get(ConnectProperties.getConnectProperty("url"));
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 
		 
		box2_ele=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath_box2)));
		js.executeScript("arguments[0].scrollIntoView();", 	box2_ele);
		Assert.assertTrue(box2_ele.isDisplayed());
		
	}
	
	@AfterMethod
	void closeconnection()
	{
		driver.quit();
		
		
		
	}
	
	
	
}
