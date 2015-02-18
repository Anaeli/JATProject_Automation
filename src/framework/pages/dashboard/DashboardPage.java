package framework.pages.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.common.SeleniumDriverManager;
import framework.util.ReadJSONFile;

/**
 * Project list that belong to a user, a project could be added, updated and deleted.
 * @author Eliana Navia
 * @Version 1.0     18 Feb 2015
 */
public class DashboardPage {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(linkText = "Update") 
	WebElement updateProjectLink;
	@FindBy(linkText = "Delete") 
	WebElement deleteProjectLink;

	// Elements to delete a project
	@FindBy(id = "button-0")
	WebElement okBtn;

	//Elements to verifications
	@FindBy(xpath ="//span[contains(@title, 'email')]")
	WebElement userEmailText;
	@FindBy(css ="div.title2")
	WebElement projectNameText;

	ReadJSONFile objReadJSON = new ReadJSONFile();
	String browser = objReadJSON.readJSON("browser");

	/**
	 * Initialize the driver and web elements. 
	 * @throws Exception 
	 */
	public DashboardPage(){
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
		wait = SeleniumDriverManager.getManager().getWait();
	}

	/**
	 * Click on "+ new project" button.
	 * @return
	 */
	public NewProjectForm clickNewProjectBtn(){
		try{
			switch(browser){
			case "chrome":
				WebElement newProjectBtn = driver.findElement
				(By.xpath("html/body/div[1]/section/div/div/div/div/div[1]/div[2]/button"));
				newProjectBtn.click();
				break;
			case "firefox": 
				newProjectBtn = driver.findElement
				(By.xpath("//button[@class='aling-right btn btn-primary']"));			
				newProjectBtn.click();
				break;
			}
		}catch (NoSuchElementException e) {
			System.out.println("+ new project button has not been found." + e.getMessage());
			throw new NoSuchElementException(e.getMessage());
		} 
		catch (WebDriverException e) {
			System.out.println("+ new project button is not clickable." + e.getMessage());
			throw new NoSuchElementException(e.getMessage());
		} 
		return new NewProjectForm();
	}

	/**
	 * Click on "update" project link.
	 * @return
	 */
	public NewProjectForm clickUpdateProjectLink(){
		updateProjectLink.click();
		return new NewProjectForm();
	}

	/**
	 * [DELETE PROJECT]
	 * Click on "Delete" project link.
	 * @return
	 */
	public void clickDeleteProjectLink(){
		deleteProjectLink.click();
	}

	/**
	 * [DELETE PROJECT]
	 * Click OK button in confirmation message displayed to delete a project.
	 * @return Dashboard page
	 */
	public DashboardPage clickOkConfirmationDeleteProjectBtn(){
		wait.until(ExpectedConditions.visibilityOf(okBtn));
		okBtn.click();
		return this;
	}

	/**
	 * [DELETE PROJECT]
	 * Delete the first project of projects list.
	 * @return DashboardPage
	 */
	public DashboardPage deleteProject(){
		clickDeleteProjectLink();
		return clickOkConfirmationDeleteProjectBtn();
	}

	/**
	 * [ASSERTIONS]login in JAT
	 * Return the text of user email displayed on the top right of the page.
	 * @return user email
	 */
	public String getLoginEmailText(){
		return userEmailText.getText();
	}

	/**
	 * [ASSERTIONS]project creation
	 * @return project name of first project of the list.
	 */
	public String getProjectNameText(){
		return projectNameText.getText();
	}
}
