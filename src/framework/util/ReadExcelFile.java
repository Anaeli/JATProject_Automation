package framework.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcelFile {

	/**
	 * Return a map list with excel information.
	 * @param filePath
	 * @param sheetName
	 * @return
	 * @throws IOException
	 */
	public List<Map<String, String>> readExcelFile(String filePath, String sheetName) throws IOException {

		//It provides a linked-list map(key, value) structure.
		List<Map<String, String>> listOfMaps = new LinkedList<>() ;	
		try {
			Workbook workbook;
			workbook = Workbook.getWorkbook(new File(filePath));
			Sheet sheet = workbook.getSheet(sheetName); 

			for (int row = 1; row < sheet.getRows(); row++) {
				Map<String, String> map = new HashMap<>();
				for (int col = 0; col < sheet.getColumns(); col++) {
					String key = sheet.getCell(col,0).getContents();
					String value = 	sheet.getCell(col,row).getContents();		
					map.put(key, value);				
				}
				listOfMaps.add(map);	
			}
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return listOfMaps;
	}

	public Object[][] readExcel(String filePath,String sheetName) 
			throws IOException, BiffException{
		Workbook workbook = Workbook.getWorkbook(new File(filePath));
		Sheet sheet = workbook.getSheet(sheetName); 
		int rowCount = sheet.getRows();
		int colCount = sheet.getColumns();
		Object[][] data = new Object[rowCount-1][colCount];
		for (int row = 1; row < rowCount; row++) {
			for (int col = 0; col < colCount; col++) {
				data[row-1][col] = sheet.getCell(col,row).getContents(); 
			}
		}
		return data;
	}
}



