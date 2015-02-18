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
 * @Version 1.0     18 Feb 2015
 */
public class ProjectPage {
	WebDriver driver;

	@FindBy(css ="div.project-name.ng-binding")
	WebElement nameProjectTextBox;
	@FindBy(linkText ="DashBoard")
	WebElement dashboardLink;
	@FindBy(css = "span.fa.fa-user")
	WebElement addUserIcon;
	@FindBy(id = "newUserStory_link")
	WebElement addUserStoryBtn;
	@FindBy(xpath ="//div[2]/div[3]/div/div/div/span")
	WebElement expandPlayerLayout;

	//Locators to search USs by title
	@FindBy(id = "word-search-uss")
	WebElement searchUserStoryTextBox;
	@FindBy(css = "button.btn.btn-default")
	WebElement searchIcon;

	//To verifications
	@FindBy(xpath = "//div[2]/div[4]/div/div/div[2]")
	WebElement playerNameText;
	@FindBy(xpath = "//div[@id='icebox']/div/div/div/div/div[3]")
	WebElement userStoryTitleText;
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
	 * Expand player form to create a new player.
	 * @return PlayerForm 
	 */
	public PlayerForm clickAddUserIcon(){
		addUserIcon.click();
		return new PlayerForm();
	}

	/**
	 * Click "+ Add Story" button that expand the User Story form to create a US.
	 * @return UserStoryForm
	 */
	public UserStoryForm clickAddStoryBtn(){
		addUserStoryBtn.click();
		return new UserStoryForm();
	}

	/**
	 * [SEARCH USER STORY]
	 */
	public void setSearchUserStoryTextBox(String userStoryTitle){
		searchUserStoryTextBox.click();
		searchUserStoryTextBox.sendKeys(userStoryTitle);
	}

	/**
	 * [SEARCH USER STORY]
	 */
	public void clickSearchIcon(){
		searchIcon.click();
	}
	
	/**
	 * [SEARCH USER STORY]
	 */
    public void searchUserStoryByTitle(String userStoryTitle){
		setSearchUserStoryTextBox(userStoryTitle);
		searchIcon.click();
	}

	public void clickExpandPlayerLayout(){
		expandPlayerLayout.click();
	}
	
	/**
	 * Click in the dashboard link displayed in the menu on the top right.
	 * @return Dashboard Page
	 */
	public DashboardPage clickDashboardLink(){
		dashboardLink.click();
		return new DashboardPage();
	}
	
	/**
	 *[ASSERTIONS] project creation
	 * Return the project name displayed in the top.
	 * @return
	 */
	public String getNameProjectText(){
		return nameProjectTextBox.getText();
	}

	/**
	 * [ASSERTIONS]player creation
	 * Return the player name of the first layout.
	 * @return
	 */
	public String getPlayerNameText(){
		return playerNameText.getText();
	}

	/**
	 * [ASSERTIONS] user story creation
	 * @return the user story title of the first layout.
	 */
	public String getUserStoryText(){
		return userStoryTitleText.getText();
	}

	/**
	 * [ASSERTIONS] search USs by title
	 * @return
	 */
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
