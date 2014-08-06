package sb.wd.test;

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
			
	private String sTestCaseName;
	private int iTestCaseRow;

	@BeforeMethod
	public void setUp() throws Exception {
		settingsUp();
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.open(baseUrl);
	}

	@Test(dataProvider = "Authentication")
	public void testNavigateFooterLinksTestCase(String userName, String password) throws Exception {
	    
		loginPage = homePage.goLogin();
		homePage = loginPage.login(userName, password);
		postAnAdPage = homePage.goFooterPostAnAddPage();
		m_assert.assertTrue(postAnAdPage.isPostAnAdPage());
		homePage = postAnAdPage.goFooterHome();
		m_assert.assertTrue(homePage.isHomePage());
		myAdsProfilePage = homePage.goFooterMyAdsProfilePage();
		m_assert.assertTrue(myAdsProfilePage.isMyAdsAndProfilePage());
		homePage = myAdsProfilePage.goFooterHome();
		m_assert.assertTrue(homePage.isHomePage());	
		m_assert.assertAll();
		
	}

	@AfterMethod
	public void tearDown() throws Exception {
		settingsDown();	
	}
  
	@DataProvider
	public Object[][] Authentication() throws Exception{
		// Setting up the Test Data Excel file
        ExcelUtils.setExcelFile("test.xlsx","Sheet1");
        sTestCaseName = this.toString();
        // From above method we get long test case name including package and class name etc.
        // The below method will refine your test case name, exactly the name use have used
        sTestCaseName = ExcelUtils.getTestCaseName(this.toString());
        // Fetching the Test Case row number from the Test Data Sheet
        // Getting the Test Case name to get the TestCase row from the Test Data Excel sheet
        iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);        
        Object[][] testObjArray = ExcelUtils.getTableArray("test.xlsx","Sheet1",iTestCaseRow);
        return (testObjArray);
	}
  
}
