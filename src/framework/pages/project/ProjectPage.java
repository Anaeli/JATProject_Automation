package framework.pages.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import framework.common.SeleniumDriverManager;

/**
 * 
 * @author Eliana Navia
 *
 */
public class ProjectPage {
	WebDriver driver;
	@FindBy(css ="div.project-name.ng-binding")
	WebElement nameProject;
	@FindBy(linkText ="DashBoard")
	WebElement dashboardLink;
	
	//Elements to create a Player
	@FindBy( css = "span.fa.fa-user" )
	WebElement addUserIcon;
	@FindBy(id = "player-emailPlayer" )
	WebElement emailPlayerField;
	@FindBy(xpath = "//div[@id='addPlayer']/div/form/div[2]/select" )
	WebElement rolePlayerComboBox;
	@FindBy(xpath = "//button[@type='submit" )
	WebElement submitBtn;
	
	public ProjectPage(){
		this.driver = SeleniumDriverManager.getManager().getDriver();
        PageFactory.initElements(driver, this);
	}
	
	public void clickAddUserIcon(){
		addUserIcon.click();
	}
	public void setEmailPlayer(String emailPlayer){
		emailPlayerField.clear();
		emailPlayerField.sendKeys(emailPlayer);
	}
	public void setRolePlayer(String rolePlayer){
		rolePlayerComboBox.sendKeys(rolePlayer);
	}
	public void clickSubmitBtn(){
		submitBtn.click();
	}
	
	public void addPlayer(String emailPlayer, String rolePlayer){
		clickAddUserIcon();
		setEmailPlayer(emailPlayer);
		setRolePlayer(rolePlayer);
		clickSubmitBtn();
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
