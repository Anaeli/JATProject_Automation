package framework.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.log4testng.Logger;

import framework.util.ReadJSONFile;

import java.util.concurrent.TimeUnit;

/**
 * Manages the web browser
 * @author Eliana Navia
 * @Version 1.0     18 Feb 2015
 */
public class SeleniumDriverManager{
	private static SeleniumDriverManager manager = null;
	private WebDriver driver;
	private WebDriverWait wait;
	private ReadJSONFile objReadJSONFile = new ReadJSONFile();
	protected SeleniumDriverManager(){
		initializeDriver();
	}

	String message = "";
	
	/**
	 * Select a browser
	 */
	private void initializeDriver(){

		String browser = objReadJSONFile.readJSON("browser");
		try {
			switch(browser){
			case "chrome":

				//set path to chromedriver.exe 
				String filePath = System.getProperty("user.dir")+"\\lib\\chromedriver.exe";
				System.setProperty("webdriver.chrome.driver",filePath);

				//create chrome instance
				driver = new ChromeDriver();
				break;
			case "firefox": 

				//create firefox instance
				driver = new FirefoxDriver();
				break;
			default: 
				message = "invalid browser";
				break;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30, 100);
	}

	public static SeleniumDriverManager getManager(){
		if(manager == null){
			manager = new SeleniumDriverManager();
		}
		return manager;
	}

	/**
	 * Get the Web driver
	 * @return
	 */
	public WebDriver getDriver(){
		return driver;
	}

	public WebDriverWait getWait(){
		return wait;
	}

	/**
	 * Set to null the webdriver
	 */
	public void quitDriver(){
		try{
			driver.quit();
		}
		catch (Exception e){
			Logger.getLogger(getClass()).error("Unable to quit the webdriver" , e);
		}
		driver = null;
	}
}
