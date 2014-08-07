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

public class NavigateAllTabsTest extends BaseTest {
	
	private HomePage homePage;
	private LoginPage loginPage;
	private PostAnAdPage postAnAdPage;
	private MyAdsAndProfilePage myAdsProfilePage;
	
	@BeforeMethod
	public void setUp(){
		settingsUp();
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.open(baseUrl);
	}

	@Test(dataProvider = "Authentication")
	public void testNavigateAllTabs(String userName, String password){
	  		
		loginPage = homePage.goLogin();
		homePage = loginPage.login(userName, password);
		postAnAdPage = homePage.goPostAnAddPage();
		mAssert.assertTrue(postAnAdPage.isPostAnAdPage());
		homePage = postAnAdPage.goHome();
		mAssert.assertTrue(homePage.isHomePage());
		myAdsProfilePage = homePage.goMyAdsProfilePage();
		mAssert.assertTrue(myAdsProfilePage.isMyAdsAndProfilePage());
		homePage = myAdsProfilePage.goHome();
		mAssert.assertTrue(homePage.isHomePage());	
		mAssert.assertAll();
	}

	@AfterMethod
	public void tearDown(){
		settingsDown();		
	}
  
	@DataProvider
	public Object[][] Authentication(Method testMethod) throws Exception{
		ExcelUtils read = new ExcelUtils();
		return read.getData("test.xlsx", testMethod.getName());
	}
  
}
