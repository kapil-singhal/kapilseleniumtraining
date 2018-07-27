package trainingDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DemoWorkingWithFile {
	
	@Test
	public void DemoDataDrivenTest(){
		File file = new File("Selenium-Data.xlsx");
		try {
			InputStream inputStream = new FileInputStream(file);
			XSSFWorkbook xssf = new XSSFWorkbook(inputStream);
			XSSFSheet sheet1 = xssf.getSheet("sheet1");
			System.out.println("First row number" + sheet1.getFirstRowNum());
			System.out.println("Last row number" + sheet1.getLastRowNum());
			for(int i = 1; i <= sheet1.getLastRowNum(); i++) {
				System.out.println(sheet1.getRow(i).getCell(0).getStringCellValue() + "\t"
						+sheet1.getRow(i).getCell(1).getStringCellValue());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
