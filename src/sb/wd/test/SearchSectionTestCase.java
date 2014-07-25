package sb.wd.test;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchSectionTestCase {
  private WebDriver driver;
  private String baseUrl; 
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://qatraining.avantica.avanticatec.net/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSearchSectionTestCase() throws Exception {
    driver.get(baseUrl + "/QATestWeb/");
    driver.findElement(By.id("ctl00_SecondBar_CommonSearchTextBox")).clear();
    driver.findElement(By.id("ctl00_SecondBar_CommonSearchTextBox")).sendKeys("Arts");
    driver.findElement(By.id("ctl00_SecondBar_CommonSearchButton")).click();
    new Select(driver.findElement(By.id("ctl00_Main_CategoryDropDown_CategoryList"))).selectByVisibleText("Arts & Crafts");
    driver.findElement(By.id("ctl00_Main_SearchButton")).click();
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
