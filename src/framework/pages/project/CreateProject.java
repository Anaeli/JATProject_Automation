package framework.pages.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import framework.common.SeleniumDriverManager;
import framework.pages.UserStoryBoard;

public class CreateProject {
	public WebDriver driver;
	@FindBy(xpath ="//div[2]/button")
	WebElement newProjectBtn;
	@FindBy(xpath ="//form[@id='newProjectForm']/div/div/div/input")
	WebElement projectName;
	@FindBy(css ="div.ng-scope > button.btn.btn-primary")
	WebElement save;

	public CreateProject(){
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public void clickNewProject(){
		newProjectBtn.click();
	}
	
    public void setProjectName(String pName){
    	projectName.sendKeys(pName);
		 //driver.findElement(By.xpath("//form[@id='newProjectForm']/div/div/div/input")).sendKeys("MyProject");
	}
	public void setProjectStartDate(String ProjectStartDate){
		 //new Select(driver.findElement(By.xpath("//form[@id='newProjectForm']/div/div[3]/div/select"))).selectByVisibleText("2");
	}
	public void setProjectLenght(){
		//new Select(driver.findElement(By.xpath("//form[@id='newProjectForm']/div/div[4]/div/select"))).selectByVisibleText("Linear: 0, 1, 2 , 3 , 4, 5, 6, 7, 8, 9, 10");
		//new Select(driver.findElement(By.xpath("//form[@id='newProjectForm']/div/div[5]/div/select"))).selectByVisibleText("Average of 2 iterations");
		//new Select(driver.findElement(By.xpath("//form[@id='newProjectForm']/div/div[6]/div/select"))).selectByVisibleText("4");
	}
	public void clickSaveProject(){
		save.click();
	}
	
	//NewProject only set its title
	public UserStoryBoard createNewProject(String projectName){
		 clickNewProject();
		 setProjectName(projectName);
		 clickSaveProject(); 
		 return new UserStoryBoard();
	}


}
