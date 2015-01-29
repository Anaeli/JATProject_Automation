package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import framework.pages.project.DashboardPage;
import framework.pages.project.NewProjectPage;
import framework.pages.userStory.ProjectPage;

public class VerifyIfAProjectIsUpdated {
	DashboardPage objDashboard;
	NewProjectPage objCreateProject;
	ProjectPage objProject;
	
	/**
	 * Preconditions a project create
	 */
	 @BeforeTest
	 public void preconditions(){
		 objCreateProject = new NewProjectPage();
         objCreateProject.createNewProject("1abc","1", "Linear: 0, 1, 2 , 3 , 4, 5, 6, 7, 8, 9, 10");
         objProject.clickDashboardLink();
	 }

	public void testVerifyIfAProjectIsUpdated(){
		objCreateProject = new NewProjectPage();
		objDashboard = new DashboardPage();
		
		String projectName = "1234";
		String iterationLength = "2";
		String usPointScale = "Fibonacci: 0, 1, 2, 3, 5, 8, 13, 20, 40, 100";
		
		objCreateProject.updateProject(projectName,iterationLength,usPointScale );
		Assert.assertTrue(objDashboard.getProjectNameText().contains(projectName));
		}
 
	/**
	 * Postconditions delete project created    
	 */
	@AfterTest
	    public void postcondiction(){
	    	objDashboard.deleteProject();
	    }
	}

