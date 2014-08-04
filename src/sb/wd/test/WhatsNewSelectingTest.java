package sb.wd.test;

import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sb.wd.page.BaseTest;
import sb.wd.page.HomePage;
import sb.wd.page.SearchSectionPage;

public class WhatsNewSelectingTest extends BaseTest {
	
	private HomePage homePage;
	private SearchSectionPage searchPage;

	@BeforeMethod
	public void setUp() throws Exception {
		settingsUp();
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.open(baseUrl);
	}

	@Test
	public void testWhatsNewSelectingTestCase() throws Exception {
		searchPage = homePage.goWhatsNew("in the last 48 hours");				
		assertTrue(searchPage.isSearchPage());				
	}

	@AfterMethod
	public void tearDown() throws Exception {
		settingsDown();			
	}
  
}
