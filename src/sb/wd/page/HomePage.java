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
	
	/**
	 * Tabs Section 
	 */	
	@FindBy(id="ctl00_TopMenuRepeater_ctl01_MenuLink")
	private WebElement postAnAdLink;
	
	@FindBy(id="ctl00_TopMenuRepeater_ctl02_MenuLink")
	private WebElement myAdsProfileLink;
	
	/**
	 * Footers Section 
	 */	
	@FindBy(xpath="(//a[@class='ctl00_FooterMenu_1'])[2]")
	private WebElement postAnAdFooterLink;
	
	@FindBy(xpath="(//a[@class='ctl00_FooterMenu_1'])[3]")
	private WebElement myAdsProfileFooterLink;
	
	/**
	 * Avantica Copyright Section 
	 */	
	@FindBy(id="ctl00_Avantica")
	private WebElement avanticaLink;
	
	/**
	 * Browse All Categories Section 
	 */	
	@FindBy(id="ctl00_BrowseAllLink")
	private WebElement allCategoriesLink;
	
	/**
	 * Logout Section 
	 */	
	@FindBy(id="ctl00_LoginView_MemberLoginStatus")
	private WebElement logoutLink;
	
	/** * * * * * * * * * * * * * * * * */
	
	public HomePage(WebDriver driver){
		super(driver);
	}
	
	public boolean isHomePage(){
		if(driver.getTitle().equals("Welcome")){
			return true;
		}else{
			return false;
		}
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
	
	/**
	 * Tabs Section 
	 */
	public PostAnAdPage goPostAnAddPage() {
		postAnAdLink.click();
		return PageFactory.initElements(driver, PostAnAdPage.class);
	}
	
	public MyAdsAndProfilePage goMyAdsProfilePage() {
		myAdsProfileLink.click();
		return PageFactory.initElements(driver, MyAdsAndProfilePage.class);
	}
	
	/**
	 * Footers Section 
	 */	
	public PostAnAdPage goFooterPostAnAddPage() {
		postAnAdFooterLink.click();
		return PageFactory.initElements(driver, PostAnAdPage.class);
	}
	
	public MyAdsAndProfilePage goFooterMyAdsProfilePage() {
		myAdsProfileFooterLink.click();
		return PageFactory.initElements(driver, MyAdsAndProfilePage.class);
	}
	
	/**
	 * Avantica Copyright Section 
	 */	
	public AvanticaPage goAvanticaPage() {
				
		avanticaLink.click();
		
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle
		}
		
		return PageFactory.initElements(driver, AvanticaPage.class);
	}
	
	/**
	 * Browse All Categories Section 
	 */		
	public SearchSectionPage goAllCategoriesPage() {
		allCategoriesLink.click();
		return PageFactory.initElements(driver, SearchSectionPage.class);
	}
	
	/**
	 * Logout Section 
	 */	
	public HomePage doLogOut() {
		logoutLink.click();
		return PageFactory.initElements(driver, HomePage.class);
	}
		
}
