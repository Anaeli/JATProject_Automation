package tests;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import framework.pages.dashboard.DashboardPage;
import framework.pages.dashboard.NewProjectForm;
import framework.pages.project.ProjectPage;
import framework.pages.project.UserStoryForm;
import framework.util.ReadExcelFile;

/**
 * This test case verifies that a user story is created.
 * @author Eliana Navia
 *
 */
public class VerifySearchUserStoryByTitle {
	UserStoryForm objUserStory;
	DashboardPage objDashboard = new DashboardPage();
	NewProjectForm objNewProject;
	ProjectPage objProject;
	ReadExcelFile xlsFile = new ReadExcelFile();
	String filePath = System.getProperty("user.dir")+"\\src\\tests\\resources\\JATDataProvider.xls";
	String projectSheet = "ProjectData";
	String userStorySheet = "UserStoryData";	
	List<Map<String, String>> userStoryDataXls; 

	@BeforeClass
	public void preconditions() throws Exception{
		userStoryDataXls = xlsFile.readExcelFile(filePath, userStorySheet);
		List<Map<String, String>> projectDataXls = xlsFile.readExcelFile(filePath, projectSheet);
		objNewProject = objDashboard.clickNewProject();
		objProject = objNewProject.createNewProject(projectDataXls.get(0).get("Project Title"),
				projectDataXls.get(1).get("Iteration Length"),
				projectDataXls.get(2).get("Point Scale"));

		for (Map<String, String> listUS : userStoryDataXls){
			objUserStory = objProject.clickAddStoryBtn();
			objUserStory.addNewUserStory(listUS.get("User Story Title"));
		}
	}

	/**
	 * Create a user story with the values of data provider.
	 * @param userStoryTitle
	 */
	@Test 
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
