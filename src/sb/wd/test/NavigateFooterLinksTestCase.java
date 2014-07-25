package sb.wd.test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigateFooterLinksTestCase {
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
  public void testNavigateFooterLinksTestCase() throws Exception {
    driver.get(baseUrl + "/QATestWeb/");
    driver.findElement(By.id("ctl00_LoginView_LoginLink")).click();
    driver.findElement(By.id("ctl00_Main_LoginConrol_UserName")).clear();
    driver.findElement(By.id("ctl00_Main_LoginConrol_UserName")).sendKeys("SpiritBreakerTeam");
    driver.findElement(By.id("ctl00_Main_LoginConrol_Password")).clear();
    driver.findElement(By.id("ctl00_Main_LoginConrol_Password")).sendKeys("#spirit123");
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

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }  
}
