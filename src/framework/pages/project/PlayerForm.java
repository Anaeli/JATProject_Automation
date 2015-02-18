package framework.pages.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.common.SeleniumDriverManager;

/**
 * Form to create a player.
 * @author Eliana Navia
 * @Version 1.0     18 Feb 2015
 */
public class PlayerForm {
	WebDriver driver;
	WebDriverWait wait;

	//Elements to create a Player
	@FindBy(id = "player-emailPlayer" )
	WebElement emailPlayerTextBox;
	@FindBy(xpath = "//div[@id='addPlayer']/div/form/div[2]/select" )
	WebElement rolePlayerComboBox;
	@FindBy(xpath = "//button[@type='submit']" )
	WebElement submitBtn;

	//Elements to delete a player
	@FindBy(xpath ="//div[2]/div/div[3]/span")
	WebElement deletePlayerIcon;
	@FindBy(id="button-0")
	WebElement confirmDeletePlayerBtn;

	/**
	 * Initialize the web elements.
	 */
	public PlayerForm (){
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
		wait = SeleniumDriverManager.getManager().getWait();
	}

	/**
	 * [ADD PLAYER]
	 * Set the email player with the value insert by the user.
	 * @param emailPlayer
	 */
	public void setEmailPlayerTextBox(String emailPlayer){
		emailPlayerTextBox.clear();
		emailPlayerTextBox.sendKeys(emailPlayer);
	}

	/**
	 * [ADD PLAYER]
	 * Set the role player (Team Member, Scrum Master, Stakeholder)
	 * @param rolePlayer
	 */
	public void setRolePlayerComboBox(String rolePlayer){
		rolePlayerComboBox.click();
		rolePlayerComboBox.sendKeys(rolePlayer);
	}

	/**
	 * [ADD PLAYER]
	 * Click in "Submit" button to save the values inserted in the form.
	 * @return
	 */
	public ProjectPage clickSubmitPlayerValuesBtn(){
		submitBtn.click();
		return new ProjectPage();
	}

	/**
	 * [ADD PLAYER]
	 * Steps to add a player in the project.
	 * @param emailPlayer
	 * @param rolePlayer
	 * @return
	 */
	public ProjectPage addPlayer(String emailPlayer, String rolePlayer){
		setEmailPlayerTextBox(emailPlayer);
		setRolePlayerComboBox(rolePlayer);
		return clickSubmitPlayerValuesBtn();
	}

	/**
	 * [DELETE PLAYER]
	 */
	public void clickDeletePlayerIcon(){
		deletePlayerIcon.click();
	}

	/**
	 * [DELETE PLAYER]
	 */
	public ProjectPage clickConfirmDeleteButton(){
		confirmDeletePlayerBtn.click();
		return new ProjectPage();
	}

	/**
	 * [DELETE PLAYER]
	 */
	public ProjectPage deletePlayer(){
		clickDeletePlayerIcon();
		return clickConfirmDeleteButton();
	}
}
