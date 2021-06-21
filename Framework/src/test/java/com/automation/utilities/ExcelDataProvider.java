package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	
	File src;
	
	public ExcelDataProvider(String src) throws IOException
	{
		this.src =  new File("./TestData/Data.xlsx");
		
		try {
			
			FileInputStream fis = new FileInputStream(src);
			
			wb = new XSSFWorkbook(fis);
			
		}catch(Exception e) {
			System.out.println("Unable to access file"+e.getMessage());
		}
			
		
	}
	
	
	public ExcelDataProvider() throws IOException
	{
		File src = new File("./TestData/Data.xlsx");
		
		try {
			
			FileInputStream fis = new FileInputStream(src);
			
			wb = new XSSFWorkbook(fis);
			
		}catch(Exception e) {
			System.out.println("Unable to access file"+e.getMessage());
		}
			
		
	}
	
	public String getStringData(String sheetname, int row, int column) {
		return wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		}
	
/*	public String getBooleanData(String sheetname, int row, int column) {
		return wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		}*/
	
	public  double getNumericData(String sheetname, int row, int column) {
		return wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
		
	}
	
	public String getStringData(int sheetAt, int row, int column) {
		return wb.getSheetAt(sheetAt).getRow(row).getCell(column).getStringCellValue();
		}
	
	public double getNumericData(int sheetAt, int row, int column) {
		return wb.getSheetAt(sheetAt).getRow(row).getCell(column).getNumericCellValue();
	}
	
	public  String getNumericDatatoString(String sheetname, int row, int column) {
		
		DataFormatter formatter = new DataFormatter();
		
	    Cell cell = wb.getSheet(sheetname).getRow(row).getCell(column);
	    
	    //String cellvalue = formatter.formatCellValue(cell);
	    
	    System.out.println(formatter.formatCellValue(cell));
	    
		return formatter.formatCellValue(cell);
		
	}
	
	public Object[][] getContactData(String sheetname) {
		
		try {
			ExcelDataProvider xl = new ExcelDataProvider("./TestData/Data.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(sheetname);
		
		sheet = wb.getSheet(sheetname);
		
		System.out.println(sheet.getLastRowNum());
		System.out.println(sheet.getRow(0).getLastCellNum());
		
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum();i++) {
			for(int k=0; k<=sheet.getRow(i).getLastCellNum();k++) {
				if (sheet.getRow(i+1).getCell(k) != null) {
				data[i][k] = sheet.getRow(i+1).getCell(k).toString(); //added to string
				System.out.println(data[i][k]);
				}
			}
		}
		return data;
		}
	

}
