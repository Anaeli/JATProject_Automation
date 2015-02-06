package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import framework.pages.project.PlayerForm;
import tests.common.BaseTestProject;

/**
 * This test case verifies that a player is created.
 * @author Eliana Navia
 *
 */
public class VerifyIfPlayersAreCreated extends BaseTestProject {
	PlayerForm objPlayer;

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
}
