package tests.common;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import framework.pages.dashboard.DashboardPage;
import framework.pages.dashboard.NewProjectForm;
import framework.pages.project.ProjectPage;
import framework.pages.project.UserStoryForm;
import framework.util.ReadExcelFile;

/*
 * @author Eliana Navia
 *
 */
public class BaseTest {
	protected DashboardPage objDashboard = new DashboardPage();
	protected NewProjectForm objNewProject;
	protected ProjectPage objProject;
	protected UserStoryForm objUserStory;
	protected ReadExcelFile xlsFile = new ReadExcelFile();
	protected String filePath = System.getProperty("user.dir")+"\\src\\tests\\resources\\JATDataProvider.xls";
	protected String projectSheet = "ProjectData";
	protected String userStorySheet = "UserStoryData";	
	protected List<Map<String, String>> userStoryDataXls; 
	/**
	 * Preconditions a project created (in the first row of the project list)
	 * @throws IOException 
	 */
    
	public void createNewProject() throws IOException{
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
	
}
