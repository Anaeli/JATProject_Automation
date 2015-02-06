package tests.common;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import framework.pages.dashboard.DashboardPage;
import framework.pages.dashboard.NewProjectForm;
import framework.pages.project.ProjectPage;

/**
 * Preconditions for test cases related to project page.
 * @author Eliana Navia
 *
 */
public abstract class BaseTestProject {
	protected DashboardPage objDashboard = new DashboardPage();
	protected NewProjectForm objNewProject;
	protected ProjectPage objProject = new ProjectPage();
		
	/**
	 * Preconditions a project created (in the first row of the project list)
	 */
	@BeforeClass
	public void preconditions(){
		objNewProject = objDashboard.clickNewProject();
		objProject = objNewProject.createNewProject("1abc","1", 
				"Linear: 0, 1, 2 , 3 , 4, 5, 6, 7, 8, 9, 10");
	}
	
	/**
	 * After the test is executed the project where the USs were created is deleted.
	 */
	@AfterClass
	public void postconditions(){
		objProject.clickDashboardLink();
		objDashboard.deleteProject();
	}
}
