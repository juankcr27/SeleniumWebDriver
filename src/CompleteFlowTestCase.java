import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CompleteFlowTestCase {
  private WebDriver driver;
  private String baseUrl;  
  private StringBuffer verificationErrors = new StringBuffer();
  private String bodyText;
  private boolean elementPresent;

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://qatraining.avantica.avanticatec.net/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCompleteFlowTestCase() throws Exception {
    driver.get(baseUrl + "/QATestWeb/");
    driver.findElement(By.id("ctl00_LoginView_LoginLink")).click();
    driver.findElement(By.id("ctl00_Main_LoginConrol_UserName")).clear();
    driver.findElement(By.id("ctl00_Main_LoginConrol_UserName")).sendKeys("SpiritBreakerTeam");
    driver.findElement(By.id("ctl00_Main_LoginConrol_Password")).clear();
    driver.findElement(By.id("ctl00_Main_LoginConrol_Password")).sendKeys("#spirit123");
    driver.findElement(By.id("ctl00_Main_LoginConrol_LoginButton")).click();
    driver.findElement(By.cssSelector("span")).click();
    bodyText = driver.findElement(By.tagName("body")).getText();
    assertTrue(bodyText.contains("Welcome, SpiritBreakerTeam"));    
    driver.findElement(By.id("ctl00_Main_CategoryBrowser_TopCategoryList_ctl02_TopCategoryButton")).click();
    driver.findElement(By.id("ctl00_Main_SearchTermTextBox")).clear();
    driver.findElement(By.id("ctl00_Main_SearchTermTextBox")).sendKeys("Nissan");    
    new Select(driver.findElement(By.id("ctl00_Main_CategoryDropDown_CategoryList"))).selectByVisibleText("Auto");
    driver.findElement(By.id("ctl00_Main_SearchButton")).click();
    bodyText = driver.findElement(By.tagName("body")).getText();
    assertTrue(bodyText.contains("search term = \"Nissan\""));    
    driver.findElement(By.cssSelector("#ctl00_TopMenuRepeater_ctl01_MenuLink > span")).click();
    driver.findElement(By.id("ctl00_Main_PostAdWizard_SubcategoriesList_ctl06_CategoryButton")).click();
    bodyText = driver.findElement(By.tagName("body")).getText();
    assertTrue(bodyText.contains("Post an Ad: Details"));    
    driver.findElement(By.cssSelector("#ctl00_TopMenuRepeater_ctl02_MenuLink > span")).click();
    driver.findElement(By.id("ctl00_Main_CommonSearchTextBox")).clear();
    driver.findElement(By.id("ctl00_Main_CommonSearchTextBox")).sendKeys("Rock");
    new Select(driver.findElement(By.id("ctl00_Main_CommonCategoryDropDown_CategoryList"))).selectByVisibleText("Music");
    driver.findElement(By.id("ctl00_Main_SearchButton")).click();
    bodyText = driver.findElement(By.tagName("body")).getText();
    assertTrue(bodyText.contains("search term = \"Rock\""));    
    driver.findElement(By.id("ctl00_LoginView_MemberLoginStatus")).click();
    elementPresent = driver.findElement(By.id("ctl00_LoginView_LoginLink")).isDisplayed();
    assertTrue(elementPresent);
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
  
}
