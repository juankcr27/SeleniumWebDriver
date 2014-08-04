package sb.wd.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

	/**
	 * Search Section
	 */
	@FindBy(id="ctl00_SecondBar_CommonSearchTextBox")
	private WebElement searchInput;
	
	@FindBy(id="ctl00_SecondBar_CommonSearchButton")
	private WebElement searchBtn;
	
	/**
	 * What's New Section 
	 */
	@FindBy(id="ctl00_SecondBar_CommonWhatsNewRangeList")
	private WebElement whatsNewSelect;
	
	@FindBy(id="ctl00_SecondBar_CommonWhatsNewButton")
	private WebElement whatsNewBtn;
		
	/**
	 * All Categories Section 
	 */		
	@FindBy(id="ctl00_Main_CategoryBrowser_TopCategoryList_ctl00_TopCategoryButton")
	public WebElement antAndCollectCategLink;
	
	@FindBy(id="ctl00_Main_CategoryBrowser_TopCategoryList_ctl04_TopCategoryButton")
	public WebElement gardenCategLink;
	
	@FindBy(id="ctl00_Main_CategoryBrowser_TopCategoryList_ctl01_TopCategoryButton")
	public WebElement artAndCraftsCategLink;
	
	@FindBy(id="ctl00_Main_CategoryBrowser_TopCategoryList_ctl01_NestedSubCategoryRepeater_ctl01_SubCategoryButton")
	public WebElement personalCategLink;
	
	@FindBy(id="ctl00_Main_CategoryBrowser_TopCategoryList_ctl05_TopCategoryButton")
	public WebElement homeCategLink;
	
	@FindBy(id="ctl00_Main_CategoryBrowser_TopCategoryList_ctl02_TopCategoryButton")
	public WebElement autoCategLink;
	
	@FindBy(id="ctl00_Main_CategoryBrowser_TopCategoryList_ctl06_TopCategoryButton")
	public WebElement musicCategLink;
	
	@FindBy(id="ctl00_Main_CategoryBrowser_TopCategoryList_ctl03_TopCategoryButton")
	public WebElement electCategLink;
		
	/**
	 * Login Section 
	 */	
	@FindBy(id="ctl00_LoginView_LoginLink")
	public WebElement loginLink;
	
	
	/** * * * * * * * * * * * * * * * * */
	
	public HomePage(WebDriver driver){
		super(driver);
	}
	
	/**
	 * Search Section
	 */
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
	

	/**
	 * What's New Section 
	 */	
	private HomePage selectData(String data) {
		new Select(whatsNewSelect).selectByVisibleText(data);
		return this;
	}

	private SearchSectionPage whatsNewSubmit() {
		whatsNewBtn.click();
		return PageFactory.initElements(driver, SearchSectionPage.class);
	}
	
	public SearchSectionPage goWhatsNew(String data) {
		this.selectData(data);		
		return this.whatsNewSubmit(); 
	}
	
	/**
	 * All Categories Section  
	 */	
	public SearchSectionPage goCategory(WebElement element) {
		element.click();
		return PageFactory.initElements(driver, SearchSectionPage.class);
	}
	
	/**
	 * Login Section 
	 */	
	public LoginPage goLogin() {
		loginLink.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}
		
}
