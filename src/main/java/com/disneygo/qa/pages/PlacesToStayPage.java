package com.disneygo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.disneygo.qa.base.TestBase;

public class PlacesToStayPage extends TestBase {
		@FindBy(xpath="//h1[contains(text(),'Discover Disneyland Resort Hotels')]")
		WebElement PlacesToStayTitleText;
		
		public PlacesToStayPage() {
			PageFactory.initElements(driver, this);
		}
		public String verifyPlacesToStayTitlePageText() {
			return PlacesToStayTitleText.getText();
		}

}
