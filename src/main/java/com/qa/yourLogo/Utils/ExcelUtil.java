package com.qa.yourLogo.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
     //This is ExcelSheetdata stored in a string
	public static String ExcelSheetData="C:\\Users\\eddan\\.dotnet\\yourLogo\\src\\main\\java\\com\\qa\\yourLogo\\Testdata\\EditaccountDetails.xlsx";
    public static Workbook book;
    public  static Sheet sheet;
public static Object[][] getTestData(String sheetname)
{ Object[][] data=null;
	try {
		FileInputStream ip=new FileInputStream(ExcelSheetData);//get Excelsheet
	 book=	WorkbookFactory.create(ip);//To get data from Excelsheet
	   sheet=book.getSheet(sheetname);//to get data from EditAccountdetails sheet
	    data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];//get data from rows and columns because data is stored in rows and columns
	System.out.println("getting data from each row and column");
	for(int i=0;i<sheet.getLastRowNum();i++)
	{
		for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
		{
			data[i][j]=sheet.getRow(i+1).getCell(j).toString();
		}
	}
	
	
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	} catch (EncryptedDocumentException e) {
		
		e.printStackTrace();
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	return data;
}







}
