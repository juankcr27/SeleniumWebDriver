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
import sb.wd.page.SearchSectionPage;

public class CompleteFlowTestCase extends BaseTest{
	
	private HomePage homePage;
	private LoginPage loginPage;
	private PostAnAdPage postAnAdPage;
	private MyAdsAndProfilePage myAdsProfilePage;
	private SearchSectionPage searchPage;	
	
	private String sTestCaseName;
	private int iTestCaseRow;

	@BeforeMethod	
	public void setUp() throws Exception {
		settingsUp();
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.open(baseUrl);
	}

	@Test(dataProvider = "Authentication")
	public void testCompleteFlowTestCase(String userName, String password) throws Exception {		
		
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
