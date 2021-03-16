package readingdatafromexcelsheet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Tester1 {
	
	public static void main(String[] args) throws Exception {
		String filepath="./resource/testdata.xlsx";
		String sheetName="TC001";
		
		FileInputStream fin = new FileInputStream(filepath);
		
		//Created Object Representation of ExcelFile 
		Workbook workBook = WorkbookFactory.create(fin);
		
		// Created the object representation of sheet
		Sheet sheet=workBook.getSheet(sheetName);
		
		//Create Object Representation of Row
		Row row1 = sheet.getRow(1);
		
		// Create Object Representation of Cell
		Cell cell0=row1.getCell(0);
		String url=cell0.getStringCellValue();
		System.out.println(url);

   }
}