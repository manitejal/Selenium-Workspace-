package POIAPI;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POIDemo {
	
	public static void main(String[] args) throws IOException {
		ArrayList<String> alist = getdatafromexcelfile("Register");
		for(String a :alist)
		{System.out.println(a);}
	}

	public static ArrayList<String> getdatafromexcelfile (String Testname) throws IOException {
		ArrayList<String> alist=new ArrayList<String>();
		FileInputStream file =new FileInputStream("C:\\Selenium workspace training\\MAVENproject\\src\\test\\java\\POIAPI\\ExcelTestData.xlsx");
		XSSFWorkbook workbook =new XSSFWorkbook(file);
		
		//getting number of sheets 
		int sheetcount =workbook.getNumberOfSheets();
		System.out.println("Number of sheet's in the excel file  is " + sheetcount);
//==============================================================================================		
		//in sheet a for register i would like to get the particular column data
		for(int i =0; i<sheetcount; i++) {
		System.out.println(workbook.getSheetName(i));	
			if(workbook.getSheetName(i).equalsIgnoreCase("SheetA")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row firstrow = rows.next();   //it will give you the first row
				
				        Iterator<Cell> Firstrowcells = firstrow.iterator(); //getting rows cell in first column 
				        
				      
				        
				       // while(Firstrowcells.hasNext()) {System.out.println("Tests column values " +Firstrowcells.next().getStringCellValue());}
	//=================================================================================================================			        
				        //finding posistion of the word called "Tests"
				        int c =0;
					    int testcolumnposition =0;
					    while(Firstrowcells.hasNext()) {
				       Cell firstrowcell = Firstrowcells.next();
				       System.out.println(firstrowcell.getStringCellValue());
				       if(firstrowcell.getStringCellValue().equalsIgnoreCase("Tests")) {
				    	   testcolumnposition=c;
				    	   }
				       c++;
				        } 
					  System.out.println("Position of Tests is " +testcolumnposition);
	//===============================================================================================================
					    //iteration the remaining rows
					    while(rows.hasNext()) {
					    	Row Row = rows.next();
					    	Cell Cell = Row.getCell(testcolumnposition);
					    	if(Cell.getStringCellValue().equalsIgnoreCase("Testname")) {
					    		Iterator<Cell> Cells = Row.iterator();
					    		Cells.next();  //register heading 
					    		while(Cells.hasNext()) { 
					    			
					    			//System.out.println("Cells data is " + Cells.next().getStringCellValue());}
					    	
					    	
//=====================================================================================================================
					    	//if there is a numeric value 
					    		
					    	Cell currentcell =Cells.next();
					    	if(currentcell.getCellType()==CellType.STRING) {
					    		//System.out.println(currentcell.getStringCellValue());
					    		alist.add(currentcell.getStringCellValue());
					    	}else if(currentcell.getCellType()==CellType.NUMERIC) {
					    		//System.out.println(currentcell.getNumericCellValue());
					    		alist.add(NumberToTextConverter.toText(currentcell.getNumericCellValue()));
					    	}
					    }
					    }}}}
		return alist;
		
	}}
		
		
			
		
	


