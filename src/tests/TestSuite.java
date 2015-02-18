package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import framework.pages.Login;
import framework.pages.Logout;
import framework.util.ReadJSONFile;

/**
 * Perform the login and logout in JAT.
 * @author Eliana Navia
 * @Version 1.0     18 Feb 2015
 */
public class TestSuite {	
	Login objLogin;
	Logout objLogout;
	ReadJSONFile objReadJSONFile = new ReadJSONFile();
    	
	@BeforeSuite
	public void init() throws Exception{
 		String userEmail = objReadJSONFile.readJSON("email");
 		String userPassword = objReadJSONFile.readJSON("password");	
 		
 	    //Create Login Page object
 	    objLogin= new Login(); 
 	    
 	    //login to application
 	    objLogin.loginIntoJAT(userEmail,userPassword);
     }
		
	@AfterSuite
    public void logout() throws Exception{
		objLogout = new Logout();
		objLogout.logout();
		objLogin.closeBrowser();
	}
}
