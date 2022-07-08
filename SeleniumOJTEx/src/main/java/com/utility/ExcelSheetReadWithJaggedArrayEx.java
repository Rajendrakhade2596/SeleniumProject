package com.utility;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class ExcelSheetReadWithJaggedArrayEx {

	public static void main(String[] args) throws Exception {
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream("C:\\Users\\rajen\\eclipse-workspace 21\\HybridFramework\\OfflineWebSiteData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("testdata");
		int rows = sh.getLastRowNum();
		String[][] array = new String[rows+1][];
		for (int i = 0; i <=rows; i++) {
			int cols = sh.getRow(i).getLastCellNum();
			System.out.println(cols);
			array[i]= new String[cols];
			for (int j = 0; j <cols; j++) {
				Cell cell = sh.getRow(i).getCell(j);
				String cellValue = df.formatCellValue(cell);
				array[i][j]=cellValue;
			}
		}
		for (String[] strings : array) {
			System.out.println();
			for (String strings2 : strings) {
				System.out.print(strings2.toString()+" ");
			}
		}

	}
}
