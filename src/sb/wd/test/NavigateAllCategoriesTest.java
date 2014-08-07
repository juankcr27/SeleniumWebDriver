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
	public void testNavigateAllCategories(){
		
		searchPage = homePage.goCategory(homePage.antAndCollectCategLink);
		mAssert.assertTrue(searchPage.isSelectedOption("Antiques & Collectibles"));
		homePage = searchPage.goBackToHome();
	
		searchPage = homePage.goCategory(homePage.gardenCategLink);
		mAssert.assertTrue(searchPage.isSelectedOption("Garden"));
		homePage = searchPage.goBackToHome();
		
		searchPage = homePage.goCategory(homePage.artAndCraftsCategLink);
		mAssert.assertTrue(searchPage.isSelectedOption("Arts & Crafts"));
		homePage = searchPage.goBackToHome();
		
		searchPage = homePage.goCategory(homePage.personalCategLink);
		mAssert.assertTrue(searchPage.isSelectedOption("-- Personal"));
		homePage = searchPage.goBackToHome();
		
		searchPage = homePage.goCategory(homePage.homeCategLink);
		mAssert.assertTrue(searchPage.isSelectedOption("Home"));
		homePage = searchPage.goBackToHome();
		
		searchPage = homePage.goCategory(homePage.autoCategLink);
		mAssert.assertTrue(searchPage.isSelectedOption("Auto"));
		homePage = searchPage.goBackToHome();
		
		searchPage = homePage.goCategory(homePage.musicCategLink);
		mAssert.assertTrue(searchPage.isSelectedOption("Music"));
		homePage = searchPage.goBackToHome();
		
		searchPage = homePage.goCategory(homePage.electCategLink);
		mAssert.assertTrue(searchPage.isSelectedOption("Electronics"));
		
		mAssert.assertAll();
	}
	
	@AfterMethod
	public void tearDown(){
		settingsDown();	
	}
}
