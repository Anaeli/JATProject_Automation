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

public class ReadExcel {

	public List<Map<String, String>> readExcelFile(String filePath, String sheetName) throws IOException {
		List<Map<String, String>> listOfMaps = new LinkedList<>();	
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
}



