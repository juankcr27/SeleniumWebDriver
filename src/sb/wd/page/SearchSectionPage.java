package sb.wd.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class SearchSectionPage extends BasePage{

	@FindBy(id="ctl00_Main_SearchTermTextBox")
	private WebElement inputCateg;
	
	@FindBy(id="ctl00_Main_CategoryDropDown_CategoryList")
	private WebElement selectCateg;
	
	@FindBy(id="ctl00_Main_SearchButton")
	private WebElement doSearchBtn;		
	
	@FindBy(id="ctl00_TopMenuRepeater_ctl00_MenuLink")
	private WebElement goHomeLink;		
		
	public SearchSectionPage(WebDriver driver){
		super(driver);
	}
	
	private SearchSectionPage inputData(String data) {
		inputCateg.clear();
		inputCateg.sendKeys(data);
		return this;
	}
	
	private SearchSectionPage selectData(String data) {
		new Select(selectCateg).selectByVisibleText(data);
		return this;
	}

	private SearchSectionPage searchSubmit() {
		doSearchBtn.click();
		return PageFactory.initElements(driver, SearchSectionPage.class);
	}
	
	public SearchSectionPage doSearch(String data) {
		this.selectData(data);		
		return this.searchSubmit(); 
	}
	
	public HomePage goBackToHome(){
		driver.navigate().back();
		return PageFactory.initElements(driver, HomePage.class);
	}
	
	public HomePage goHome(){
		goHomeLink.click();
		return PageFactory.initElements(driver, HomePage.class);
	}	
	
	public boolean isSearchPage(){
		if(driver.getTitle().equals("Search")){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isSelectedOption(String option){
		String selectedOption = new Select(selectCateg).getFirstSelectedOption().getText();
		
		if(selectedOption.equals(option)){
			return true;
		}else{
			return false;
		}
		
	}
	
	public SearchSectionPage doInputSearch(String input, String select) {
		this.inputData(input);
		this.selectData(select);		
		return this.searchSubmit(); 
	}
	
	
}
