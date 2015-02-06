package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.pages.dashboard.DashboardPage;
import framework.pages.dashboard.NewProjectForm;
import framework.pages.project.ProjectPage;
import framework.pages.project.UserStoryForm;

/**
 * This test case verifies that a user story is created.
 * @author Eliana Navia
 *
 */
public class VerifyIfAUserStoryIsCreated {
	public DashboardPage objDashboard = new DashboardPage();
	public NewProjectForm objNewProject;
	public UserStoryForm objUserStory;
	public ProjectPage objProject;

	/**
	 * Preconditions a project created (in the first row of the project list)
	 */
	@BeforeClass
	public void preconditions(){
		objNewProject = objDashboard.clickNewProject();
		objProject = objNewProject.createNewProject("1abc","1", "Linear: 0, 1, 2 , 3 , 4, 5, 6, 7, 8, 9, 10");
	}

	/**
	 *
	 * @return Object[][] where first column contains 'user story title'
	 */
	@DataProvider(name = "userStoryData")
	public Object[][] getDataFromDataprovider(){
		return new Object[][] {
				{"User Story 1"},
				{"User Story 2"}
		};
	}

	/**
	 * Create a user story with the values of data provider.
	 * @param userStoryTitle
	 */
	@Test(dataProvider = "userStoryData")
	public void testVerifyIfAUserStoryIsCreated(String userStoryTitle){
		objUserStory = objProject.clickAddStoryBtn();
		objUserStory.addNewUserStory(userStoryTitle);
		String actualUserStoryName = objProject.getUserStoryText(); 
		Assert.assertEquals(actualUserStoryName, userStoryTitle);
	}

	/**
	 * After the test is executed the project where the USs were created is deleted.
	 */
	@AfterClass
	public void postconditions(){
		objProject.clickDashboardLink();
		objDashboard.deleteProject();
	}
}
