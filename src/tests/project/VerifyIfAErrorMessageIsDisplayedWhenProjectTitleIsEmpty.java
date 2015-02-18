package tests.project;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.pages.dashboard.DashboardPage;
import framework.pages.dashboard.NewProjectForm;

/**
 * This test case verifies if a error message isDisplayed when project title is left empty.
 * @author Eliana Navia
 * @Version 1.0     18 Feb 2015
 */
public class VerifyIfAErrorMessageIsDisplayedWhenProjectTitleIsEmpty{
	DashboardPage objDashboard = new DashboardPage();
	NewProjectForm objNewProject;
	String messageError = "";

	@Test(groups = { "Functional Negative Testing" })
	public void testVerifyIfAErrorMessageIsDisplayedWhenProjectTitleIsEmpty(){
		try{
			objNewProject = objDashboard.clickNewProjectBtn();
			objNewProject.clickSaveProjectBtn();
			String actualMessage = objNewProject.getMessageErrorText();
			String expectedMessage = "Please introduce a title to the project";
			messageError = "The test has not been executed.";
			
			//Verify that the message displayed in "New Project" page is the expected.
			Assert.assertEquals(actualMessage, expectedMessage, messageError);
			objNewProject.clickCloseProjectBtn();
		}catch (AssertionError ex) {
			Assert.fail(messageError);
		}
	}
}
