package org.ncibi.commons.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFile implements DataFile {

    private Workbook wb;
	private Sheet sheet;
	
	public ExcelFile() {
		wb = new XSSFWorkbook();
		sheet = wb.createSheet();
	}
	
	public ExcelFile(File file) throws Exception {
		open(file);
	}

	public void open(File file) throws Exception {
		InputStream input = new FileInputStream(file);
	    wb = WorkbookFactory.create(input);
	    sheet = wb.getSheetAt(0);
	    input.close();
	}
	
	public void save(File file) throws Exception {
		OutputStream output = new FileOutputStream(file);
		wb.write(output);
		output.close();
	}
	
	public void setValue(Double value, int row, int col) {
   		Row rowObject = sheet.getRow(row);
   		if(rowObject == null) 
   			rowObject = sheet.createRow(row);
   		
   		Cell cell = rowObject.getCell(col);
   		if(cell == null)
   			cell = rowObject.createCell(col);
   		
   		if(value == null)
   			cell.setCellType(Cell.CELL_TYPE_BLANK);
   		else
   			cell.setCellValue(value);
   	}
	
	public void setValue(Integer value, int row, int col) {
   		Row rowObject = sheet.getRow(row);
   		if(rowObject == null) 
   			rowObject = sheet.createRow(row);
   		
   		Cell cell = rowObject.getCell(col);
   		if(cell == null)
   			cell = rowObject.createCell(col);
   		
   		if(value == null)
   			cell.setCellType(Cell.CELL_TYPE_BLANK);
   		else
   			cell.setCellValue(value);
   	}
	
	public void setValue(String value, int row, int col) {
   		Row rowObject = sheet.getRow(row);
   		if(rowObject == null) 
   			rowObject = sheet.createRow(row);
   		
   		Cell cell = rowObject.getCell(col);
   		if(cell == null)
   			cell = rowObject.createCell(col);
   		
   		if(value == null)
   			cell.setCellType(Cell.CELL_TYPE_BLANK);
   		else
   			cell.setCellValue(value);
   	}
	
	public String getString(int row, int col){
		String value = null;
		Cell cell = getCell(row,col);
		if (cell == null) return null;
    	switch (cell.getCellType()){
    	case Cell.CELL_TYPE_BLANK: value = ""; break;
    	case Cell.CELL_TYPE_BOOLEAN: value = cell.getBooleanCellValue()?"true":"false"; break;
    	case Cell.CELL_TYPE_STRING: value = cell.getStringCellValue(); break;
    	case Cell.CELL_TYPE_NUMERIC:
    	case Cell.CELL_TYPE_FORMULA: value = ""+cell.getNumericCellValue(); break; 
    	default: value = null;
    	}
    	return value;
	}

   	public Integer getInteger(int row, int col){
   		Integer value = null;
		Cell cell = getCell(row,col);
		if (cell != null){
			if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC ||
					cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
				Number convert = cell.getNumericCellValue();
				value = convert.intValue();
			}
		}
   		return value;
   	}
   	
   	public Double getDouble(int row, int col){
   		Double value = null;
		Cell cell = getCell(row,col);
		if (cell != null){
			if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || 
					cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
				Number convert = cell.getNumericCellValue();
				value = convert.doubleValue();
			}
		}
   		return value;
   	}
   	
	public int getStartRowIndex() {
		return sheet.getFirstRowNum();
	}
	
	public int getEndRowIndex() {
		return sheet.getLastRowNum();
	}
	
	public int getStartColIndex(int row) {
		Row rowObject = sheet.getRow(row);
		if( rowObject != null)
			return rowObject.getFirstCellNum();
		else
			return -1;
	}

	public int getEndColIndex(int row) {
		Row rowObject = sheet.getRow(row);
		if( rowObject != null)
			return rowObject.getLastCellNum();
		else
			return -1;
	}
   	
   	private Cell getCell(int row, int col){
   		Row rowObject = sheet.getRow(row);
		if( rowObject != null) {
			Cell cell = rowObject.getCell(col);
			return cell;
		}
		else
			return null;
	}
   	
}
