package POIAPI;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POI2 {

public static void main(String[] args) throws IOException { 

		
//Finding the number of sheets 
FileInputStream fis = new FileInputStream("C:\\Selenium workspace training\\MAVENproject\\src\\test\\java\\POIAPI\\ExcelTestData.xlsx");
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
				
				int sheetCount = workbook.getNumberOfSheets();
				
System.out.println(sheetCount);
//============================================================================
//Retrieving the data of the required Test say 'Register' and print it 
for(int i=0;i<sheetCount;i++) {
	
	if(workbook.getSheetName(i).equalsIgnoreCase("Data")) {
		
		XSSFSheet sheet = workbook.getSheetAt(i);
		
		Iterator<Row> rows = sheet.iterator();
		
		Row firstRow = rows.next();
			
		Iterator<Cell> cells = firstRow.iterator();
		
		int c = 0;
		
		int columnpostion = 0;
		
		while(cells.hasNext()) {
			
			Cell cell = cells.next();
			
			if(cell.getStringCellValue().equalsIgnoreCase("Tests")){
				
				columnpostion = c;
				
			}
			
			c++;
			
		}
		
		while(rows.hasNext()) {
			
			Row row = rows.next();
			
			Cell cell = row.getCell(columnpostion);
			
			if(cell.getStringCellValue().equalsIgnoreCase("Register")) {
				
				Iterator<Cell> citr = row.iterator();
				
				while(citr.hasNext()) {
					
					System.out.println(citr.next().getStringCellValue());
					
				
				}}}}}}}
