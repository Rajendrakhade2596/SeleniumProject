package com.utility;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetUtils {
	
	public int row ;

	public String[][] readExcelSheet() throws Exception {
		 
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream("OfflineWebSiteData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("logindata");
		row = sh.getLastRowNum();
		String[][] list = new String[8][2];
		for (int i = 1; i <=8; i++) 
		{   
				 list[i-1][0]= df.formatCellValue(sh.getRow(i).getCell(0));	
				 list[i-1][1]= df.formatCellValue(sh.getRow(i).getCell(1));	
		}
		for (String[] strings : list) {
			for (String strings2 : strings) {
				System.out.print(strings2+"  ");
			}System.out.println();
			
		}
		return list;
	}

}
