package sb.wd.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sb.wd.page.BaseTest;
import sb.wd.page.HomePage;
import sb.wd.page.SearchSectionPage;

public class BrowseAllCategoriesAndResearchTest extends BaseTest{
	
	private HomePage homePage;
	private SearchSectionPage searchPage;	

	@BeforeMethod
	public void setUp(){
		settingsUp();
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.open(baseUrl);
	}

	@Test
	public void testBrowseAllCategoriesAndResearchTestCase(){
		
		searchPage = homePage.goAllCategoriesPage();
		searchPage.doInputSearch("Rock", "Music");
		m_assert.assertTrue(searchPage.isTextPresent("search term = \"Rock\""));
		m_assert.assertAll();
		
	}

	@AfterMethod
	public void tearDown(){
		settingsDown();	
	}
  
}
