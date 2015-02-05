package framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import framework.common.SeleniumDriverManager;
import framework.pages.dashboard.DashboardPage;

/**
 * Form to sign in on JAT 
 * @author Eliana Navia
 *
 */
public class Login {
	WebDriver driver;
	@FindBy(xpath = "//input[@type='text']")
	WebElement userEmailTextBox;
	@FindBy(xpath = "//input[@type='password']")
	WebElement userPasswordTextBox;
	@FindBy(xpath = "//input[@value='Sign in']")
	WebElement signinBtn;

	/**
	 * Initialize the singleton to driver manipulation. 
	 */
	public Login(){
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
		driver.get("http://172.20.8.22:3001");
	}

	/**
	 * Set user email field in the "Sign in" form.
	 * @param email
	 */
	public void setUserEmail(String email){
		userEmailTextBox.sendKeys(email);
	}

	/**
	 * Set the password field  in the "sign in" form.
	 * @param password
	 */
	public void setUserPassword(String password){
		userPasswordTextBox.sendKeys(password);
	}
	/**
	 * Click in the "Sign in" button.
	 * @return DashboardPage
	 */
	public DashboardPage clickSigninBtn(){
		signinBtn.click();
		return new DashboardPage();
	}

	/**
	 * 
	 * @return user email text located in top right of the page.
	 */
	public String getLoginEmailText(){
		return userEmailTextBox.getText();
	}

	/**
	 * Login into JAT, displayed dashboard page.
	 * @param userEmail
	 * @param userPassword
	 * @return
	 */
	public DashboardPage loginIntoJAT(String userEmail, String userPassword){
		setUserEmail(userEmail);
		setUserPassword(userPassword);
		return clickSigninBtn();	
	}

	/**
	 * Close the browser.
	 */
	public void closeBrowser(){
		SeleniumDriverManager.getManager().quitDriver();
	}
}
