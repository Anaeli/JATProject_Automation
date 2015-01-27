package framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import framework.common.SeleniumDriverManager;
import framework.pages.project.DashboardPage;

public class Login {
	public WebDriver driver;
	@FindBy(xpath = "//input[@type='text']")
	WebElement userEmail;
	@FindBy(xpath = "//input[@type='password']")
	WebElement userPassword;
	@FindBy(xpath = "//input[@value='Sign in']")
	WebElement login;
	
	public Login(){
		this.driver = SeleniumDriverManager.getManager().getDriver();
        //This initElements method will create all WebElements
         PageFactory.initElements(driver, this);
         driver.get("http://172.20.8.22:3001");
     }

	public void setUserEmail(String email){
		 userEmail.sendKeys(email);
	}
	
	public void setUserPassword(String password){
		userPassword.sendKeys(password);
	}
	
	public void clickLogin(){
		login.click();
	}
	public String getLoginEmail(){
		return userEmail.getText();
	}
	
	public DashboardPage loginIntoJAT(String userEmail, String userPassword){
	    setUserEmail(userEmail);
	    setUserPassword(userPassword);
	    clickLogin();
	    return new DashboardPage();
	}
	
	public void closeBrowser(){
		SeleniumDriverManager.getManager().quitDriver();
	}
}
