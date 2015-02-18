package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import tests.common.BaseTest;

/**
 * This test case verifies that USs are found using search..
 * @author Eliana Navia
 *
 */
public class VerifySearchUserStoryByTitle extends BaseTest{


	@BeforeClass
	public void preconditions() throws Exception{
		createNewProject();
		createUserStories();
	}

	@Test(groups = { "Acceptance" })
	public void testVerifySearchUserStoryByTitle(){
		String userStoryTitle = "User Story";
		objProject.searchUserStoryByTitle(userStoryTitle);

		for (int row = 1; row < 4; row++) {
			String actual = userStoryDataXls.get(0).get("User Story Title");
			String expected = objProject.getUserStoryTitleSearchColum();
			Assert.assertEquals(actual, expected);
		}
	}
}
