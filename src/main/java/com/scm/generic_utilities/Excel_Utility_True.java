package com.scm.generic_utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility_True {

	FileInputStream fis;
	Workbook wb;
	Sheet sh;

	// To read the data from the excel
	public String getDataFromExcel(int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		fis = new FileInputStream("");
		wb = WorkbookFactory.create(fis);
		sh = wb.getSheet("Sheet1");
		Row row = sh.getRow(rowNum);
		String data = row.getCell(cellNum).toString();
		return data;
	}

	String data;

	// To check the expected data is present in sheet or not
	public boolean isDataPresent(String expectedData, int cellNum) {
		int rowCount = sh.getLastRowNum();
		for (int i = 1; i <= rowCount; i++) {

			if (sh.getRow(i) != null && sh.getRow(i).getCell(cellNum) != null) {
				data = sh.getRow(i).getCell(cellNum).toString();
				if (data.equalsIgnoreCase(expectedData)) {
					System.out.println(data + " this data is present");
					return true;
				}
			}
		}
		System.out.println(expectedData + " data is not present");
		return false;
	}
}
