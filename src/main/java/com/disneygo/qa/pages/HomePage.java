package com.disneygo.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.disneygo.qa.base.TestBase;

public class HomePage extends TestBase {


	@FindBy(css="a.disneylandLogo.uiGlobalSprite.siteLogo")
	WebElement DisneyLandLogo;

	@FindBy(xpath="//input[@id='checkInDate_display']")
	WebElement CheckInDateDropDown;
	
	//this is a dynamic web element
	@FindBy(xpath="//a[@class='gnbCategoryTitle' and contains (@name,'ParksTickets')]")
	WebElement ParksTicketsBreadCrumb;
	
	List <WebElement> ParksAndTicketsDropDownList=driver.findElements(By.xpath("//a[@class='pkLink' and contains (@name,'&lid=DLR_Header_ParksTickets_')]"));
	
	//This is very important as it gets all the dates
	//List<WebElement> SelectCheckInDates=driver.findElements(By.xpath("//button[contains(concat(' ',@class,' '), 'date'))]"));//done
	@FindBy(xpath="//a[@class='pkLink' and contains (@name,'&lid=DLR_Header_ParksTickets_Disneyland')]")
	@CacheLookup
	WebElement DisneyLandParkParksTicketsSubMenu;
	
	@FindBy(xpath="//a[@class='gnbCategoryTitle' and contains (@name,'PlaceToStay')]")
	WebElement PlacesToStayBreadCrumb;
	
	@FindBy(xpath="//a[@class='gnbCategoryTitle' and contains (@name,'ThingsToDo')]")
	WebElement ThingsToDoBreadCrumb;
	
	@FindBy(xpath="//a[@class='gnbCategoryTitle' and contains (@name,'Shop')]")
	WebElement ShopBreadCrumb;
	
	@FindBy(xpath="//a[@class='gnbCategoryTitle' and contains (@name,'AP')]")
	WebElement AnnualPassportBreadCrumb;
	
	@FindBy(xpath="//a[@class='gnbCategoryTitle' and contains (@name,'Help')]")
	WebElement HelpBreadCrumb;
	
	@FindBy(xpath="//a[@class='gnbCategoryTitle' and contains (@name,'Cart')]")
	WebElement CartBreadCrumb;
	
	@FindBy(xpath="//button[@id='5_11_2018'][2]")
	WebElement SelectCheckOutDate;
	
	@FindBy(xpath="//button[@class='button ng-click-active']")//done
	WebElement NumberOfAdultsIncrement;
	
	//methods
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyDisneylandLogo() {
		return DisneyLandLogo.isDisplayed();
	}
	public void validateParksAndTicketsDropDownMenu() {
		
		for (WebElement ItemsInParksAndTicketsDropDownList:ParksAndTicketsDropDownList)
		{
			String itemsInParksAndTicketsDropDownList= ItemsInParksAndTicketsDropDownList.getAttribute("innerHTML");
		    //Assert.assertEquals(parkTicketsMenu,itemsInParksAndTicketsDropDownList, "mismatch");
			System.out.println(itemsInParksAndTicketsDropDownList);
		    /*
			 * use this if you need to click a specific element
			if(itemsInParksAndTicketsDropDownList.contentEquals("Disneyland Park")) {
				ItemsInParksAndTicketsDropDownList.click();
				break;
			}
		}
		/*
		 * This is a basic for loop
		 
		for(int i=0;i<ParksAndTicketsDropDownList.size();i++) {
			WebElement ItemsInParksAndTicketsDropDownList=ParksAndTicketsDropDownList.get(i);
			String itemsInParksAndTicketsDropDownList= ItemsInParksAndTicketsDropDownList.getAttribute("innerHTML");
			//Assert.assertEquals(parkTicketsMenu,itemsInParksAndTicketsDropDownList, "mismatch");
			System.out.println(itemsInParksAndTicketsDropDownList);
		/*
		 * use this if you need to click a specific element
		if(itemsInParksAndTicketsDropDownList.contentEquals("Disneyland Park")) {
			ItemsInParksAndTicketsDropDownList.click();
			break;
		}
		*/
		}
		
			
	}
	public ParksAndTicketsPage clickOnParksAndTickets() {
		ParksTicketsBreadCrumb.click();
		return new ParksAndTicketsPage();
		
	}
	public DisneylandParkPage mouseHoverOnParksAndTickets() {
		Actions action=new Actions(driver);
		action.moveToElement(ParksTicketsBreadCrumb).build().perform();
		action.moveToElement(DisneyLandParkParksTicketsSubMenu).build().perform();
		DisneyLandParkParksTicketsSubMenu.click();
		return new DisneylandParkPage();
		
	}
	public PlacesToStayPage clickOnPlacesToStay() {
		PlacesToStayBreadCrumb.click();
		return new PlacesToStayPage();
		
	}public ThingsToDoPage clickOnThingsToDo() {
		ThingsToDoBreadCrumb.click();
		return new ThingsToDoPage();
		
	}public ShopPage clickOnShop() {
		ShopBreadCrumb.click();
		return new ShopPage();
		
	}public AnnualPassportsPage clickOnAnnualPassport() {
		AnnualPassportBreadCrumb.click();
		return new AnnualPassportsPage();
		
	}public HelpPage clickOnHelp() {
		HelpBreadCrumb.click();
		return new HelpPage();
		
	}public CartPage clickOnCart() {
		CartBreadCrumb.click();
		return new CartPage();
		
	}
	public void setCheckInDate() {
		//DisneyLandLogo.getScreenshotAs("Logo");
		CheckInDateDropDown.click();
		//SelectCheckInDate.click();
		//SelectCheckOutDate.click();
		//NumberOfAdultsIncrement.click();
		
		
	}
	
	/*
	public void selectDestinationCity(String destinationCityCode) {
		Select select_destination_city_DropDown=new Select (DestinationCity);
		select_destination_city_DropDown.deselectByVisibleText(destinationCityCode);
		
	}
	public void selectNumberOfAdults(int number) {
		Select number_of_AdultsDropDown=new Select (NumberofAdultsDropDown);
		number_of_AdultsDropDown.selectByIndex(number);
		
	}
	
	
	public void selectNumberOfChildren(int numberOfChildren) {
		Select number_of_ChildrenDropDown=new Select (NumberofChildrenDropDown);
		number_of_ChildrenDropDown.selectByIndex(numberOfChildren);
		
	}
	
	public void selectNumberOfInfants(int numberOfInfants) {
		Select number_of_InfantsDropDown=new Select (NumberofInfantsDropDown);
		number_of_InfantsDropDown.selectByIndex(numberOfInfants);
		
	}
	
	public void selectCurrency(String currency) {
		Select select_currency=new Select (CurrencyDropDown);
		select_currency.selectByValue(currency);
		
	}
	
	public SearchResultPage verifyByClickingSearch() {
		FindFlight.click();
		return new SearchResultPage();
	}
	/*
	public HomePage clickOnHome_BreadCrumb() {
		BreadCrumb_Home.click();
		return new HomePage();
	}
	public CalendarView clickOnCalendar_BreadCrumb() {
		BreadCrumb_Calendar.click();
		return new CalendarView();
	}
	public ContactPage clickOnContacts_BreadCrumb() {
		BreadCrumb_Contacts.click();
		return new ContactPage();
	}
	public CompaniesPage clickOnCompanies_BreadCrumb() {
		BreadCrumb_Companies.click();
		return new CompaniesPage();
	}
	public DealsPage clickOnDeals_BreadCrumb() {
		BreadCrumb_Deals.click();
		return new DealsPage();
	}
	public TasksPage clickOnTasks_BreadCrumb() {
		BreadCrumb_Tasks.click();
		return new TasksPage();
	}
	public CasesPage clickOnCases_BreadCrumb() {
		BreadCrumb_Cases.click();
		return new CasesPage();
	}
	*/
}
