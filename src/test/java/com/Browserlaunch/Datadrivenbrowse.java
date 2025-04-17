package com.Browserlaunch;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Datadrivenbrowse {

	static WebDriver driver;
	
	
	
	@Test(priority = 0)
	
	public void xcelfile() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		
		File file = new File("C:\\Users\\Prasad\\Documents\\Data.xlsx");
		FileInputStream fi =new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(fi);
		Sheet sheet1 = wb.getSheet("Sheet1");
		Row row = sheet1.getRow(0);
		Cell cell = row.getCell(0);
		CellType cellType = cell.getCellType();
		
		
		if (cellType.equals(CellType.STRING)) {
			String stringCellValue = cell.getStringCellValue();
			System.out.println(stringCellValue);
			
			
				
				driver = new ChromeDriver();
				driver.navigate().to("https://www.amazon.in/");
				driver.manage().window().maximize();
				WebElement search = driver.findElement(By.name("field-keywords"));
				search.sendKeys(stringCellValue);
				search.submit();
				
				
		}
		
		if(cellType.equals(CellType.NUMERIC)) {
			
			double numericCellValue = cell.getNumericCellValue();
			System.out.println(numericCellValue);
		}
		
		
			
	
		
	
	}
}
