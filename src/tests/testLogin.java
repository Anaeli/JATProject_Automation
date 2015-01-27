package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dblayer.Project;
import framework.common.SeleniumDriverManager;
import framework.pages.Login;
import framework.pages.project.DashboardPage;

public class testLogin {
	WebDriver driver;
	Login loginToJAT;
    DashboardPage<Project> dashboard;
	
    @BeforeTest
	public void setup(){
		/*this.driver = SeleniumDriverManager.getManager().getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://172.20.8.22:3001");*/
     }
	
	@Test(priority=0)
	public void testToVerifyIfTheDashboardPageIsUploaded(){
 
	String userEmail= "Eliana.Navia@fundacion-jala.org";
	String userPassword="P@ssw0rd";
		
    //Create Login Page object
    loginToJAT = new Login();
    dashboard = new DashboardPage<Project>();
 
    //login to application
    loginToJAT.loginIntoJAT(userEmail,userPassword);
 
    //Verify if the Dashboard page contains the user email
    Assert.assertTrue(dashboard.getLoginEmail().contains(userEmail));
    }
	
	@AfterTest
	public void deleteProject(){
		
    }

}
