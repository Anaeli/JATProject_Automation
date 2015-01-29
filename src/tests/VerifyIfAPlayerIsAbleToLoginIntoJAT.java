package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import framework.pages.Login;
import framework.pages.Logout;
import framework.pages.project.DashboardPage;

public class VerifyIfAPlayerIsAbleToLoginIntoJAT {
	DashboardPage objDashboard;
	Login objLogin;
	Logout objLogout;
    WebDriver driver;
    
	/**
	 * Create instances of the pages 
	 */
    @BeforeTest
	public void setup(){
    	//Create Login Page object
        objLogin = new Login();
        objDashboard = new DashboardPage();
     }
	
	@Test
	public void testVerifyIfAPlayerIsAbleToLoginIntoJAT(){
 
	String userEmail= "Eliana.Navia@fundacion-jala.org";
	String userPassword="P@ssw0rd"; 
    //Login on the application
    objLogin.loginIntoJAT(userEmail,userPassword);
    
    //Verify if the Dashboard page contains the user email
    Assert.assertTrue(objDashboard.getLoginEmailText().contains(userEmail));
    }
	/**
	 * Logout of the application
	 */
	@AfterTest
	public void logout(){
		objLogout.logout();
    }

}
