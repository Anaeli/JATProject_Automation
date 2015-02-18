package framework.pages.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.common.SeleniumDriverManager;

/**
 * Form to add, delete and update a user story.
 * @author Eliana Navia
 * @Version 1.0     18 Feb 2015
 */
public class UserStoryForm {
	WebDriver driver;
	@FindBy(id = "us-title")
	WebElement userStoryTitleTextBox;
	@FindBy(id = "createUS")
	WebElement createUSBtn;

	/**
	 * Initialize the web elements.
	 */
	public UserStoryForm(){
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}

	/**
	 * Set use story title in "User Story" text box.
	 * @param userStoryTitle
	 */
	public void setUserStoryTitleTextBox(String userStoryTitle){
		userStoryTitleTextBox.clear();
		userStoryTitleTextBox.sendKeys(userStoryTitle);
	}

	/**
	 * Click in "Create" button, collapsed the form.
	 * @return
	 */
	public ProjectPage clickCreateUserStoryBtn(){
		createUSBtn.click();
		return new ProjectPage();
	}

	/**
	 * Create a US in Icebox pane where only the title is obligatory.
	 * @param userStoryTitle
	 * @return
	 */
	public ProjectPage addNewUserStory(String userStoryTitle){
		setUserStoryTitleTextBox(userStoryTitle);
		return clickCreateUserStoryBtn();
	}
}
