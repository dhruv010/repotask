package com.adpushup.mavenproject;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class TC04_Box2_AdRefreshValidation {
	
/* TEST CASE:	
 * 
 * 11. Ad Refresh || Validate Box2 Ad Refresh
  STEPS: 
   - Hit url
   - Wait till page load
   - Scroll to Box2 Ad container
   - Box2 Ad should be in view
   - Wait till 30 sec on same page

  Expected: Box2 Ad should refresh

	*/
	
	
	
	

	String xpath_box3 =	"/html/body/div/div/div/div[2]/aside/div/div[@class='ad-box']";
	
	WebDriver driver; 
	WebElement box2_ad_ele,ele2;
	
	
	 @BeforeMethod
	 void launchbrowser() {
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			
		
		}	
  @Test

  void adrefreshValidation_BOX2() throws InterruptedException {
	    driver.get(ConnectProperties.getConnectProperty("url"));
	    driver.manage().window().maximize();
	    Thread.sleep(3000);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
		
		ele2=driver.findElement(By.xpath(xpath_box3));
		js.executeScript("arguments[0].scrollIntoView();", ele2);
		Thread.sleep(3000);
		String val= ele2.getAttribute("data-timeout");
		System.out.println("print value= " +val);
		
	
		Thread.sleep(32000);
	
	   
		List<WebElement> ls=driver.findElements(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/aside[1]/div[1]/div[@data-timeout='"+val+"']"));
		boolean a1=	ls.isEmpty();
		
		
		Assert.assertTrue(a1);
}
  
 

  @AfterMethod
  public void afterTest() {
	  
	  driver.quit();
	  
  }

}
