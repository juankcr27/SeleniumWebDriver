package sb.wd.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchSectionPage extends BasePage{

	@FindBy(id="ctl00_SecondBar_CommonSearchTextBox")
	private WebElement input;
	
	@FindBy(id="ctl00_SecondBar_CommonSearchButton")
	private WebElement btn;
	
	public SearchSectionPage(WebDriver driver){
		super(driver);
	}
	
	private SearchSectionPage  typeData(String data) {
		input.sendKeys(data);
		return this;
	}
	
	private AdvancedSearchPage submit() {
		btn.click();
		return PageFactory.initElements(driver, AdvancedSearchPage.class);
	}
	
	public AdvancedSearchPage search(String data) {
		this.typeData(data);		
		return this.submit(); 
	}
	
}
