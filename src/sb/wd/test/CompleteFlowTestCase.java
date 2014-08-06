package sb.wd.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import sb.wd.data.ExcelUtils;
import sb.wd.page.BaseTest;
import sb.wd.page.HomePage;

public class CompleteFlowTestCase extends BaseTest{
	
	private HomePage homePage;
	
	private String bodyText;
	private boolean elementPresent;
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
		//driver.get(baseUrl + "/QATestWeb/");
		driver.findElement(By.id("ctl00_LoginView_LoginLink")).click();
		driver.findElement(By.id("ctl00_Main_LoginConrol_UserName")).clear();
		driver.findElement(By.id("ctl00_Main_LoginConrol_UserName")).sendKeys(userName);
		driver.findElement(By.id("ctl00_Main_LoginConrol_Password")).clear();
		driver.findElement(By.id("ctl00_Main_LoginConrol_Password")).sendKeys(password);
		driver.findElement(By.id("ctl00_Main_LoginConrol_LoginButton")).click();
		driver.findElement(By.cssSelector("span")).click();
		bodyText = driver.findElement(By.tagName("body")).getText();
		m_assert.assertTrue(bodyText.contains("Welcome, SpiritBreakerTeam"));    
		driver.findElement(By.id("ctl00_Main_CategoryBrowser_TopCategoryList_ctl02_TopCategoryButton")).click();
		driver.findElement(By.id("ctl00_Main_SearchTermTextBox")).clear();
		driver.findElement(By.id("ctl00_Main_SearchTermTextBox")).sendKeys("Nissan");    
		new Select(driver.findElement(By.id("ctl00_Main_CategoryDropDown_CategoryList"))).selectByVisibleText("Auto");
		driver.findElement(By.id("ctl00_Main_SearchButton")).click();
		bodyText = driver.findElement(By.tagName("body")).getText();
		m_assert.assertTrue(bodyText.contains("search term = \"Nissan\""));    
		driver.findElement(By.cssSelector("#ctl00_TopMenuRepeater_ctl01_MenuLink > span")).click();
		driver.findElement(By.id("ctl00_Main_PostAdWizard_SubcategoriesList_ctl06_CategoryButton")).click();
		bodyText = driver.findElement(By.tagName("body")).getText();
		m_assert.assertTrue(bodyText.contains("Post an Ad: Details"));    
		driver.findElement(By.cssSelector("#ctl00_TopMenuRepeater_ctl02_MenuLink > span")).click();
		driver.findElement(By.id("ctl00_Main_CommonSearchTextBox")).clear();
		driver.findElement(By.id("ctl00_Main_CommonSearchTextBox")).sendKeys("Rock");
		new Select(driver.findElement(By.id("ctl00_Main_CommonCategoryDropDown_CategoryList"))).selectByVisibleText("Music");
		driver.findElement(By.id("ctl00_Main_SearchButton")).click();
		bodyText = driver.findElement(By.tagName("body")).getText();
		m_assert.assertTrue(bodyText.contains("search term = \"Rock\""));    
		driver.findElement(By.id("ctl00_LoginView_MemberLoginStatus")).click();
		elementPresent = driver.findElement(By.id("ctl00_LoginView_LoginLink")).isDisplayed();
		m_assert.assertTrue(elementPresent);
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
