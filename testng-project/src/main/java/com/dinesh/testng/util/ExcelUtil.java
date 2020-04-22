package com.dinesh.testng.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public static void writeResults(Map<String, String> resultsMap, String excelOutputFileName) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Execution Results");

		int rowNum = 0;
		System.out.println("Creating excel");
	
		for (String testName : resultsMap.keySet()) {
		    String testStatus = resultsMap.get(testName);
		    Row row = sheet.createRow(rowNum++);
		    Cell testNameCell = row.createCell(0);
		    testNameCell.setCellValue((String) testName);
		    Cell testStatusCell = row.createCell(1);
		    testStatusCell.setCellValue((String) testStatus);
		}

		try {
			FileOutputStream outputStream = new FileOutputStream(excelOutputFileName);
			workbook.write(outputStream);
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Done");

	}

}
