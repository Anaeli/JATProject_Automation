package framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import framework.common.SeleniumDriverManager;

/**
 * 
 * @author Eliana Navia
 *
 */
public class Logout {
	public WebDriver driver;
	@FindBy(xpath ="//div/span")
	WebElement dropdown;
	@FindBy(linkText = "Logout")
	WebElement logoutLink;

	    
	    
	public Logout(){
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}
	
    public void clickDropdown(){
    	dropdown.click();
    }
    public void clickLogout(){
    	logoutLink.click();
    }
    
    public void logout(){
    	clickDropdown();
    	clickLogout();
    }
}
