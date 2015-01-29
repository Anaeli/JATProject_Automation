package framework.pages.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import framework.common.SeleniumDriverManager;
import framework.pages.userStory.ProjectPage;

/**
 * 
 * @author Eliana Navia
 *
 */
public class NewProjectPage {
	DashboardPage dashboardPage;
	WebDriver driver;
	@FindBy(xpath ="//input[@type='text']")
	WebElement projectName;
	@FindBy(xpath = "//form[@id='newProjectForm']/div/div[3]/div/select")
	WebElement iterationLenght;
	@FindBy(xpath = "//form[@id='newProjectForm']/div/div[4]/div/select")
	WebElement pointScale;
	@FindBy(css ="div.ng-scope > button.btn.btn-primary")
	WebElement save;

	public NewProjectPage(){
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}
 
	public void setProjectName(String pName){
		projectName.click();
		projectName.sendKeys(pName);
		//driver.findElement(By.xpath("//form[@id='newProjectForm']/div/div/div/input")).sendKeys("MyProject");
	}
	public void setProjectStartDate(String ProjectStartDate){
		//new Select(driver.findElement(By.xpath("//form[@id='newProjectForm']/div/div[3]/div/select"))).selectByVisibleText("2");
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

	public ProjectPage createNewProject(String projectName, String iterationLenght, String pointScale){
		dashboardPage = new DashboardPage();
		dashboardPage.clickNewProject();
		setProjectName(projectName);
		setProjectLength(iterationLenght);
		setPointScale(pointScale);
		return clickSaveProject(); 
	}

	public DashboardPage updateProject(String projectName, String iterationLenght, String pointScale){
		dashboardPage.clickUpdateProject();
		setProjectName(projectName);
		setProjectLength(iterationLenght);
		setPointScale(pointScale);
		return  new DashboardPage(); //ask if is correct
	}

}
