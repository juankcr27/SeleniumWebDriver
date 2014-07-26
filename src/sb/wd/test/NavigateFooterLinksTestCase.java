package sb.wd.test;

import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import sb.wd.data.ExcelUtils;

public class NavigateFooterLinksTestCase {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	private String bodyText;
	private boolean elementPresent;
	private String sTestCaseName;
	private int iTestCaseRow;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://qatraining.avantica.avanticatec.net/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(dataProvider = "Authentication")
	public void testNavigateFooterLinksTestCase(String userName, String password) throws Exception {
	    driver.get(baseUrl + "/QATestWeb/");
	    driver.findElement(By.id("ctl00_LoginView_LoginLink")).click();
	    driver.findElement(By.id("ctl00_Main_LoginConrol_UserName")).clear();
	    driver.findElement(By.id("ctl00_Main_LoginConrol_UserName")).sendKeys(userName);
	    driver.findElement(By.id("ctl00_Main_LoginConrol_Password")).clear();
	    driver.findElement(By.id("ctl00_Main_LoginConrol_Password")).sendKeys(password);
	    driver.findElement(By.id("ctl00_Main_LoginConrol_LoginButton")).click();
	    driver.findElement(By.cssSelector("#ctl00_FooterMenun1 > table > tbody > tr > td > a.ctl00_FooterMenu_1")).click();    
	    bodyText = driver.findElement(By.tagName("body")).getText();
	    assertTrue(bodyText.contains("Post an Ad: Category Selection"));
	    driver.findElement(By.cssSelector("a.ctl00_FooterMenu_1")).click();
	    elementPresent = driver.findElement(By.id("ctl00_SecondBar_CommonSearchTextBox")).isDisplayed();
	    assertTrue(elementPresent);
	    driver.findElement(By.cssSelector("#ctl00_FooterMenun2 > table > tbody > tr > td > a.ctl00_FooterMenu_1")).click();
	    bodyText = driver.findElement(By.tagName("body")).getText();
	    assertTrue(bodyText.contains("My Current Ads"));    
	    driver.findElement(By.cssSelector("a.ctl00_FooterMenu_1")).click();
	    elementPresent = driver.findElement(By.id("ctl00_SecondBar_CommonSearchTextBox")).isDisplayed();
	    assertTrue(elementPresent);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}
  
	@DataProvider
	public Object[][] Authentication() throws Exception{
        // Setting up the Test Data Excel file
        ExcelUtils.setExcelFile("C://Users//JuanCarlos//Documents//GitHub//SeleniumWebDriver//test.xlsx","Hoja1");
        sTestCaseName = this.toString();
        // From above method we get long test case name including package and class name etc.
        // The below method will refine your test case name, exactly the name use have used
        sTestCaseName = ExcelUtils.getTestCaseName(this.toString());
        // Fetching the Test Case row number from the Test Data Sheet
        // Getting the Test Case name to get the TestCase row from the Test Data Excel sheet
        iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);
        Object[][] testObjArray = ExcelUtils.getTableArray("C://Users//JuanCarlos//Documents//GitHub//SeleniumWebDriver//test.xlsx","Hoja1",iTestCaseRow);
        return (testObjArray);
	}
  
}
