package tests.common;

import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeSuite;
import framework.util.ReadExcelFile;

public class ExcelFileData {

		protected static List<Map<String, String>> projectXLS;
		protected static List<Map<String, String>> playerXLS;
		protected static List<Map<String, String>> userstoryXLS;

		@BeforeSuite (groups = {"Acceptance"})
		public void init() 
		{
			//Create a object of ReadExcelFile class
			ReadExcelFile objExcelFile = new ReadExcelFile();
			
			//Prepare the path of excel file
			String filePath = System.getProperty("user.dir")+"\\src\\tests\\resources";
			
			//Call read file method of the class to read data
//			Object[][] projectXLS = objExcelFile.readExcel(filePath,"JATDataProvider.xlsx","ProjectData");
//			Object[][] playerXLS = objExcelFile.readExcel(filePath,"JATDataProvider.xlsx","PlayerData");
//			Object[][] userstoryXLS = objExcelFile.readExcel(filePath,"JATDataProvider.xlsx","UserStoryData");
//		
//			String keyWorkSheet =
//			String valueWorkSheet = 
//			createProject(projectXLS);
//			
			//createPlayer(playerXLS);
		    //createUserStory(userstoryXLS);
		}
		
		
		
//	    public static void createProject(List<Map<String, String>> projectXLS)
//	    {
//	        System.out.println("Starting to create Programs......");
//	        for (Map<String, String> projectInfo : projectXLS)
//	        {
//	            createProject(projectInfo.get("Project Title"), projectInfo.get("Iteration Length"), );
//	        }
//	        System.out.println("Finishing the creation of Programs......");
//	    }

	}
