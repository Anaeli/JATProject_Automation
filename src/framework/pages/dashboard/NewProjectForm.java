package framework.pages.dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import framework.common.SeleniumDriverManager;
import framework.pages.project.ProjectPage;

/**
 * Create a new project.
 * Update a project created.
 * @author Eliana Navia
 *
 */
public class NewProjectForm {
	public DashboardPage dashboardPage;
	WebDriver driver;
	@FindBy(xpath ="//input[@type='text']")
	WebElement projectName;
	@FindBy(xpath = "//form[@id='newProjectForm']/div/div[3]/div/select")
	WebElement iterationLenght;
	@FindBy(xpath = "//form[@id='newProjectForm']/div/div[4]/div/select")
	WebElement pointScale;
	@FindBy(css ="div.ng-scope > button.btn.btn-primary")
	WebElement save;

	public NewProjectForm(){
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
		dashboardPage = new DashboardPage();
	}

	public void setProjectName(String pName){
		projectName.click(); 
		projectName.clear();
		projectName.sendKeys(pName);
	}

	public void setProjectLength(String length){
		iterationLenght.click();
		iterationLenght.sendKeys(length);
	}
	public void setPointScale(String usPointScale){
		pointScale.click();
		pointScale.sendKeys(usPointScale);
	}
	public ProjectPage clickSaveProject(){
		save.click();
		return new ProjectPage();
	}

	public ProjectPage createNewProject(String projectName, String iterationLength, String pointScale){
		dashboardPage.clickNewProject();
		setProjectName(projectName);
		setProjectLength(iterationLength);
		setPointScale(pointScale);
		return clickSaveProject(); 
	}
	/**
	 * All locators to create and update are the same, reuse these.
	 * @param projectName
	 * @param iterationLength
	 * @param pointScale
	 * @return
	 */
	public DashboardPage updateProject(String projectName, String iterationLength, String pointScale){
		dashboardPage.clickUpdateProject();
		setProjectName(projectName);
		setProjectLength(iterationLength);
		setPointScale(pointScale);
		clickSaveProject(); 
		return  new DashboardPage(); 
	}
}
