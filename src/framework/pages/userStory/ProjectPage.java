package framework.pages.userStory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import framework.common.SeleniumDriverManager;

public class ProjectPage {
	WebDriver driver;
	@FindBy(css ="div.project-name.ng-binding")
	WebElement nameProject;
	@FindBy(linkText ="DashBoard")
	WebElement dashboardLink;
	
	public ProjectPage(){
		this.driver = SeleniumDriverManager.getManager().getDriver();
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
	}
	
	public String getNameProjectText(){
		return nameProject.getText();
	}
	public void clickDashboardLink(){
		dashboardLink.click();
	}
//Drag and drop from Icebox pane to Backlog pane
//Drag and drop from Icebox pane to Backlog pane
}
