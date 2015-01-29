package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import framework.pages.Login;
import framework.pages.Logout;

public class TestSuite {	
	Login objLogin;
	Logout objLogout;
    	
	@BeforeSuite
	public void init(){
 		String userEmail= "Eliana.Navia@fundacion-jala.org";
 		String userPassword="P@ssw0rd";		
 	    //Create Login Page object
 	    objLogin= new Login(); 
 	    //login to application
 	    objLogin.loginIntoJAT(userEmail,userPassword);
     }
		
	@AfterSuite
    public void logout(){
		objLogout = new Logout();
		objLogout.logout();
		objLogin.closeBrowser();
	}
}
