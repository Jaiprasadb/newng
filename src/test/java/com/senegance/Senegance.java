package com.senegance;

import java.security.AllPermission;
import java.security.PublicKey;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.annotations.VisibleForTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;




public class Senegance {

	
	static WebDriver driver;
	
	
		@Test(priority=0)
			
		public void opensenegencewebsite() {
			
		WebDriverManager.chromedriver().setup();
		
		driver =  new ChromeDriver();
		driver.navigate().to("https://www.senegence.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		
		@Test(priority=1)
		public void clicksckincare(){
		Actions actions= new Actions(driver);
		
		WebElement skincare = driver.findElement(By.xpath("//span[text()='Skincare']"));
		actions.click(skincare).build().perform();
		
		
	 WebDriverWait waits=new WebDriverWait(driver, 20);
	 waits.until(ExpectedConditions.visibilityOf(skincare));
		
		}
		
		@Test(priority=2)
		public void printallelement() {
			
			List<WebElement> elements = driver.findElements(By.xpath("//p[@class='product__grid__title text--primary text-[--text]']"));
			for(WebElement x:elements) {
				
				System.out.println(x.getAttribute("id"));
				
			}
			
			

			
		}
		
	}

	

