import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoToAvanticaPageCopyrightTestCase {
  private WebDriver driver;
  private String baseUrl;  
  private StringBuffer verificationErrors = new StringBuffer();
  private String parentHandle;

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://qatraining.avantica.avanticatec.net/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testGoToAvanticaPageCopyrightTestCase() throws Exception {
    driver.get(baseUrl + "/QATestWeb/");    
    parentHandle = driver.getWindowHandle(); // get the current window handle
    driver.findElement(By.xpath("//*[@id='ctl00_Avantica']")).click(); // click some link that opens a new window

    for (String winHandle : driver.getWindowHandles()) {
        driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle
    }
    
    assertEquals("Avantica - Avantica Technologies", driver.getTitle());
    driver.close(); // close newly opened window when done with it
    driver.switchTo().window(parentHandle); 
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
