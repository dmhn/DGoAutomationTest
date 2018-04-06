package com.disneygo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.disneygo.qa.base.TestBase;

public class CartPage extends TestBase {
	@FindBy(xpath="//h1[contains(text(),'Your Cart')]")
	WebElement YourCartText;
	
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	public String verifyCartPageText() {
		return YourCartText.getText();
	}


}
