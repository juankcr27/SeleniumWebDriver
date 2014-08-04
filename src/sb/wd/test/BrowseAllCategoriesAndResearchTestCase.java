package sb.wd.test;

import static org.testng.AssertJUnit.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowseAllCategoriesAndResearchTestCase {
	private WebDriver driver;
	private String baseUrl;  
	private StringBuffer verificationErrors = new StringBuffer();
	private String bodyText;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://qatraining.avantica.avanticatec.net/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testBrowseAllCategoriesAndResearchTestCase() throws Exception {
		driver.get(baseUrl + "/QATestWeb/");
		driver.findElement(By.id("ctl00_BrowseAllLink")).click();
		driver.findElement(By.id("ctl00_Main_SearchTermTextBox")).clear();
		driver.findElement(By.id("ctl00_Main_SearchTermTextBox")).sendKeys("Rock");
		new Select(driver.findElement(By.id("ctl00_Main_CategoryDropDown_CategoryList"))).selectByVisibleText("Music");
		driver.findElement(By.id("ctl00_Main_SearchButton")).click();
		bodyText = driver.findElement(By.tagName("body")).getText();
		assertTrue(bodyText.contains("search term = \"Rock\""));    
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}
  
}
