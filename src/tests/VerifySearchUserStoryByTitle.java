package tests;

import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import framework.pages.dashboard.DashboardPage;
import framework.pages.dashboard.NewProjectForm;
import framework.pages.project.ProjectPage;
import framework.pages.project.UserStoryForm;
import framework.util.ReadExcel;

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


	@BeforeClass
	public void preconditions() throws Exception{
		ReadExcel xlsFile = new ReadExcel();
		String filePath = "D:\\JAT\\src\\tests\\resources\\JATDataProvider.xls";
		String projectSheet = "ProjectData";
		//String userStorySheet = "UserStoryData";
		List<Map<String, String>> projectDataXls = xlsFile.readExcelFile(filePath, projectSheet);
		//List<Map<String, String>> userStoryDataXls = xlsFile.readExcelFile(filePath, userStorySheet);
		objNewProject = objDashboard.clickNewProject();
		objProject = objNewProject.createNewProject(projectDataXls.get(0).get("Project Title"),
				projectDataXls.get(1).get("Iteration Length"),
				projectDataXls.get(2).get("Point Scale"));
//		objUserStory = objProject.clickAddStoryBtn();
//		objUserStory.addNewUserStory(userStoryDataXls.get(0).get("User Story Title"));
//		objUserStory.addNewUserStory(userStoryDataXls.get(0).get("User Story Title"));
//		objUserStory.addNewUserStory(userStoryDataXls.get(0).get("User Story Title"));
	}

	/**
	 * Create a user story with the values of data provider.
	 * @param userStoryTitle
	 */
	@Test 
	public void testVerifySearchUserStoryByTitle(){
		String userStoryTitle = "userStory";
		objProject.searchUserStoryByTitle(userStoryTitle);
	}
}
