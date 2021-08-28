package com.adpushup.mavenproject;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/*TEST CASE: Validate BOX1 is displaying on webpage or not
 * 
 * 
 * */

public class TC01_Box1_30sec_display {
	String xpath_box1 = "//span[contains(text(),'Box-1')]";
	WebDriver driver; 
	WebElement box1_ele;
	
	
	
	@BeforeMethod
	void launchbrowser() {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		
	
	}
	
	@Test
	void box1_validation() {
		
		driver.get(ConnectProperties.getConnectProperty("url"));
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		box1_ele=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath_box1)));
		
		
		Assert.assertTrue(box1_ele.isDisplayed());
		
	}
	
	@AfterMethod
	void closeconnection()
	{
		driver.quit();
		
		
	}
	
	
	
}
