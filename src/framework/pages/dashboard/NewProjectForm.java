package framework.pages.dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import framework.common.SeleniumDriverManager;
import framework.pages.project.ProjectPage;

/**
 * Create a new project form.
 * @author Eliana Navia
 *
 */
public class NewProjectForm {
	WebDriver driver;
	@FindBy(xpath = "//input[@type='text']")
	WebElement projectNameTextBox;
	@FindBy(xpath = "//form[@id='newProjectForm']/div/div[3]/div/select")
	WebElement iterationLenghtField;
	@FindBy(xpath = "//form[@id='newProjectForm']/div/div[4]/div/select")
	WebElement pointScaleField;
	@FindBy(css = "div.ng-scope > button.btn.btn-primary")
	WebElement saveBtn;

	/**
	 * Initialize the driver and web elements. 
	 */
	public NewProjectForm(){
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}

	/**
	 * Set the project name in the "Project name" field.
	 * @param projectName
	 */
	public void setProjectName(String projectName){
		projectNameTextBox.click(); 
		projectNameTextBox.clear();
		projectNameTextBox.sendKeys(projectName);
	}

	/**
	 * Set the iteration length measure in weeks.
	 * @param iterationLength
	 */
	public void setProjectLength(String iterationLength){
		iterationLenghtField.click();
		iterationLenghtField.sendKeys(iterationLength);
	}

	/**
	 * Set the point to estimate the effort of USs.
	 * @param usPointScale
	 */
	public void setPointScale(String usPointScale){
		pointScaleField.click();
		pointScaleField.sendKeys(usPointScale);
	}

	/**
	 * "Save" button in "New project" form, return Dashboard page.
	 * "Update" button when a project is updated, return Project page.
	 */
	public void clickSaveProject(){
		saveBtn.click();	
	}

	/**
	 * Steps to create a project.
	 * @param projectName
	 * @param iterationLength
	 * @param pointScale to estimate the user story effort.
	 * @return
	 */
	public ProjectPage createNewProject(String projectName, String iterationLength,
			String pointScale){
		setProjectName(projectName);
		setProjectLength(iterationLength);
		setPointScale(pointScale);
		clickSaveProject();
		return new ProjectPage();
	}

	/**
	 * All locators to create and update are the same, the method reuse these.
	 * The link, and the return are different.
	 * @param projectName
	 * @param iterationLength
	 * @param pointScale
	 * @return
	 */
	public DashboardPage updateProject(String projectName, String iterationLength,
			String pointScale){
		setProjectName(projectName);
		setProjectLength(iterationLength);
		setPointScale(pointScale);
		clickSaveProject(); 
		return  new DashboardPage(); 
	}
}
