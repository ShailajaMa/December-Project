package com.dataUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class TestData {
  
	FileInputStream file;
	XSSFWorkbook wb ;
	XSSFSheet sheet;
	
	
	public void initiateWorkBook() throws IOException   {
		file  = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/com/utilities/AutomationExcelData.xlsx");
		wb = new XSSFWorkbook(file);
		sheet = wb.getSheetAt(0);
		
	}
	@DataProvider (name ="testData")
	public Object[] getData() throws IOException {
		initiateWorkBook();
		Object data[] = new Object[2];
		int rows = sheet.getPhysicalNumberOfRows();
		for(int i = 1, j = 0; i < rows; i++) {
			data[j++]  = sheet.getRow(i).getCell(0).getStringCellValue();
			System.out.println(Arrays.toString(data));
	}
		return data;
}
	@DataProvider (name = "dataTest")
	public Object[][] dataTest() throws IOException {
		initiateWorkBook();
		Object [][] data = new Object[5][2];
		
		int rows = sheet.getPhysicalNumberOfRows();
		for (int i = 1, l = 0; i < rows; i++) {
			int cols = sheet.getRow(i).getLastCellNum();
			for(int k = 0; k < cols; k++) {
			data [l][k] = sheet.getRow(i).getCell(k).getStringCellValue();
			}
			/*for(int m = 0; m < data.length; m++) {
			    System.out.println(Arrays.toString(data[m]));	
		}*/
			l++;
	}
		return data;
		
	}
	
}

