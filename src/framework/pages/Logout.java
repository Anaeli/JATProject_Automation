package framework.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.common.SeleniumDriverManager;

/**
 * Logout of JAT
 * @author Eliana Navia
 * @Version 1.0     18 Feb 2015
 */
public class Logout {
	WebDriver driver;
	@FindBy(xpath = "//div/span")
	WebElement dropdownBtn;
	@FindBy(linkText = "Logout")
	WebElement logoutLink;

	/**
	 * Initialize the driver and web elements. 
	 * @throws Exception 
	 */
	public Logout() throws Exception{
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}

	/**
	 * Expand the drop down located in top right of the page under user email text.
	 */
	public void clickLogoutDropdownBtn(){
		try{
		dropdownBtn.click();
		}catch (NoSuchElementException e) {
			System.out.println("Dropdow logout button has not been found." + e.getMessage());
			throw new NoSuchElementException(e.getMessage());
		}catch (WebDriverException e) {
			System.out.println("Dropdow logout button is not clickable." + e.getMessage());
			throw new NoSuchElementException(e.getMessage());
		}
	}

	/**
	 * Click on logout link expanded under user email text. 
	 */
	public void clickLogoutLink(){
		try{
		logoutLink.click();
		}catch (NoSuchElementException e) {
			System.out.println("Logout link has not been found." + e.getMessage());
			throw new NoSuchElementException(e.getMessage());
		}   
	}

	/**
	 * Perform logout of the application.
	 * @return
	 * @throws Exception 
	 */
	public Login logout() throws Exception{
		clickLogoutDropdownBtn();
		clickLogoutLink();
		return new Login();
	}
}
