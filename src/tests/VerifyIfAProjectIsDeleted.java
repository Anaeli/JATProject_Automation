package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import framework.pages.dashboard.DashboardPage;
import framework.pages.dashboard.NewProjectForm;
import framework.pages.project.ProjectPage;

/**
 * This test case verifies that a project created is deleted.
 * @author Eliana Navia
 *
 */
public class VerifyIfAProjectIsDeleted {
	DashboardPage objDashboard = new DashboardPage();
	NewProjectForm objCreateProject;
	ProjectPage objProject;
	boolean projectNameIsVisible = true;

	/**
	 * Preconditions a project created (in the first row of the project list)
	 */
	@BeforeClass
	public void preconditions(){
		objCreateProject = objDashboard.clickNewProject();
		objProject = objCreateProject.createNewProject("1abc","1", "Linear: 0, 1, 2 , 3 , 4, 5, 6, 7, 8, 9, 10");
		objProject.clickDashboardLink();
	}

	/**
	 * Update the first project. 
	 */
	@Test
	public void testVerifyIfAProjectIsDeleted(){
		String projectName = objDashboard.getProjectNameText();
		objDashboard.deleteProject();
		Assert.assertFalse(objDashboard.getProjectNameText().contains(projectName));
		if (!objDashboard.getProjectNameText().contains(projectName)){
			projectNameIsVisible = false;
		}
	}

	/**
	 * Delete the project if it has been deleted for any reason.
	 */
	@AfterMethod
	public void poscondition(){
		if(projectNameIsVisible){
			objDashboard.deleteProject();
		}
	}
}
