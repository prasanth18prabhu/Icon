package com.task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.basepackage.BaseClass;

public class ExcelAutomation extends BaseClass{
	
	
	@Test
	public void test() throws IOException {
		
		String cellData = readCellData("C:\\Users\\VDI003\\eclipse-workspace\\45\\PS\\Icon\\src\\test\\resources\\Excel\\Book.xlsx", "Sheet1", 0, 0);
		
		System.out.println(cellData);
	
	}
	
	public static String readCellData(String fileLocation, String sheetName, int rowNumber, int cellNumber)
			throws IOException {

		try {

			String retn = null;

			FileInputStream fileInput = new FileInputStream(new File(fileLocation));

			Workbook workbook = new XSSFWorkbook(fileInput);

			Sheet sheet = workbook.getSheet(sheetName);

			Row row = sheet.getRow(rowNumber);

			Cell cell = row.getCell(cellNumber);
			
//			CellType celltype=cell.getCellType();
//			if(celltype==CellType.STRING) {
//				String stringvalue=cell.getStringCellValue();
//
//				System.out.println(stringvalue);
//
//				
//
//			} else if (celltype==CellType.NUMERIC) {
//
//				
//				if(DateUtil.isCellDateFormatted(cell)) {
//
//					Date date=cell.getDateCellValue();
//
//					SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
//
//					String datevalue=sdf.format(date);
//					System.out.println(datevalue);
//				} else {
//
//					
//
//					double numeric=cell.getNumericCellValue();
//                   long numericvalue=(long) numeric;
//					String numvalue=String.valueOf(numericvalue);
//					System.out.println(numvalue);
//
//				}

			if (cell != null) {

				CellType type = cell.getCellType();

				switch (type) {

				case STRING:

					retn = cell.getStringCellValue();

					break;

				case NUMERIC:

					if (DateUtil.isCellDateFormatted(cell)) {

						Date dateCellValue = cell.getDateCellValue();

						SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

						retn = dateFormat.format(dateCellValue);

					} else {

						double numericCellValue = cell.getNumericCellValue();

						long numericvalue = (long) numericCellValue;

						if (numericCellValue == numericvalue) {

							retn = String.valueOf(numericvalue);

						} else {

							retn = String.valueOf(numericCellValue);

						}

					}

					break;

				default:

					break;

				}

			}

			workbook.close();

			fileInput.close();

			return retn;

		} catch (IOException e) {

			System.out.println(e.getMessage());

		}
		return sheetName;

	}

	public static void updateCellData(String fileLocation, String sheetName, int rowNumber, int cellNumber,String previousData, String updatedData) throws IOException {
	
		try {

			FileInputStream fileInput = new FileInputStream(new File(fileLocation));

			Workbook workbook = new XSSFWorkbook(fileInput);

			Sheet sheet = workbook.getSheet(sheetName);

			Row row = sheet.getRow(rowNumber);

			Cell cell = row.getCell(cellNumber);

			String stringCellValue = cell.getStringCellValue();

			if (stringCellValue.equals(previousData)) {

				cell.setCellValue(updatedData);

			}

			FileOutputStream fos = new FileOutputStream(new File(fileLocation));

			workbook.write(fos);

			workbook.close();

			fileInput.close();

			fos.close();

		} catch (IOException e) {

			System.out.println(e.getMessage());

		}

	}

	public static void writeCellData(String fileLocation, String sheetName, int rowNumber, int cellNumber, String data)
			throws IOException {

		try {

			FileInputStream fileInput = new FileInputStream(new File(fileLocation));

			Workbook workbook = new XSSFWorkbook(fileInput);

			Sheet sheet = workbook.getSheet(sheetName);

			Row row = sheet.getRow(rowNumber);

			Cell cell = row.createCell(cellNumber);

			cell.setCellValue(data);

			FileOutputStream fos = new FileOutputStream(new File(fileLocation));

			workbook.write(fos);

			workbook.close();

			fileInput.close();

			fos.close();

		} catch (IOException e) {

			System.out.println(e.getMessage());

		}

	}

	public static String readingAllCellData(String fileLocation, String sheetName) throws IOException {

		try {

			String retn = null;

			FileInputStream fileInput = new FileInputStream(new File(fileLocation));

			Workbook workbook = new XSSFWorkbook(fileInput);

			Sheet sheet = workbook.getSheet(sheetName);

			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {

				Row row = sheet.getRow(i);

				for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {

					Cell cell = row.getCell(j);

					if (cell != null) {

						CellType type = cell.getCellType();

						switch (type) {

						case STRING:

							retn = cell.getStringCellValue();

							break;

						case NUMERIC:

							if (DateUtil.isCellDateFormatted(cell)) {

								Date dateCellValue = cell.getDateCellValue();

								SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

								retn = dateFormat.format(dateCellValue);

							} else {

								double numericCellValue = cell.getNumericCellValue();

								long numericvalue = (long) numericCellValue;

								if (numericCellValue == numericvalue) {

									retn = String.valueOf(numericvalue);

								} else {

									retn = String.valueOf(numericCellValue);

								}

							}

							break;

						default:

							break;

						}

					}

					workbook.close();

					fileInput.close();

					return retn;

				}
			}
		} catch (IOException e) {

			System.out.println(e.getMessage());

		}
		return sheetName;

	}

}
