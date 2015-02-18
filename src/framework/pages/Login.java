package framework.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.common.SeleniumDriverManager;
import framework.pages.dashboard.DashboardPage;
import framework.util.ReadJSONFile;

/**
 * Form to sign in on JAT 
 * @author Eliana Navia
 * @Version 1.0     18 Feb 2015
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
	ReadJSONFile objPropertyLoader = new ReadJSONFile();

	/**
	 * Initialize the singleton to driver manipulation. 
	 */
	public Login(){
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
		String url = objPropertyLoader.readJSON("url");
		driver.get(url);
	}

	/**
	 * Set user email field in the "Sign in" form.
	 * @param email
	 */
	public void setUserEmailTextBox(String email){
		try{
		userEmailTextBox.sendKeys(email);
		}catch (NoSuchElementException e) {
			System.out.println("User email text box has not been found." + e.getMessage());
			throw new NoSuchElementException(e.getMessage());
		}catch (WebDriverException e) {
			System.out.println("User email text box is not clickable." + e.getMessage());
			throw new NoSuchElementException(e.getMessage());
		}
	}

	/**
	 * Set the password field  in the "sign in" form.
	 * @param password
	 */
	public void setUserPasswordTextBox(String password){
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
	 * Login into JAT, displayed dashboard page.
	 * @param userEmail
	 * @param userPassword
	 * @return
	 */
	public DashboardPage loginIntoJAT(String userEmail, String userPassword){
		setUserEmailTextBox(userEmail);
		setUserPasswordTextBox(userPassword);
		return clickSigninBtn();	
	}

	/**
	 * [ASSERTIONS]login in JAT
	 * @return user email text located in top right of the page.
	 */
	public String getLoginEmailText(){
		return userEmailTextBox.getText();
	}

	/**
	 * Close the browser.
	 */
	public void closeBrowser(){
		SeleniumDriverManager.getManager().quitDriver();
	}
}
