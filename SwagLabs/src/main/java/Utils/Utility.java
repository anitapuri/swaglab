package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility 
{
	private static WebDriver driver;
	
	public static String getDataFromExcelSheet(String filepath,String sheet,int row,int cell) throws EncryptedDocumentException, IOException
	{
		String data="";
		FileInputStream file=new FileInputStream(filepath);
		Workbook workbook=WorkbookFactory.create(file);
		//data=WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		
		try {
			data=workbook.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
			
		}
		catch(InvalidElementStateException i) {
			double value=WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
			data=Double.toString(value);
		}
		catch(NullPointerException n) {
			System.out.println("cell is blank");
		}
		
	    workbook.close();
		return data;
		
	}
	public static void CaptureScreenshot (String testID) throws IOException
	{
		
	    TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-mm-dd  hh-mm-ss");
		
		Date date=new Date();
		String str=dateformat.format(date);
		
		File dest=new File("test-output\\FailedTestScreenshot\\Screenshot"+testID +str + ".png");
		FileHandler.copy(src, dest);
		
	}
	
	

}
