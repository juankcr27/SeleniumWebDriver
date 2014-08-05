package sb.wd.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAdsAndProfilePage extends BasePage {
	
	@FindBy(id="ctl00_TopMenuRepeater_ctl00_MenuLink")
	private WebElement homeLink;

	@FindBy(xpath="(//a[@class='ctl00_FooterMenu_1'])[1]")
	private WebElement homeFooterLink;
	
	public MyAdsAndProfilePage(WebDriver driver){
		super(driver);
	}	
	
	public HomePage goHome() {
		homeLink.click();
		return PageFactory.initElements(driver, HomePage.class);
	}
	
	public HomePage goFooterHome() {
		homeFooterLink.click();
		return PageFactory.initElements(driver, HomePage.class);
	}
	
	public boolean isMyAdsAndProfilePage(){
		if(driver.getTitle().equals("My Ads")){
			return true;
		}else{
			return false;
		}
	}
}
