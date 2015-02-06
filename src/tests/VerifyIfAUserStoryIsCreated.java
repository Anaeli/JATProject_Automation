package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import tests.common.BaseTestProject;
import framework.pages.project.UserStoryForm;

/**
 * This test case verifies that a user story is created.
 * @author Eliana Navia
 *
 */
public class VerifyIfAUserStoryIsCreated extends BaseTestProject{
	UserStoryForm objUserStory;
	
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
}
