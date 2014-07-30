package sb.wd.page;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	protected String URL;	
	
	/** Constructor */
	public BasePage(WebDriver driver) {
		this.driver = driver; 
	}

	/** 
     * Check if page is loaded by comparing 
     * the expected page-title with an actual page-title. 
     **/ 
    public boolean isPageLoad(String title){
    	return (driver.getTitle().contains(title)); 
    }
	
    /** Open the default page */ 
    public BasePage open(String url) {
    	this.setURL(url);
		driver.get(URL);
		return this;
	} 
    
    /** Returns the default URL */ 
    public String getURL() {
    	return URL;
    }
    	
    /** Is the text present in page. */ 
    public boolean isTextPresent(String text){
    	return driver.getPageSource().contains(text); 
    }
    
    /** Is the Element in page. */
    public boolean isElementPresent(WebElement elem) {
       try {
    	   elem.isDisplayed(); 
    	   return true;
       } catch (NoSuchElementException e) {
    	   return false;
       }
    }
    
    /** Get the current title. */ 
    public String getTitle() {
		return driver.getTitle();
	}
    
    /** Set the URL to testing. */ 
    public BasePage setURL(String url) {
		  this.URL = url;
		  return this;
	}
    
    /** 
     * Wait for an element until  be visible 
     * @param element - Web element to wait.
     * @param TIME_WAIT - maximum time to wait, seconds.
     **/ 
    public BasePage waitElement(WebElement element, int TIME_WAIT){
    	WebDriverWait wait = new WebDriverWait(driver, TIME_WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
        return this;
    }
    /**
     * Gets the current browser URL
     * @return String the current URL
     */
    public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

    /**
     * Verifies if a page is properly displayed
     * @param isLogged true if the page is verified with a logged in user, 
     * false otherwise
     * @return true if the page is displayed properly, false otherwise
     */
	public boolean isPageDisplayed(boolean isLogged) {
		System.out.println("isPageDisplayed-isLogged on PageBase");
		return false;
	}
	
	public boolean isPageDisplayed(int userType) {
		System.out.println("isPageDisplayed-userType on PageBase");
		return false;
	}
	
	public boolean isPageDisplayed() {
		System.out.println("isPageDisplayed on PageBase");
		return false;
	}

	public BasePage goToHomePage() {
		driver.navigate().to(getURL());
		return this;
	}
	
	public BasePage goToBack() {
		driver.navigate().back();
		return this;
	}
	
	public boolean isLogged() {	
		//method to verify if is logged
		return true;
	}
	
	public BasePage clickLinkByPartilaName(String linkName) {
		driver.findElement(By.partialLinkText(linkName)).click();
		return this;
	}
}
	
