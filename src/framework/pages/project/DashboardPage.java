package framework.pages.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import framework.common.SeleniumDriverManager;

/**
 * 
 * @author Eliana Navia
 *
 * @param <Project>
 */
public class DashboardPage {
	WebDriver driver;
	//ListProject 	ArrayList<Project> listProject; 
	@FindBy(xpath ="//div[2]/button")
	WebElement newProjectBtn;
	@FindBy(linkText = "Update") 
	WebElement updateLink;
	@FindBy(linkText = "Delete") 
	WebElement deleteLink;
	@FindBy(id = "button-0")
	WebElement okBtn;
	//Find elements to verifications
	@FindBy(xpath ="//span[contains(@title, 'email')]")
	WebElement userEmail;
	@FindBy(css ="div.title2")
	WebElement projectName;
	
	public DashboardPage(){
		this.driver = SeleniumDriverManager.getManager().getDriver();
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	public NewProjectPage clickNewProject(){
		newProjectBtn.click();
		return new NewProjectPage();
	}

	public NewProjectPage clickUpdateProject(){
		updateLink.click();
		return new NewProjectPage();
	}
	public void clickDeleteLink(){
		deleteLink.click();
	}
	public void clickOkBtn(){
		okBtn.getTagName();
		okBtn.click();
	}
	/**
	 * 
	 * @param pName
	 * @param id
	 */
	public void deleteProject(){
		//xpath= "(//a[contains(text(), 'Delete')])[7])"
		clickDeleteLink();
		clickOkBtn();
	}
	public String getLoginEmailText(){
		return userEmail.getText();
	}
	public String getProjectNameText(){
		return projectName.getText();
	}
}
