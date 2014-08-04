package sb.wd.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WhatsNewSelectingTestCase {
	private WebDriver driver;
	private String baseUrl;  
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeMethod
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://qatraining.avantica.avanticatec.net/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testWhatsNewSelectingTestCase() throws Exception {
		driver.get(baseUrl + "/QATestWeb/");
		new Select(driver.findElement(By.id("ctl00_SecondBar_CommonWhatsNewRangeList"))).selectByVisibleText("in the last 48 hours");
		driver.findElement(By.id("ctl00_SecondBar_CommonWhatsNewButton")).click();
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
