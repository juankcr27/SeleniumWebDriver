package sb.wd.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sb.wd.page.AvanticaPage;
import sb.wd.page.BaseTest;
import sb.wd.page.HomePage;

public class GoToAvanticaPageCopyrightTest extends BaseTest{		
	
	private HomePage homePage;
	private AvanticaPage avanticaPage;
	
	
	@BeforeMethod
	public void setUp(){
		settingsUp();
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.open(baseUrl);
	}

	@Test
	public void testGoToAvanticaPageCopyrightTestCase(){
		
		avanticaPage = homePage.goAvanticaPage();
		mAssert.assertTrue(avanticaPage.isAvanticaPage());
		mAssert.assertAll();
		
	}

	@AfterMethod
	public void tearDown(){
		settingsDown();	
	}
  
}
