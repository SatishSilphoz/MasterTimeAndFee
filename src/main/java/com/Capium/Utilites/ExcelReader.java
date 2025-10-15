package com.Capium.Utilites;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static String[][] getSheetData(String filePath, String sheetName) {
		String[][] data = null;

		try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {

			Sheet sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
				throw new RuntimeException("Sheet " + sheetName + " not found.");
			}

			int rowCount = sheet.getPhysicalNumberOfRows();
			int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

			data = new String[rowCount - 1][colCount];

			for (int i = 1; i < rowCount; i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j < colCount; j++) {
					Cell cell = row.getCell(j);
					data[i - 1][j] = getCellValueAsString(cell);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}

	private static String getCellValueAsString(Cell cell) {
		if (cell == null)
			return "";

		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				return dateFormat.format(cell.getDateCellValue());
			}
			return String.valueOf((long) cell.getNumericCellValue()); 
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case FORMULA:
			return cell.getCellFormula(); 
		case BLANK:
		default:
			return "";
		}
	}

}
