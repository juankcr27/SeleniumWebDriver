package sb.wd.test;

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
	public void setUp() {
		settingsUp();
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.open(baseUrl);
	}
	
	@Test
	public void testNavigateAllCategoriesTestCase(){
		
		searchPage = homePage.goCategory(homePage.antAndCollectCategLink);
		m_assert.assertTrue(searchPage.isSelectedOption("Antiques & Collectibles"));
		homePage = searchPage.goBackToHome();
	
		searchPage = homePage.goCategory(homePage.gardenCategLink);
		m_assert.assertTrue(searchPage.isSelectedOption("Garden"));
		homePage = searchPage.goBackToHome();
		
		searchPage = homePage.goCategory(homePage.artAndCraftsCategLink);
		m_assert.assertTrue(searchPage.isSelectedOption("Arts & Crafts"));
		homePage = searchPage.goBackToHome();
		
		searchPage = homePage.goCategory(homePage.personalCategLink);
		m_assert.assertTrue(searchPage.isSelectedOption("-- Personal"));
		homePage = searchPage.goBackToHome();
		
		searchPage = homePage.goCategory(homePage.homeCategLink);
		m_assert.assertTrue(searchPage.isSelectedOption("Home"));
		homePage = searchPage.goBackToHome();
		
		searchPage = homePage.goCategory(homePage.autoCategLink);
		m_assert.assertTrue(searchPage.isSelectedOption("Auto"));
		homePage = searchPage.goBackToHome();
		
		searchPage = homePage.goCategory(homePage.musicCategLink);
		m_assert.assertTrue(searchPage.isSelectedOption("Music"));
		homePage = searchPage.goBackToHome();
		
		searchPage = homePage.goCategory(homePage.electCategLink);
		m_assert.assertTrue(searchPage.isSelectedOption("Electronics"));
		
		m_assert.assertAll();
	}
	
	@AfterMethod
	public void tearDown(){
		settingsDown();	
	}
}
