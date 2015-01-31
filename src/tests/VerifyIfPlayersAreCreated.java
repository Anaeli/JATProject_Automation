package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import framework.pages.dashboard.DashboardPage;
import framework.pages.dashboard.NewProjectForm;
import framework.pages.project.ProjectPage;

public class VerifyIfPlayersAreCreated {
	public DashboardPage objDashboard;
	public NewProjectForm objNewProject;
	public ProjectPage objProject;

	/**
	 * Preconditions a project created (in the first row of the project list)
	 */
	@BeforeTest
	public void preconditions(){
		objNewProject = new NewProjectForm();
		objProject = new ProjectPage();
		objNewProject.createNewProject("1abc","1", "Linear: 0, 1, 2 , 3 , 4, 5, 6, 7, 8, 9, 10");
	}

	/**
	 *
	 * @return Object[][] where first column contains 'project name'
	 * and second column contains 'iteration length'
	 */
	@DataProvider(name="projectData")
	public Object[][] getDataFromDataprovider(){
		return new Object[][] {
				{"Player1@yopmail.com", "Team Member"},
				{"Player2@yopmail.com", "Scrum Master"},
				{"Player3@yopmail.com", "Product Owner"}
		};
	}
	@Test(dataProvider="projectData")
	public void testVerifyIfPlayersAreCreated(String emailPlayer,String rolePlayer){
		objProject.addPlayer(emailPlayer, rolePlayer);
		Assert.assertTrue(objProject.getNameProjectText().contains(emailPlayer));
	}
	
	@AfterTest
	public void postconditions(){

	}
}
