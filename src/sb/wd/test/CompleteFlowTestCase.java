package sb.wd.test;

import java.lang.reflect.Method;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import sb.wd.data.ExcelUtils;
import sb.wd.page.BaseTest;
import sb.wd.page.HomePage;
import sb.wd.page.LoginPage;
import sb.wd.page.MyAdsAndProfilePage;
import sb.wd.page.PostAnAdPage;
import sb.wd.page.SearchSectionPage;

public class CompleteFlowTestCase extends BaseTest{
	
	private HomePage homePage;
	private LoginPage loginPage;
	private PostAnAdPage postAnAdPage;
	private MyAdsAndProfilePage myAdsProfilePage;
	private SearchSectionPage searchPage;	
	
	@BeforeMethod	
	public void setUp(){
		settingsUp();
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.open(baseUrl);
	}

	@Test(dataProvider = "Authentication")
	public void testCompleteFlow(String userName, String password){		
		
		loginPage = homePage.goLogin();
		homePage = loginPage.login(userName, password);
		mAssert.assertTrue(homePage.isTextPresent("Welcome, SpiritBreakerTeam"));
		postAnAdPage = homePage.goPostAnAddPage();
		mAssert.assertTrue(postAnAdPage.isPostAnAdPage());
		homePage = postAnAdPage.goHome();
		myAdsProfilePage = homePage.goMyAdsProfilePage();
		mAssert.assertTrue(myAdsProfilePage.isMyAdsAndProfilePage());
		homePage = myAdsProfilePage.goHome();
		searchPage = homePage.goSearch("Nissan");
		searchPage.doSearch("Auto");
		mAssert.assertTrue(searchPage.isTextPresent("search term = \"Nissan\""));
		homePage = searchPage.goHome();
		homePage.doLogOut();
		mAssert.assertTrue(homePage.equals(homePage.loginLink));		
		
	}

	@AfterMethod
	public void tearDown(){
		settingsDown();	
	}		
  
	@DataProvider
	public Object[][] Authentication(Method testMethod){
		ExcelUtils read = new ExcelUtils();
		return read.getData("test.xlsx", testMethod.getName());
	}
  
}
