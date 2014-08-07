package sb.wd.test;

import static org.testng.AssertJUnit.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sb.wd.page.BaseTest;
import sb.wd.page.HomePage;
import sb.wd.page.SearchSectionPage;

public class SearchSectionTest extends BaseTest{
	
	private HomePage homePage;
	private SearchSectionPage searchPage;

	@BeforeMethod	
	public void setUp() {
		settingsUp();
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.open(baseUrl);
	}

	@Test
	public void testSearchSection(){	  		
		searchPage = homePage.goSearch("Arts");		
		searchPage.doSearch("Arts & Crafts");
		assertTrue(searchPage.isSearchPage());		
	}

	@AfterMethod
	public void tearDown(){
		settingsDown();	
	}

}
