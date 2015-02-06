package tests.common;

import org.testng.annotations.BeforeClass;

import framework.pages.dashboard.DashboardPage;
import framework.pages.dashboard.NewProjectForm;
import framework.pages.project.ProjectPage;

/**
 * Preconditions for test cases related to dashboard page.
 * @author Eliana Navia
 *
 */
public class BaseTestDashboard {
	protected DashboardPage objDashboard = new DashboardPage();
	protected NewProjectForm objCreateProject;
	protected ProjectPage objProject;
	
	/**
	 * Preconditions a project created (in the first row of the project list)
	 */
	@BeforeClass
	public void preconditions(){
		objCreateProject = objDashboard.clickNewProject();
		objProject = objCreateProject.createNewProject("1abc","1", 
				"Linear: 0, 1, 2 , 3 , 4, 5, 6, 7, 8, 9, 10");
		objProject.clickDashboardLink();
	}
}
