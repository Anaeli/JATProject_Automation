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
	
	@Test(groups = { "Functional Negative Testing" })
	public void testVerifyIfAErrorMessageIsDisplayedWhenProjectTitleIsEmpty(){
		objNewProject = objDashboard.clickNewProjectBtn();
		objNewProject.clickSaveProjectBtn();
		String actualMessage = objNewProject.getMessageErrorText();
		String expectedMessage = "Please introduce a title to the project";
		Assert.assertEquals(actualMessage, expectedMessage);
		objNewProject.clickCloseProjectBtn();
	}
}
