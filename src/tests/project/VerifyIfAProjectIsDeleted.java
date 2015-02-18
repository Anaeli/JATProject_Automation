package tests.project;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import tests.common.BaseTest;

/**
 * This test case verifies that a project created is deleted.
 * @author Eliana Navia
 * @Version 1.0     18 Feb 2015
 */
public class VerifyIfAProjectIsDeleted extends BaseTest{
	String messageError = "";

	@BeforeClass
	public void preconditions() throws IOException{
		createNewProject();
		objProject.clickDashboardLink();
	}
	/**
	 * Delete the first project. 
	 */
	@Test(groups = { "Acceptance" })
	public void testVerifyIfAProjectIsDeleted(){
		try{
			String projectName = objDashboard.getProjectNameText();
			objDashboard.deleteProject();

			//Verify that project name is not displayed in the dashboard to ensure that the project does not exist.
			Assert.assertFalse(objDashboard.getProjectNameText().contains(projectName));
		}catch (AssertionError ex) {
			Assert.fail(messageError);
		}
	}
}
