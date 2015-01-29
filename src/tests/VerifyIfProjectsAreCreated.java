package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.pages.project.DashboardPage;
import framework.pages.project.NewProjectPage;
import framework.pages.userStory.ProjectPage;

/**
 * Title: 
 * 
 * @author Eliana Navia
 *
 */
public class VerifyIfProjectsAreCreated {
	DashboardPage objDashboard;
	NewProjectPage objCreateProject;
	ProjectPage objProject;

	/**
	 *
	 * @return Object[][] where first column contains 'project name'
	 * and second column contains 'iteration length'
	 */
	@DataProvider(name="projectData")
	public Object[][] getDataFromDataprovider(){

		return new Object[][] {
				{"1234","2", "Powers of two: 0, 1, 2, 4, 8, 16"},
				{"12345","3" , "Linear: 0, 1, 2 , 3 , 4, 5, 6, 7, 8, 9, 10"},
				{"123456","4" , "Fibonacci: 0, 1, 2, 3, 5, 8, 13, 20, 40, 100"}
		};
	}

	@Test(dataProvider="projectData")
	public void testVerifyIfProjectsAreCreated(String projectName, String iterationLength, String usPointScale){
		objCreateProject = new NewProjectPage();
		objProject = new ProjectPage();
		objDashboard = new DashboardPage();
		objCreateProject.createNewProject(projectName,iterationLength,usPointScale );
		Assert.assertTrue(objProject.getNameProjectText().contains(projectName));
		objProject.clickDashboardLink();
		//objDashboard.deleteProject();
	}
	
	@AfterTest
	public void deleteProject(){
		objDashboard.deleteProject();
	}
}

