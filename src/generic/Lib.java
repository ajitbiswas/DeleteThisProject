package generic;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class Lib  {
	static Workbook wb;
	public static WebDriver driver;
	

	public static String getProperty(String config_path, String key){
		String property="";
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(config_path));
			property = prop.getProperty(key);
		} catch (Exception e) {
		}
		return property;
	}

	public static int getRowCount(String excel_path, String sheet){
		int value=0;
		try {
			wb = WorkbookFactory.create(new FileInputStream(excel_path));
			value = wb.getSheet(sheet).getLastRowNum();

		} catch (Exception e) {

		}
		return value;
	}

	public static String getCellValue(String excel_path, String sheet, int row, int column) {
		String value="";
		try{
			wb = WorkbookFactory.create(new FileInputStream(excel_path));
			value = wb.getSheet(sheet).getRow(row).getCell(column).toString();
		}catch(Exception e){

		}
		return value;
	}
	
	
}
