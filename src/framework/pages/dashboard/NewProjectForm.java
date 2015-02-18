package framework.pages.dashboard;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.common.SeleniumDriverManager;
import framework.pages.project.ProjectPage;
import framework.util.ReadJSONFile;

/**
 * New project form to create a project.
 * @author Eliana Navia
 * @Version 1.0     18 Feb 2015
 */
public class NewProjectForm {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//input[@type='text']")
	WebElement projectNameTextBox;
	@FindBy(xpath = "//form[@id='newProjectForm']/div/div[3]/div/select")
	WebElement iterationLenghtComboBox;
	@FindBy(xpath = "//form[@id='newProjectForm']/div/div[4]/div/select")
	WebElement pointScaleComboBox;
	@FindBy(css = "div.ng-scope > button.btn.btn-primary")
	WebElement saveProjectBtn;
	@FindBy(css = "div.ng-scope > button.btn.btn-default")
	WebElement closeProjectBtn;
	@FindBy(xpath = "//div[@class='alert alert-danger ng-binding']")
	WebElement messageErrorText;
	ReadJSONFile objReadJSON = new ReadJSONFile();
	String browser = objReadJSON.readJSON("browser");

	/**
	 * Initialize the driver and web elements. 
	 * @throws Exception 
	 */
	public NewProjectForm(){
		this.driver = SeleniumDriverManager.getManager().getDriver();
		wait = SeleniumDriverManager.getManager().getWait();
		PageFactory.initElements(driver, this);
	}

	/**
	 * [NEW PROJECT]
	 * Set the project name in the "Project name" field.
	 * @param projectName
	 */
	public void setProjectNameTextBox(String projectName){
		try{
			switch(browser){
			case "chrome":
				wait.until(ExpectedConditions.visibilityOf(projectNameTextBox));
				projectNameTextBox.click();
				projectNameTextBox.clear();
				projectNameTextBox.sendKeys(projectName);
				break;
			case "firefox": 
				wait.until(ExpectedConditions.visibilityOf(projectNameTextBox));
				projectNameTextBox.clear();
				projectNameTextBox.sendKeys(projectName);
				break;
			}
		}catch (NoSuchElementException e) {
			System.out.println("Project title text box has not been found." + e.getMessage());
			throw new NoSuchElementException(e.getMessage());
		} 	
	}

	/**
	 * [NEW PROJECT]
	 * Set the iteration length measure in weeks.
	 * @param iterationLength
	 */
	public void setIterationLengthComboBox(String iterationLength){
		iterationLenghtComboBox.click();
		iterationLenghtComboBox.sendKeys(iterationLength);
	}

	/**
	 * [NEW PROJECT]
	 * Set the point to estimate the effort of USs.
	 * @param usPointScale
	 */
	public void setPointScaleComboBox(String usPointScale){
		pointScaleComboBox.click();
		pointScaleComboBox.sendKeys(usPointScale);
	}

	/**
	 * [NEW PROJECT]
	 * "Save" button in "New project" form, return Project page.
	 */
	public ProjectPage clickSaveProjectBtn(){
		saveProjectBtn.click();	
		return new ProjectPage();
	}

	/**
	 * [NEW PROJECT]
	 * Steps to create a project.
	 * @param projectName
	 * @param iterationLength
	 * @param pointScale to estimate the user story effort.
	 * @return Project Page
	 */
	public ProjectPage createNewProject(String projectName, String iterationLength,
			String pointScale){
		setProjectNameTextBox(projectName);
		setIterationLengthComboBox(iterationLength);
		setPointScaleComboBox(pointScale);
		return clickSaveProjectBtn();
	}

	/**
	 * [NEW PROJECT]
	 * Create a project with default values.
	 * @return Project Page default
	 */ 
	public ProjectPage createProjectDefault(String projectName){
		setProjectNameTextBox(projectName);
		return clickSaveProjectBtn();
	}

	/**
	 * [UPDATE PROJECT]
	 * "Update" button when a project is updated, return Project page.
	 * @return Dashboard Page
	 */
	public DashboardPage clickUpdateProjectBtn(){
		saveProjectBtn.click();
		return new DashboardPage();
	}

	/**
	 * [UPDATE PROJECT]
	 * All locators to create and update are the same, the method reuse these.
	 * @param projectName
	 * @param iterationLength
	 * @param pointScale
	 * @return Dashboard Page
	 */
	public DashboardPage updateProject(String projectName, String iterationLength,
			String pointScale){
		setProjectNameTextBox(projectName);
		setIterationLengthComboBox(iterationLength);
		setPointScaleComboBox(pointScale);
		return clickUpdateProjectBtn(); 
	}

	public DashboardPage clickCloseProjectBtn(){
		closeProjectBtn.click();	
		return new DashboardPage();
	}

	/**
	 * [ASSERTIONS] Project creation error
	 * @return message error when Project title text box is left empty.
	 */
	public String getMessageErrorText(){
		return messageErrorText.getText();
	}
}
