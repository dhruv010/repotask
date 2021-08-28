package com.adpushup.mavenproject;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.List;

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

public class TC03_Box1_AdRefreshValidation {

	
/*TEST CASE:
 * 
 * 10. Ad Refresh || Validate Box1 Ad Refresh
  STEPS: 
   - Hit url
   - Wait till page load
   - Box1 Ad should be in view
   - Wait till 30 sec on same page

	Expected: Box1 Ad should refresh.
  
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
	    Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(driver, 5);
		
		ele2=driver.findElement(By.xpath(xpath_box1));
		Thread.sleep(3000);
		String val= ele2.getAttribute("data-timeout");
		System.out.println("print value= " +val);
		
		Thread.sleep(32000);
	
	
		List<WebElement> ls=driver.findElements(By.xpath("//body/div[1]/div[1]/div[1]/div[@data-timeout='"+val+"']"));
		boolean a1=	ls.isEmpty();
		
		
		Assert.assertTrue(a1);
	  
	  
	  
	  
  }
  
 

  @AfterMethod
  public void afterTest() {
	  
	  driver.quit();
	  
  }

}
