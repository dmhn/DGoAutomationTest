package com.disneygo.qa.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.disneygo.qa.base.TestBase;
import com.disneygo.qa.pages.CartPage;
import com.disneygo.qa.pages.HomePage;
import com.disneygo.qa.utils.TestUtil;

public class CartPageTest extends TestBase {
	HomePage homePage;
	TestUtil testUtil;
	CartPage cartPage;
	
	public CartPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil=new TestUtil();
		homePage=new HomePage();	
		cartPage = homePage.clickOnCart();
	}
	
	@Test(priority=1)
	public void verifyCartPageText() {
			Assert.assertEquals(cartPage.verifyCartPageText(), "Your Cart","text mismatch");
	}
	
	/*
	@Test(priority=100)
	 public void findTotalLinksAndValidateLinks() {
		 List<WebElement> links = driver.findElements(By.tagName("a")); 
	 //To print the total number of links
	 System.out.println("Total links are "+links.size()); 
	 //used for loop to 
	 for(int i=0; i<links.size(); i++) {
	 WebElement element = links.get(i);
	 //By using "href" attribute, we could get the url of the requried link
	 String url=element.getAttribute("href");
	 //calling verifyLink() method here. Passing the parameter as url which we collected in the above link
	 //See the detailed functionality of the verifyLink(url) method below
	TestUtil.verifyLink(url);
	 } 
	 }
	*/
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
