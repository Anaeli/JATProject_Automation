package tests;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.pages.dashboard.DashboardPage;
import framework.pages.dashboard.NewProjectForm;
import framework.pages.project.ProjectPage;
import framework.util.ReadExcelFile;

/**
 * This test case verifies that a project is created after the form is filled
 * with valid information and saved.
 * 
 * @author Eliana Navia
 *
 */
public class VerifyIfProjectsAreCreated{
	DashboardPage objDashboard = new DashboardPage();
	NewProjectForm objCreateProject;
	ProjectPage objProject;

	/**
	 * Initialization of all classes used in the test
	 */
	@BeforeClass
	public void preconditions (){

	}

	/**
	 * Read the data of a excel file.
	 * @return Object[][] where first column contains 'project name'
	 * second column contains 'iteration length', and the third 'Point Scale'
	 * @throws IOException
	 * @throws BiffException 
	 */
	@DataProvider(name="projectData")
	public Object[][] getDataFromXlsx() throws IOException, BiffException{
		
		//Create a object of ReadExcelFile class
		ReadExcelFile objReadExcel = new ReadExcelFile();
		
		//Prepare the path of excel file
		String filePath = System.getProperty("user.dir")+"\\src\\tests\\resources\\JATDataProvider.xls";
		String sheetName = "ProjectData";
		
		//Call read file method of the class to read data
		Object[][] data =objReadExcel.readExcel(filePath, sheetName);
		return data;
	}

	/**
	 * Execute the TCs with data provide by a excel file.
	 * @param projectName
	 * @param iterationLength
	 * @param usPointScale
	 */
	@Test(dataProvider="projectData")
	public void testVerifyIfProjectsAreCreated(String projectName, String iterationLength, 
			String usPointScale){
		objCreateProject = objDashboard.clickNewProject();
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

