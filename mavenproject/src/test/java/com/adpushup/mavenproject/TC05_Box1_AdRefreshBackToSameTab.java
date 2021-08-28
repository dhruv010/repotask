package com.adpushup.mavenproject;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class TC05_Box1_AdRefreshBackToSameTab {

	
/*TEST CASE:
 * 
 * Ad Refresh || Validate Box1 Ad Refresh
   
  STEPS: 
   - Hit url
   - Wait till page load
   - Box1 Ad should be in view
   - Change Tab at 25th second
   - Back to same page & box1 in view

  Expected: Box1 Ad should refresh immediately
  
  *
  *
  */
	
	
	
	
	
	
	
	
	
	String xpath_box1 =	"//body/div[1]/div[1]/div[1]/div[1]";
	
	WebDriver driver; 
	WebElement box1_ad_ele,ele2;

	
	 @BeforeMethod
	 void launchbrowser() {
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			
		
		}	
  @Test
  void adrefreshValidation_BOX1() throws InterruptedException {
	  	driver.get(ConnectProperties.getConnectProperty("url"));
	    driver.manage().window().maximize();
	    Thread.sleep(3000);
		
		ele2=driver.findElement(By.xpath(xpath_box1));
		String val= ele2.getAttribute("data-timeout");
		System.out.println("print value= " +val);
	
		Thread.sleep(25000);
		
		((JavascriptExecutor)driver).executeScript("window.open(arguments[0]),'_blank'");
		
	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1)); 
	    Thread.sleep(4000);
	    driver.close();
	    driver.switchTo().window(tabs.get(0));
	   
		List<WebElement> ls=driver.findElements(By.xpath("//body/div[1]/div[1]/div[1]/div[@data-timeout='"+val+"']"));
		boolean a2=	ls.isEmpty();
		Assert.assertTrue(a2);
	 }
  
 

  @AfterMethod
  public void afterTest() {
	  
	  driver.quit();
	  
  }

}
