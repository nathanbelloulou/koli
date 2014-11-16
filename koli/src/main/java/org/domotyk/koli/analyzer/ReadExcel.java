package org.domotyk.koli.analyzer;



import java.io.File;  
import java.io.IOException;  
import java.sql.Date;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.domotyk.koli.model.Colis;



import jxl.Cell;  
import jxl.Sheet;  
import jxl.Workbook;  
import jxl.read.biff.BiffException;  

public class ReadExcel {  
	private File inputFile;  
	public void setInputFile(File inputFile) {  
		this.inputFile = inputFile;  
	}  

	public List<Colis> read() throws IOException  {  
		File inputWorkbook = inputFile;  
		Workbook w;  
		List<Colis> coliss=new ArrayList<Colis>();
		try {  
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			ParsePosition pos =null;
			 
			
			w = Workbook.getWorkbook(inputWorkbook);  
			Sheet sheet = w.getSheet(0);  
			for (int i = 0; i < sheet.getRows(); i++) {  
				
					
					Colis colis= new Colis();
					Cell cell = sheet.getCell(1, i);  
					colis.setId(null);
					colis.setCode(cell.getContents());  
					cell = sheet.getCell(2, i);  
					colis.setName(cell.getContents());  
					cell = sheet.getCell(0, i);  
					 pos = new ParsePosition(0);
					colis.setSend_date(new Date(formatter.parse(cell.getContents(),pos).getTime()));  
					System.out.println( ""+colis.getCode()+"  "+colis.getName()+"  "+cell.getContents());
					coliss.add(colis);
				}  
			  
		} catch (BiffException e) {  
			e.printStackTrace();  
		}
		return coliss;  

	}  

	public static void main(String[] args) throws IOException {  
		ReadExcel test = new ReadExcel();  
		test.setInputFile(new File("C:/Classeur1.xls"));  
		test.read();  
	}  

}  
