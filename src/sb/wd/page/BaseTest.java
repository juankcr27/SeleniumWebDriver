package sb.wd.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

public class BaseTest {
	protected WebDriver driver;
	protected String baseUrl; 
	protected SoftAssert m_assert;
	
	public void settingsUp(){
		this.driver = new FirefoxDriver();
		this.baseUrl = "http://qatraining.avantica.avanticatec.net/QATestWeb/";
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.m_assert = new SoftAssert();
	}
	
	public void settingsDown(){
		this.driver.quit();		
	}
}
