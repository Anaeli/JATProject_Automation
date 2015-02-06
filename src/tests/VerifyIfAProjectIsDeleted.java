package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import tests.common.BaseTestDashboard;

/**
 * This test case verifies that a project created is deleted.
 * @author Eliana Navia
 *
 */
public class VerifyIfAProjectIsDeleted extends BaseTestDashboard{
	
	/**
	 * Update the first project. 
	 */
	@Test
	public void testVerifyIfAProjectIsDeleted(){
		String projectName = objDashboard.getProjectNameText();
		objDashboard.deleteProject();
		
		//Verify that project name is not displayed in the dashboard to ensure that the project does not exist.
		Assert.assertFalse(objDashboard.getProjectNameText().contains(projectName));
	}
}
