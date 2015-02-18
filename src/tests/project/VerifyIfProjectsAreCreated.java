package tests.project;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import tests.common.BaseTest;
import framework.pages.dashboard.DashboardPage;
import framework.pages.dashboard.NewProjectForm;
import framework.pages.project.ProjectPage;

/**
 * This test case verifies that a project is created after the form is filled
 * with valid information and saved.
 * 
 * @author Eliana Navia
 * @Version 1.0     18 Feb 2015
 */
public class VerifyIfProjectsAreCreated extends BaseTest{
	DashboardPage objDashboard = new DashboardPage();
	NewProjectForm objCreateProject;
	ProjectPage objProject;

	/**
	 * Read the data of a excel file.
	 * @return Object[][] where first column contains 'project name'
	 * second column contains 'iteration length', and the third 'Point Scale'
	 * @throws IOException
	 * @throws BiffException 
	 */
	@DataProvider(name="ProjectData")
	public Object[][] getDataFromXlsx() throws IOException, BiffException{
		Object[][] data =objReadExcel.readExcel(filePath, projectSheet);
		return data;
	}

	/**
	 * Execute the TCs with data provide by a excel file.
	 * @param projectName
	 * @param iterationLength
	 * @param usPointScale
	 */
	@Test(dataProvider="ProjectData", groups = { "Acceptance" })
	public void testVerifyIfProjectsAreCreated(String projectName, String iterationLength, 
			String usPointScale){
		objCreateProject = objDashboard.clickNewProjectBtn();
		objProject = objCreateProject.createNewProject(projectName, iterationLength, usPointScale);
		String actualProjectName = objProject.getNameProjectText();

		//Verify if the project name is the same that the text displayed in the project page
		Assert.assertEquals(actualProjectName, projectName);
	}

	/**
	 * This method only delete a project.
	 * 
	 */
	@AfterMethod
	public void deleteProject(){
		
		//Return to dashboard page to start the test again .
		objDashboard = objProject.clickDashboardLink();
		objDashboard.deleteProject();
	}
}

