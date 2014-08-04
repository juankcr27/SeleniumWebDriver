package sb.wd.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage {
	
	@FindBy(id="ctl00_Main_LoginConrol_UserName")
	public WebElement userName;
	
	@FindBy(id="ctl00_Main_LoginConrol_Password")
	public WebElement password;
	
	@FindBy(id="ctl00_Main_LoginConrol_LoginButton")
	public WebElement btn;

	public LoginPage(WebDriver driver){
		super(driver);
	}	
	
	private LoginPage  typeUser(String username) {
		userName.clear();
		userName.sendKeys(username);
		return this;
	}
	
	private LoginPage typePassword(String pass) {
		password.clear();
		password.sendKeys(pass);
		return this;
	}
	
	private HomePage submit() {
		btn.click();
		return PageFactory.initElements(driver, HomePage.class);
	}
	
	public HomePage login(String userName, String password) {
		this.typeUser(userName);
		this.typePassword(password);
		return this.submit(); 
	}

}
