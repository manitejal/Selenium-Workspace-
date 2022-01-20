package POIAPI;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*1.	Adding the above retrieved data of the required Test into an ArrayList, instead of printing 
2.	Move the code in to a reusable method and remove hardcoding of testcase
3.	Return the ArrayList
4.	Access this method from a Test method in another class
5.	Also make this reusable method to access numeric values */

public class POI3 {

	public static void main(String[] args) throws IOException {

		List<String> alist = getdatafromexcelfile("Register");
		for (String a : alist) {
			System.out.println(a);
		}
	}

	private static List<String> getdatafromexcelfile( String testcasename) throws IOException {
		List<String> alist = new ArrayList<String>();

		FileInputStream fis = new FileInputStream("C:\\Selenium workspace training\\MAVENproject\\src\\test\\java\\POIAPI\\ExcelTestData.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheetCount = workbook.getNumberOfSheets();

		for (int i = 0; i < sheetCount; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase("SheetA")) {

				XSSFSheet sheet = workbook.getSheetAt(i);

				Iterator<Row> rows = sheet.iterator();

				Row firstRow = rows.next();

				Iterator<Cell> cells = firstRow.iterator();

				int c = 0;

				int columnpostion = 0;

				while (cells.hasNext()) {

					Cell cell = cells.next();

					if (cell.getStringCellValue().equalsIgnoreCase("Tests")) {

						columnpostion = c;

					}

					c++;

				}

				while (rows.hasNext()) {

					Row row = rows.next();

					Cell cell = row.getCell(columnpostion);

					if (cell.getStringCellValue().equalsIgnoreCase(testcasename)) {

						Iterator<Cell> citr = row.iterator();

						while (citr.hasNext()) {

							Cell cellvalue = citr.next();

							if (cellvalue.getCellType() == CellType.STRING) {

								alist.add(cellvalue.getStringCellValue());

							} else {

								alist.add(NumberToTextConverter.toText(cellvalue.getNumericCellValue()));

							}

						}

					}

				}

				workbook.close();

			}

		}

		return alist;

	}
}
