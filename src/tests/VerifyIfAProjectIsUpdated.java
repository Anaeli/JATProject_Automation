package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import tests.common.BaseTestDashboard;
import framework.pages.dashboard.NewProjectForm;

/**
 * This test case verifies that a project created is updated.
 * @author Eliana Navia
 *
 */
public class VerifyIfAProjectIsUpdated extends BaseTestDashboard {
	NewProjectForm objNewProject;

	/**
	 * Preconditions a project created (in the first row of project list)
	 */
	@BeforeClass
	public void preconditions(){
		objNewProject = objDashboard.clickNewProject();
		objProject = objNewProject.createNewProject("1abc","1", "Linear: 0, 1, 2 , 3 , 4, 5, 6, 7, 8, 9, 10");
		objProject.clickDashboardLink();
	}
	
	/**
	 * Update the first project. 
	 */
	@Test
	public void testVerifyIfAProjectIsUpdated(){
		String projectName = "1234";
		String iterationLength = "2";
		String usPointScale = "Fibonacci: 0, 1, 2, 3, 5, 8, 13, 20, 40, 100";
		objDashboard.clickUpdateProject();
		objNewProject.updateProject(projectName,iterationLength,usPointScale );
		String actualProjectName = objDashboard.getProjectNameText();
		Assert.assertEquals(actualProjectName, projectName);
	}
	
	/**
	 * After the test is executed the project is deleted.
	 */
	@AfterClass
	public void postcondition(){
		objDashboard.deleteProject();
	}
}

