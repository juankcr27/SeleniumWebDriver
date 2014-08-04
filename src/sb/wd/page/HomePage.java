package sb.wd.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	@FindBy(id="ctl00_SecondBar_CommonSearchTextBox")
	private WebElement searchInput;
	
	@FindBy(id="ctl00_SecondBar_CommonSearchButton")
	private WebElement searchBtn;
	
	public HomePage(WebDriver driver){
		super(driver);
	}
	
	private HomePage typeData(String data) {
		searchInput.clear();
		searchInput.sendKeys(data);
		return this;
	}
	
	private SearchSectionPage searchSubmit() {
		searchBtn.click();
		return PageFactory.initElements(driver, SearchSectionPage.class);
	}
	
	public SearchSectionPage goSearch(String data) {
		this.typeData(data);		
		return this.searchSubmit(); 
	}
}
