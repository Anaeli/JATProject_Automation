package framework.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

/**
 * Manages the web browser
 */
public class SeleniumDriverManager{
	private static SeleniumDriverManager manager = null;
	private WebDriver driver;
	private WebDriverWait wait;

	protected SeleniumDriverManager(){
		initializeDriver();
	}

	/**
	 * Select a browser
	 */
	private void initializeDriver(){
		
//		String filePath = System.getProperty("user.dir")+"\\lib\\chromedriver.exe";
//		System.setProperty("webdriver.chrome.driver",filePath);
//
//		//create chrome instance
//driver = new ChromeDriver();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30, 100);
		//driver.get("http://www.google.com");
	}

	/**
	 * Select a browser
	 */
	@Parameters("browser")
	public void setup(String browser) throws Exception{

		//Check if parameter passed from TestNG is 'firefox'
		if(browser.equalsIgnoreCase("firefox")){

			//create firefox instance
			driver = new FirefoxDriver();
		}

		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("chrome")){

			//set path to chromedriver.exe 
			System.setProperty("webdriver.chrome.driver","D:\\JAT\\lib\\chromedriver.exe");

			//create chrome instance
			driver = new ChromeDriver();
		}
		else{

			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
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
			//Logger.getLogger(getClass()).error("Unable to quit the webdriver" , e);
		}
		driver = null;
	}
}
