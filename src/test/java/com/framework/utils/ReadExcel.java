package com.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.microsoft.schemas.office.visio.x2012.main.RowType;

public class ReadExcel {

	public static List<Map<String, String>> readData(String workbook, String sheet) throws IOException {
//		Map<String, String> cols = new HashMap<String, String>();
		List<Map<String, String>> rows = new ArrayList<Map<String, String>>();

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\TestData\\" + workbook);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet(sheet);
		int numberOfRows = sh.getPhysicalNumberOfRows();
		int numberOfCols = sh.getRow(0).getPhysicalNumberOfCells();

		for (int i = 1; i < numberOfRows; i++) {
			Map<String, String> cols = new HashMap<String, String>();
			if (sh.getRow(i) == null) {

				break;
			}

			for (int j = 0; j < numberOfCols; j++) {
				try {
					cols.put(sh.getRow(0).getCell(j).getStringCellValue(),
							sh.getRow(i).getCell(j).getStringCellValue());
				} catch (Exception e) {
					cols.put(sh.getRow(0).getCell(j).getStringCellValue(),
							"" + sh.getRow(i).getCell(j).getNumericCellValue());
				}

			}
			rows.add(cols);
		}

		return rows;

	}

}
