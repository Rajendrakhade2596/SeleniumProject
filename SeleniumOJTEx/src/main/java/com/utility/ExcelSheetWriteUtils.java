package com.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelSheetWriteUtils {

	public org.apache.poi.ss.usermodel.Sheet sh = null;
	public Row row = null;
	public Cell c = null;

	public void excelSheetWrite(String path, String sheetname, int rows, int coloums, String value) throws Exception {

		FileInputStream fis = new FileInputStream(path);

		Workbook wb = WorkbookFactory.create(fis);

		if (wb.getSheet(sheetname) == null) {

			sh = wb.createSheet(sheetname);

			row = sh.createRow(rows);

			c = row.createCell(coloums);

		} else {
			sh = wb.getSheet(sheetname);

			row = sh.getRow(rows);

			if (row == null) {

				row = sh.createRow(rows);

				c = row.createCell(coloums);

			} else {
				row = sh.getRow(rows);
			}
			if (row.getCell(coloums) == null) {

				c = row.createCell(coloums);

			} else {

				c = row.getCell(coloums);
			}

		}
		c.setCellValue(value);
		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
		wb.close();
		fos.close();
		fis.close();

	}

	@Test
	public void writeExcelSheet() throws Exception {
		ExcelSheetWriteUtils utils = new ExcelSheetWriteUtils();

		utils.excelSheetWrite("OfflineWebSiteData.xlsx", "loginCredential1", 1, 3, "Result");

	}

}
