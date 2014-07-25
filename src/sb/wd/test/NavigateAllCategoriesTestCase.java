package sb.wd.test;
import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NavigateAllCategoriesTestCase {
	 private WebDriver driver;
	 private String baseUrl;	
	 private StringBuffer verificationErrors = new StringBuffer();
	 private String selectedOption;
	
	 @BeforeMethod
	public void setUp() throws Exception {
		 driver = new FirefoxDriver();
		 baseUrl = "http://qatraining.avantica.avanticatec.net/";
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 }
	
	@Test
	public void testNavigateAllCategoriesTestCase() throws Exception {
	    driver.get(baseUrl + "/QATestWeb/");
	
	    driver.findElement(By.id("ctl00_Main_CategoryBrowser_TopCategoryList_ctl00_TopCategoryButton")).click();
	    selectedOption = new Select(driver.findElement(By.id("ctl00_Main_CategoryDropDown_CategoryList"))).getFirstSelectedOption().getText();
		assertEquals("Antiques & Collectibles", selectedOption);
		driver.navigate().back();
		
		driver.findElement(By.id("ctl00_Main_CategoryBrowser_TopCategoryList_ctl04_TopCategoryButton")).click();
		selectedOption = new Select(driver.findElement(By.id("ctl00_Main_CategoryDropDown_CategoryList"))).getFirstSelectedOption().getText();
		assertEquals("Garden", selectedOption);
		driver.navigate().back();
		
		driver.findElement(By.id("ctl00_Main_CategoryBrowser_TopCategoryList_ctl01_TopCategoryButton")).click();
		selectedOption = new Select(driver.findElement(By.id("ctl00_Main_CategoryDropDown_CategoryList"))).getFirstSelectedOption().getText();
		assertEquals("Arts & Crafts", selectedOption);
		driver.navigate().back();
		
		driver.findElement(By.id("ctl00_Main_CategoryBrowser_TopCategoryList_ctl01_NestedSubCategoryRepeater_ctl01_SubCategoryButton")).click();
		selectedOption = new Select(driver.findElement(By.id("ctl00_Main_CategoryDropDown_CategoryList"))).getFirstSelectedOption().getText();
		assertEquals("-- Personal", selectedOption);
		driver.navigate().back();
		
		driver.findElement(By.id("ctl00_Main_CategoryBrowser_TopCategoryList_ctl05_TopCategoryButton")).click();
		selectedOption = new Select(driver.findElement(By.id("ctl00_Main_CategoryDropDown_CategoryList"))).getFirstSelectedOption().getText();
		assertEquals("Home", selectedOption);
		driver.navigate().back();
		
		driver.findElement(By.id("ctl00_Main_CategoryBrowser_TopCategoryList_ctl02_TopCategoryButton")).click();
		selectedOption = new Select(driver.findElement(By.id("ctl00_Main_CategoryDropDown_CategoryList"))).getFirstSelectedOption().getText();
		assertEquals("Auto", selectedOption);
		driver.navigate().back();
		
		driver.findElement(By.id("ctl00_Main_CategoryBrowser_TopCategoryList_ctl06_TopCategoryButton")).click();
		selectedOption = new Select(driver.findElement(By.id("ctl00_Main_CategoryDropDown_CategoryList"))).getFirstSelectedOption().getText();
		assertEquals("Music", selectedOption);
		driver.navigate().back();
		
		driver.findElement(By.id("ctl00_Main_CategoryBrowser_TopCategoryList_ctl03_TopCategoryButton")).click();
		selectedOption = new Select(driver.findElement(By.id("ctl00_Main_CategoryDropDown_CategoryList"))).getFirstSelectedOption().getText();
		assertEquals("Electronics", selectedOption);
	    driver.navigate().back();
	    
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
