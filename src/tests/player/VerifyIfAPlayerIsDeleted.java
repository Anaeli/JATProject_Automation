package tests.player;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import tests.common.BaseTest;

/**
 * 
 * @author Eliana Navia
 * @Version 1.0     18 Feb 2015
 */
public class VerifyIfAPlayerIsDeleted extends BaseTest {

	@BeforeClass
	public void preconditions() throws Exception{
		createNewProject();
		createNewPlayer();
	}
	
	/**
	 * Update the first project. 
	 */
	@Test(groups = { "Acceptance" })
	public void testVerifyIfAPlayerIsDeleted(){
		String playerName = objProject.getPlayerNameText();
		objProject.clickExpandPlayerLayout();
		objPlayer.deletePlayer();	
		Assert.assertFalse(objProject.getPlayerNameText().contains(playerName));
	}
	
	/**
	 * After the test is executed the project is deleted.
	 */
	@AfterClass
	public void postcondition(){
		objProject.clickDashboardLink();
		objDashboard.deleteProject();
	}

}
