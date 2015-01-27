package tests;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import framework.pages.Login;
import framework.pages.project.CreateProjectPage;
import framework.pages.userStory.UserStoryBoardPage;

public class testNewProject {
	WebDriver driver;
	CreateProjectPage createProjectPage;
	Login login;
	UserStoryBoardPage userStoryBoardPage;

	
	@Test
	public void testToVerifyIfAProjectIsCreated(){
		createProjectPage = new CreateProjectPage();
        userStoryBoardPage = new UserStoryBoardPage();
		String projectName= "myProject";
		createProjectPage.createNewProject(projectName);
		Assert.assertTrue(userStoryBoardPage.getNameProjectText().contains(projectName));
	    }
     
	@Before
	public void DeleteProject(){
		userStoryBoardPage.clickDashboardLink();
		

	}
}
