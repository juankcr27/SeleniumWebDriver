package sb.wd.page;

import org.openqa.selenium.WebDriver;

public class AvanticaPage extends BasePage {
	
	public AvanticaPage(WebDriver driver){
		super(driver);
	}
	
	public boolean isAvanticaPage(){
		if(driver.getTitle().equals("Avantica - Avantica Technologies")){
			return true;
		}else{
			return false;
		}
	}
}
