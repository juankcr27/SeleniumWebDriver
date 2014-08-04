package sb.wd.test;

import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sb.wd.page.BaseTest;
import sb.wd.page.HomePage;
import sb.wd.page.SearchSectionPage;

public class NavigateAllCategoriesTest extends BaseTest{
	
	private HomePage homePage;
	private SearchSectionPage searchPage;
	
	@BeforeMethod
	public void setUp() throws Exception {
		settingsUp();
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.open(baseUrl);
	}
	
	@Test
	public void testNavigateAllCategoriesTestCase() throws Exception {
		
		searchPage = homePage.goCategory(homePage.antAndCollectCategLink);
		assertTrue(searchPage.isSelectedOption("Antiques & Collectibles"));
		homePage = searchPage.goBackToHome();
	
		searchPage = homePage.goCategory(homePage.gardenCategLink);
		assertTrue(searchPage.isSelectedOption("Garden"));
		homePage = searchPage.goBackToHome();
		
		searchPage = homePage.goCategory(homePage.artAndCraftsCategLink);
		assertTrue(searchPage.isSelectedOption("Arts & Crafts"));
		homePage = searchPage.goBackToHome();
		
		searchPage = homePage.goCategory(homePage.personalCategLink);
		assertTrue(searchPage.isSelectedOption("-- Personal"));
		homePage = searchPage.goBackToHome();
		
		searchPage = homePage.goCategory(homePage.homeCategLink);
		assertTrue(searchPage.isSelectedOption("Home"));
		homePage = searchPage.goBackToHome();
		
		searchPage = homePage.goCategory(homePage.autoCategLink);
		assertTrue(searchPage.isSelectedOption("Auto"));
		homePage = searchPage.goBackToHome();
		
		searchPage = homePage.goCategory(homePage.musicCategLink);
		assertTrue(searchPage.isSelectedOption("Music"));
		homePage = searchPage.goBackToHome();
		
		searchPage = homePage.goCategory(homePage.electCategLink);
		assertTrue(searchPage.isSelectedOption("Electronics"));				
	    
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		settingsDown();	
	}
}
