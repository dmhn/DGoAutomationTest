package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//page factory--OR
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginSubmitBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement crmLogoImage;
	
	// Initializing Page Objects:
	//creating a constructor for the class LoginPage
	//this points to current class objects, we are initializing all objects defined in this class
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	// Actions: now I define all the actions in login page
	
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	public boolean validateCRMImage() {
		return crmLogoImage.isDisplayed();
	}
	
	public HomePage login(String usrnm, String pwd ) {
		username.sendKeys(usrnm);
		password.sendKeys(pwd);
		loginSubmitBtn.submit();
		//JavascriptExecutor js = (JavascriptExecutor)driver; 
	    //js.executeScript("arguments[0].click();", loginSubmitBtn);
	         return new HomePage(); 
		// on successful login, the user is navigated to home page
		//so this method should return HomePage class
		
	}
	
}
