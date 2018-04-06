package com.disneygo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.disneygo.qa.base.TestBase;

public class DisneylandParkPage extends TestBase{
	
	@FindBy(xpath="//h1[contains(text(),'Disneyland Park')]")
	WebElement DisneylandParkText;
	
	public DisneylandParkPage() {
		PageFactory.initElements(driver, this);
	}
	public String verifyDisneylandParkText() {
		return DisneylandParkText.getText();
	}

}
