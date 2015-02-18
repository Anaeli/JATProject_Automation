package tests.project;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import tests.common.BaseTest;
import framework.pages.dashboard.NewProjectForm;

/**
 * This test case verifies that a project created is updated.
 * @author Eliana Navia
 * @Version 1.0     18 Feb 2015
 */
public class VerifyIfAProjectIsUpdated extends BaseTest {
	NewProjectForm objNewProject = new NewProjectForm();

	/**
	 * Preconditions a project created (in the first row of project list)
	 * @throws IOException 
	 */
	@BeforeClass
	public void preconditions() throws IOException{
		createNewProject();
		objProject.clickDashboardLink();
	}
	
	/**
	 * Update the first project. 
	 */
	@Test(groups = { "Acceptance" })
	public void testVerifyIfAProjectIsUpdated(){
		String projectName = "1234";
		String iterationLength = "2";
		String usPointScale = "Fibonacci: 0, 1, 2, 3, 5, 8, 13, 20, 40, 100";
		objDashboard.clickUpdateProjectLink();
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

