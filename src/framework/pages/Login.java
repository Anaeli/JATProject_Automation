package framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

import framework.common.SeleniumDriverManager;
import framework.pages.dashboard.DashboardPage;
import framework.util.ReadJSONFile;

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
	ReadJSONFile objReadJSONFile = new ReadJSONFile();
		
	/**
	 * Initialize the singleton to driver manipulation. 
	 */
	@Parameters({"url"})
	public Login(){
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
		//String node = "URL"; 
		//String url = xmlFile.read(node, "url");  
		String url = objReadJSONFile.readJSON("url");
		//String url = PropertyLoader.loadProperty("url");
		driver.get(url);
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
