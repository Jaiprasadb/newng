package com.TestNG2;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	static WebDriver driver;
	@Test
	public void OpenAmazon() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.navigate().to("https://adactinhotelapp.com");
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("Prasad0213");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("95S64H");
		driver.findElement(By.id("login")).click();
		
		
		WebElement drop1 = driver.findElement(By.id("location"));
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(drop1));
		Select select= new Select(drop1);
		select.selectByVisibleText("London");
		
		WebElement hotels = driver.findElement(By.id("hotels"));
		Select s= new Select(hotels);
		s.selectByValue("Hotel Creek");
		
		TakesScreenshot ts= (TakesScreenshot) driver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		File dstFile = new File("C:\\Users\\Prasad\\eclipse-workspace\\TestNG2\\target\\myntra2.png");
		FileHandler.copy(scr, dstFile);
		
 			
			
	}
	
	}
	
	

