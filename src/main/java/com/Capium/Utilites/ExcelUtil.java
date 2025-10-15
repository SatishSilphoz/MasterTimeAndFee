package com.Capium.Utilites;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.*;
import java.io.File;

public class ExcelUtil {
	
    public static String getCellData(String filePath, String sheetName, int rowNum, int colNum) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowNum);
            Cell cell = row.getCell(colNum);
            return cell == null ? "" : cell.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    
    public static int getRowCount(String filePath, String sheetName) {
        int rowCount = 0;
        try {
            FileInputStream file = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheet(sheetName);
            rowCount = sheet.getPhysicalNumberOfRows();
            workbook.close();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowCount;
    }
    
    public static String getFormattedValue(Cell cell, DataFormatter formatter) {
        if (cell == null) return "";
        return formatter.formatCellValue(cell).trim();
    }
    
    public static String getFormattedDate(Cell cell, SimpleDateFormat dateFormat, DataFormatter formatter) {
        if (cell == null) return "";
        if (cell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cell)) {
            return dateFormat.format(cell.getDateCellValue());
        } else {
            return formatter.formatCellValue(cell).trim();
        }
    }

    
}
