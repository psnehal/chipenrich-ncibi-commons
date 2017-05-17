package org.ncibi.commons.file;

import java.io.File;

public interface DataFile {

	public void open(File file) throws Exception;
	
	public void save(File file) throws Exception;
	
	public void setValue(Double value, int row, int col); 
	
	public void setValue(Integer value, int row, int col); 
	
	public void setValue(String value, int row, int col);
	
	public String getString(int row, int col);

   	public Integer getInteger(int row, int col);
   	
   	public Double getDouble(int row, int col);
   	
	public int getStartRowIndex();
	
	public int getEndRowIndex();
	
	public int getStartColIndex(int row);

	public int getEndColIndex(int row);
   	
}
