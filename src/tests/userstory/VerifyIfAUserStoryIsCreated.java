package tests.userstory;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import tests.common.BaseTest;
import framework.pages.project.UserStoryForm;

/**
 * This test case verifies that a user story is created.
 * @author Eliana Navia
 *
 */
public class VerifyIfAUserStoryIsCreated extends BaseTest{
	UserStoryForm objUserStory;
	
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
	@DataProvider(name="UserStoryData")
	public Object[][] getDataFromXlsx() throws IOException, BiffException{
		Object[][] data =objReadExcel.readExcel(filePath, userStorySheet);
		return data;
	}

	/**
	 * Create a user story with the values of data provider.
	 * @param userStoryTitle
	 */
	@Test(dataProvider = "UserStoryData", groups = { "Acceptance" })
	public void testVerifyIfAUserStoryIsCreated(String userStoryTitle){
		objUserStory = objProject.clickAddStoryBtn();
		objUserStory.addNewUserStory(userStoryTitle);
		String actualUserStoryName = objProject.getUserStoryText(); 
		Assert.assertEquals(actualUserStoryName, userStoryTitle);
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
