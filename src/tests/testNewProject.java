package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import framework.common.SeleniumDriverManager;
import framework.pages.Login;
import framework.pages.UserStoryBoard;
import framework.pages.project.CreateProject;


public class testNewProject {
	WebDriver driver;
	CreateProject createProjectPage;
	Login login;
	UserStoryBoard userStoryBoardPage;

	@BeforeTest
	public void setup(){
        login = new Login();
        login.loginIntoJAT("Eliana.Navia@fundacion-jala.org", "P@ssw0rd");
        createProjectPage = new CreateProject();
        userStoryBoardPage = new UserStoryBoard();
     }
	
	@Test
	public void testToVerifyIfAProjectIsCreated(){
		
		String projectName= "myProject";
		createProjectPage.createNewProject(projectName);
		Assert.assertTrue(userStoryBoardPage.getNameProjectText().contains(projectName));
	    }

}
