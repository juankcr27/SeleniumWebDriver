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

public class NavigateFooterLinksTest extends BaseTest{
	
	private HomePage homePage;
	private LoginPage loginPage;
	private PostAnAdPage postAnAdPage;
	private MyAdsAndProfilePage myAdsProfilePage;
	
	@BeforeMethod
	public void setUp() throws Exception {
		settingsUp();
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.open(baseUrl);
	}

	@Test(dataProvider = "Authentication")
	public void testNavigateFooterLinks(String userName, String password) throws Exception {
	    
		loginPage = homePage.goLogin();
		homePage = loginPage.login(userName, password);
		postAnAdPage = homePage.goFooterPostAnAddPage();
		mAssert.assertTrue(postAnAdPage.isPostAnAdPage());
		homePage = postAnAdPage.goFooterHome();
		mAssert.assertTrue(homePage.isHomePage());
		myAdsProfilePage = homePage.goFooterMyAdsProfilePage();
		mAssert.assertTrue(myAdsProfilePage.isMyAdsAndProfilePage());
		homePage = myAdsProfilePage.goFooterHome();
		mAssert.assertTrue(homePage.isHomePage());	
		mAssert.assertAll();
		
	}

	@AfterMethod
	public void tearDown() throws Exception {
		settingsDown();	
	}
  
	@DataProvider
	public Object[][] Authentication(Method testMethod) throws Exception{
		ExcelUtils read = new ExcelUtils();
		return read.getData("test.xlsx", testMethod.getName());
	}
  
}
