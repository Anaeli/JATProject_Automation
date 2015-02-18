package tests.player;

import java.io.IOException;
import jxl.read.biff.BiffException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import framework.pages.project.PlayerForm;
import tests.common.BaseTest;

/**
 * This test case verifies that a player is created.
 * @author Eliana Navia
 * @Version 1.0     18 Feb 2015
 */
public class VerifyIfAPlayerIsCreated extends BaseTest {
	PlayerForm objPlayer;

	@BeforeClass
	public void preconditions() throws IOException{
		createNewProject();
	}

	/**
	 * Read the data of a excel file.
	 * @return Object[][] where first column contains 'project name'
	 * second column contains 'iteration length', and the third 'Point Scale'
	 * @throws IOException
	 * @throws BiffException 
	 */
	@DataProvider(name="PlayerData")
	public Object[][] getDataFromXlsx() throws IOException, BiffException{
		
		//Call read file method of the class to read data
		Object[][] data =objReadExcel.readExcel(filePath, player1Sheet);
		return data;
	}

	/**
	 * Execute the TCs with data provide by a excel file.
	 * @param projectName
	 * @param iterationLength
	 * @param usPointScale
	 */
	@Test(dataProvider="PlayerData" , groups = { "Acceptance" })
	public void testVerifyIfAPlayerIsCreated(String emailPlayer,String rolePlayer){	
		objPlayer = objProject.clickAddUserIcon();
		objPlayer.addPlayer(emailPlayer, rolePlayer);
		objProject.pageRefresh();
		String actualPlayerName = objProject.getPlayerNameText();
		Assert.assertEquals(actualPlayerName, emailPlayer);
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
