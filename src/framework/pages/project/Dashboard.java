package framework.pages.project;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import framework.common.SeleniumDriverManager;


public class Dashboard<Project> {
	public WebDriver driver;
	//ListProject
	public ArrayList<Project> listProject; 
	//To verify if the user is logged
	@FindBy(how = How.XPATH, using ="//span[contains(@title, 'email')]")
	WebElement userEmail;
	
	public Dashboard(){
		this.driver = SeleniumDriverManager.getManager().getDriver();
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
	}
	
	public String getLoginEmail(){
		return userEmail.getText();
	}
	
}
