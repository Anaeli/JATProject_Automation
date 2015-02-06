package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import framework.pages.dashboard.DashboardPage;
import framework.pages.dashboard.NewProjectForm;
import framework.pages.project.PlayerForm;
import framework.pages.project.ProjectPage;

/**
 * This test case verifies that a player is created.
 * @author Eliana Navia
 *
 */
public class VerifyIfPlayersAreCreated {
	DashboardPage objDashboard = new DashboardPage();
	NewProjectForm objNewProject;
	PlayerForm objPlayer;
	ProjectPage objProject;

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
	 * @return Object[][] where first column contains 'user email'
	 * and second column contains 'role'
	 */
	@DataProvider(name="playerData")
	public Object[][] getDataFromDataprovider(){
		return new Object[][] {
				{"Player1@yopmail.com", "Team Member"},
				{"Player2@yopmail.com", "Scrum Master"}
		};
	}

	/**
	 * Verify is the player are created successfully, 3 players should be created.
	 * @param emailPlayer
	 * @param rolePlayer
	 */
	@Test(dataProvider="playerData")
	public void testVerifyIfPlayersAreCreated(String emailPlayer,String rolePlayer){	
		objPlayer = objProject.clickAddUserIcon();
		objPlayer.addPlayer(emailPlayer, rolePlayer);
		objProject.pageRefresh();
		String actualPlayerName = objProject.getPlayerNameText();
		Assert.assertEquals(actualPlayerName, emailPlayer);
	}

	/**
	 * After the test is executed the project where the players were created is deleted.
	 */
	@AfterClass
	public void postconditions(){
		objProject.clickDashboardLink();
		objDashboard.deleteProject();
	}
}
