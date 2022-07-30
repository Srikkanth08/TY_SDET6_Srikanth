package com.VTiger.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	public String readDatafromExcel(String Sheetname, int rownum, int cellnum) throws EncryptedDocumentException, InvalidFormatException, Throwable
	{
		FileInputStream fis = new FileInputStream("../SDET_HYD_6/Cricketers.xlsx");
		return WorkbookFactory.create(fis).getSheet(Sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
	}
	
	public int readNumericDataFromExcel(String Sheetname, int rownum, int cellnum) throws EncryptedDocumentException, InvalidFormatException, Throwable
	{
		FileInputStream fis = new FileInputStream("../SDET_HYD_6/Cricketers.xlsx");
		int value = (int) WorkbookFactory.create(fis).getSheet(Sheetname).getRow(rownum).getCell(cellnum).getNumericCellValue();
		return value;
	}
	
	public int getLastRow(String Sheetname) throws Throwable  
	{
		FileInputStream fis = new FileInputStream("../SDET_HYD_6/Cricketers.xlsx");
		int value1 = (int) WorkbookFactory.create(fis).getSheet(Sheetname).getLastRowNum();
		return value1;
	}
}
