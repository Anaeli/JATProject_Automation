package framework.pages.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.common.SeleniumDriverManager;
import framework.pages.dashboard.DashboardPage;

/**
 * User story board related to a project.
 * @author Eliana Navia
 *
 */
public class ProjectPage {
	WebDriver driver;
	@FindBy(css ="div.project-name.ng-binding")
	WebElement nameProjectTextBox;
	@FindBy(linkText ="DashBoard")
	WebElement dashboardLink;

	//Expand the form to create a player
	@FindBy(css = "span.fa.fa-user")
	WebElement addUserIcon;

	//To add a user story
	@FindBy(id = "newUserStory_link")
	WebElement addUserStoryBtn;

	//To search US by title
	@FindBy(id = "word-search-uss")
	WebElement searchUserStoryTextBox;
	@FindBy(css = "button.btn.btn-default")
	WebElement searchIcon;

	//To verify the player name 
	@FindBy(xpath = "//div[2]/div[3]/div/div")
	WebElement playerNameText;

	//To verify user story title 
	@FindBy(xpath = "//div[@id='icebox']/div/div/div/div/div[3]")
	WebElement userStoryTitleText;

	//To verify user story title 
	@FindBy(xpath = "//div[8]/div/div/div[2]/div/div/div/div/div/div[3]")
	WebElement userStoryTitleSearch;
	/**
	 * Initialize the web elements.
	 */
	public ProjectPage(){
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}

	/**
	 * Expand the form to create a player.
	 * @return PlayerForm 
	 */
	public PlayerForm clickAddUserIcon(){
		addUserIcon.click();
		return new PlayerForm();
	}

	/**
	 * Return the project name displayed in the top.
	 * @return
	 */
	public String getNameProjectText(){
		return nameProjectTextBox.getText();
	}

	/**
	 * Return the player name of the first layout.
	 * @return
	 */
	public String getPlayerNameText(){
		return playerNameText.getText();
	}

	/**
	 * 
	 * @return the user story title of the first layout.
	 */
	public String getUserStoryText(){
		return userStoryTitleText.getText();
	}

	/**
	 * Click in the dashboard link displayed in the menu on the top right.
	 * @return
	 */
	public DashboardPage clickDashboardLink(){
		dashboardLink.click();
		return new DashboardPage();
	}

	/**
	 * Click "+ Add Story" button that expand the form to create a US.
	 * @return UserStoryForm
	 */
	public UserStoryForm clickAddStoryBtn(){
		addUserStoryBtn.click();
		return new UserStoryForm();
	}

	/**
	 * To search
	 */
	public void setSearchUserStoryTextBox(String userStoryTitle){
		searchUserStoryTextBox.click();
		searchUserStoryTextBox.sendKeys(userStoryTitle);
	}
	
	public ProjectPage clickSearchIcon(){
		searchIcon.click();
		return this;
	}

	public ProjectPage searchUserStoryByTitle(String userStoryTitle){
		setSearchUserStoryTextBox(userStoryTitle);
		return clickSearchIcon();
	}

	public String getUserStoryTitleSearchColum(){
		return userStoryTitleSearch.getText();
	}
	/**
	 * Refresh the page
	 */
	public void pageRefresh(){
		driver.navigate().refresh();
	}
}
