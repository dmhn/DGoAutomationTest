package com.disneygo.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.disneygo.qa.base.TestBase;
import com.disneygo.qa.pages.AnnualPassportsPage;
import com.disneygo.qa.pages.CartPage;
import com.disneygo.qa.pages.HelpPage;
import com.disneygo.qa.pages.HomePage;
import com.disneygo.qa.pages.ParksAndTicketsPage;
import com.disneygo.qa.pages.PlacesToStayPage;
import com.disneygo.qa.pages.ShopPage;
import com.disneygo.qa.pages.ThingsToDoPage;
import com.disneygo.qa.utils.TestUtil;

public class HomePageTest extends TestBase {
	
	HomePage homePage;
	TestUtil testUtil;
	ParksAndTicketsPage parksAndTicketsPage;
	PlacesToStayPage placesToStayPage;
	ShopPage shopPage;
	ThingsToDoPage thingsToDoPage;
	AnnualPassportsPage annualPassportsPage;
	CartPage cartPage;
	HelpPage helpPage;
	
	String sheetName="homepage";
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil=new TestUtil();
		homePage=new HomePage();	
		parksAndTicketsPage=new ParksAndTicketsPage();
		placesToStayPage=new PlacesToStayPage();
		shopPage=new ShopPage();
		cartPage=new CartPage();
		annualPassportsPage=new AnnualPassportsPage();
		helpPage=new HelpPage();
		thingsToDoPage= new ThingsToDoPage();
	}
	@DataProvider
	public Object[][] getHomePageData() {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1)
	public void verifyDisneyHomePageLogo() {
			Assert.assertTrue(homePage.verifyDisneylandLogo(), "Disney image is missing");
	}
	@Test(priority=2)
	public void verifyParksAndTicketsDropDownMenu() {
			homePage.validateParksAndTicketsDropDownMenu();
	}
	
	
	@Test(priority=10)
	public void navigateToParksAndTickets() {
		parksAndTicketsPage= homePage.clickOnParksAndTickets();	
	}
	@Test(priority=2)
	public void navigateSubMenuParksAndTickets() {
		homePage.mouseHoverOnParksAndTickets();
		
	}
	@Test(priority=20)
	public void navigateToPlacesToStay() {
		placesToStayPage= homePage.clickOnPlacesToStay();	
	}
	
	@Test(priority=30)
	public void navigateToThingsToDo() {
		thingsToDoPage= homePage.clickOnThingsToDo();
	}
	@Test(priority=40)
	public void navigateToShop() {
		shopPage= homePage.clickOnShop();
	}
	@Test(priority=50)
	public void navigateToAnnualPassports() {
		annualPassportsPage= homePage.clickOnAnnualPassport();
	}
	@Test(priority=60)
	public void navigateToHelp() {
		helpPage= homePage.clickOnHelp();
	}
	@Test(priority=70)
	public void navigateToCart() {
		cartPage= homePage.clickOnCart();
	}
	//@Test(priority=2)
	//public void verifyCheckInCheckOut() {
	//	homePage.setCheckInDate();
	//}
	
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
	/*
	@Test(priority=5)
	public void verifyDropDownAndSelectCityErrorMessage() {
		homePage.selectNumberOfAdults(2);
		homePage.selectNumberOfChildren(3);
		homePage.selectNumberOfInfants(2);
		homePage.selectCurrency(prop.getProperty("currency"));
		//searchResultPage=homePage.verifySearch();
		homePage.verifyByClickingSearch();
	}
	
	@Test(priority=2)
	public void verifyDropDownAndSelectCity() {
		homePage.selectOriginCity(prop.getProperty("originCity"));
		homePage.selectDestinationCity(prop.getProperty("destinationCity"));
		homePage.selectNumberOfAdults(2);
		homePage.selectNumberOfChildren(3);
		homePage.selectNumberOfInfants(2);
		homePage.selectCurrency(prop.getProperty("currency"));
		//searchResultPage=homePage.verifySearch();
		homePage.verifyByClickingSearch();
	}
	
	

	
	*/
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
