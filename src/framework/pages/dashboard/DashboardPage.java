package framework.pages.dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import framework.common.SeleniumDriverManager;

/**
 * List of projects that belong to a user, a project could be add, update and delete.
 * @author Eliana Navia
 */
public class DashboardPage {
	WebDriver driver;
	@FindBy(xpath ="//div[2]/button")
	WebElement newProjectBtn;
	@FindBy(linkText = "Update") 
	WebElement updateProjectLink;
	@FindBy(linkText = "Delete") 
	WebElement deleteProjectLink;

	// Elements to delete a project
	@FindBy(id = "button-0")
	WebElement okBtn;

	//Find elements to verifications
	@FindBy(xpath ="//span[contains(@title, 'email')]")
	WebElement userEmailText;
	@FindBy(css ="div.title2")
	WebElement projectNameText;

	/**
	 * Initialize the driver and web elements. 
	 */
	public DashboardPage(){
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}

	/**
	 * Click on " + new project" button.
	 * @return
	 */
	public NewProjectForm clickNewProject(){
		newProjectBtn.click();
		return new NewProjectForm();
	}

	/**
	 * Click on "update" project link.
	 * @return
	 */
	public NewProjectForm clickUpdateProject(){
		updateProjectLink.click();
		return new NewProjectForm();
	}
	/**
	 * Click on "Delete" project link.
	 * @return
	 */
	public void clickDeleteLink(){
		deleteProjectLink.click();
	}

	/**
	 * Click OK button in confirmation message displayed to delete a project.
	 * @return Dashboard page
	 */
	public DashboardPage clickOkBtn(){
		okBtn.click();
		return this;
	}
	/**
	 * Delete the first project of projects list.
	 */
	public DashboardPage deleteProject(){
		clickDeleteLink();
		return clickOkBtn();
	}

	/**
	 * Return the text of user email displayed on the top right of the page.
	 * @return user email
	 */
	public String getLoginEmailText(){
		return userEmailText.getText();
	}

	/**
	 *
	 * @return project name of first project of the list.
	 */
	public String getProjectNameText(){
		return projectNameText.getText();
	}
}
