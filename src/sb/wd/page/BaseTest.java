package sb.wd.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	protected WebDriver driver;
	protected String baseUrl; 
	
	public void settingsUp(){
		this.driver = new FirefoxDriver();
		this.baseUrl = "http://qatraining.avantica.avanticatec.net/QATestWeb/";
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void settingsDown(){
		this.driver.quit();		
	}
}
