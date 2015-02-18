package tests.common;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import framework.pages.dashboard.DashboardPage;
import framework.pages.dashboard.NewProjectForm;
import framework.pages.project.PlayerForm;
import framework.pages.project.ProjectPage;
import framework.pages.project.UserStoryForm;
import framework.util.ReadExcelFile;

/*
 * Class where excel file values are got.
 * @author Eliana Navia
 * @Version 1.0     18 Feb 2015
 */
public class BaseTest {
	protected DashboardPage objDashboard = new DashboardPage();
	protected NewProjectForm objNewProject;
	protected ProjectPage objProject;
	protected UserStoryForm objUserStory;
	protected PlayerForm objPlayer;
	protected ReadExcelFile objReadExcel = new ReadExcelFile();
	protected String filePath = System.getProperty("user.dir")+"\\src\\tests\\resources\\JATDataProvider.xls";
	protected String projectSheet = "ProjectData";
	protected String userStorySheet = "UserStoryData";	
	protected String playerSheet = "PlayerPreData";
	protected String player1Sheet = "PlayerData";
	protected String badgeSheet = "BadgeData";
	protected List<Map<String, String>> userStoryDataXls; 
	protected List<Map<String, String>> projectDataXls;
	protected List<Map<String, String>> playerDataXls;
	protected List<Map<String, String>> badgeDataXls;
	
	/**
	 * Preconditions a project created (in the first row of the project list)
	 * @throws IOException 
	 */
	public void createNewProject() throws IOException{
		projectDataXls = objReadExcel.readExcelFile(filePath, projectSheet);
		objNewProject = objDashboard.clickNewProjectBtn();
		objProject = objNewProject.createProjectDefault(projectDataXls.get(0).get("Project Title"));
	}
	
	public void createUserStories() throws IOException{
		userStoryDataXls = objReadExcel.readExcelFile(filePath, userStorySheet);
		for (Map<String, String> listUS : userStoryDataXls){
			objUserStory = objProject.clickAddStoryBtn();
			objUserStory.addNewUserStory(listUS.get("User Story Title"));
		}
	}

	public void createNewPlayer() throws IOException{
		playerDataXls = objReadExcel.readExcelFile(filePath, playerSheet);
		objPlayer = objProject.clickAddUserIcon();
		objPlayer.addPlayer(playerDataXls.get(0).get("Email Player"),
				playerDataXls.get(1).get("Role Player"));
	}
}
