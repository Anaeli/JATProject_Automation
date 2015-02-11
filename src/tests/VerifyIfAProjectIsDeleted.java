package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import tests.common.BaseTestDashboard;
import tests.util.ReportGenerate;

/**
 * This test case verifies that a project created is deleted.
 * @author Eliana Navia
 *
 */
@Listeners(ReportGenerate.class)
public class VerifyIfAProjectIsDeleted extends BaseTestDashboard{
	
	/**
	 * Delete the first project. 
	 */
	@Test
	public void testVerifyIfAProjectIsDeleted(){
		String projectName = objDashboard.getProjectNameText();
		objDashboard.deleteProject();
		
		//Verify that project name is not displayed in the dashboard to ensure that the project does not exist.
		Assert.assertFalse(objDashboard.getProjectNameText().contains(projectName));
	}
}
