package myntra.com;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.module.ModuleDescriptor.Builder;
import java.security.PublicKey;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import javax.imageio.ImageIO;
import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Myntra {
	
	static WebDriver driver;

	@Test (priority = 0)
	public void openmyntra() throws AWTException, IOException {
       WebDriverManager.chromedriver().setup();
	
	driver = new ChromeDriver();
	
	driver.get("https://www.myntra.com/?utm_source=dms_google&utm_medium=searchbrand_cpc&utm_campaign=dms_google_searchbrand_cpc_Search_Brand_Myntra_Brand_India_BM_TROAS_SOK_New&gad_source=1&gclid=Cj0KCQjwv_m-BhC4ARIsAIqNeBu1aJ47xYme9TqnY2pxgwtj40QGqomFvTJ2XSIJVkxs-J1nP3WHq3EaAunUEALw_wcB");
	driver.manage().window().maximize();
	
	
	}
	
	@Test (priority = 1)
	public void move_to_men_and_click_Tshirt () {
		
	Actions a = new Actions(driver);
	WebElement men = driver.findElement(By.xpath("//a[@data-group='men']"));
	a.moveToElement(men).build().perform();
	WebElement Tshirts = driver.findElement(By.xpath("//a[@data-reactid='31']"));
	a.click(Tshirts).build().perform();
	
	}
	@Test(priority = 2)
	public void pick_an_element_based_on_condition() throws IOException, AWTException {
	List<WebElement> Tshirtss = driver.findElements(By.className("product-base"));
	
	
	for(WebElement y:Tshirtss) {
			System.out.println(y.getAttribute("id"));
				
	if (y.getAttribute("id").contains("25899796")) {
		y.click();
	}
	
	}
	
	String Parentwindow = driver.getWindowHandle();
	System.out.println("Parent window" +Parentwindow);
	
	
	
	
		
	
Actions actions=new Actions(driver);
	
	
	
Set<String> childwindow = driver.getWindowHandles();
	for(String x: childwindow) {
		if(!x.equals(Parentwindow)) {
			System.out.println(x);
			driver.switchTo().window(x);
			
			WebElement size = driver.findElement(By.xpath("//p[text()='L']"));
			actions.click(size).build().perform();
			
			WebDriverWait waits=new WebDriverWait(driver, 10);
			waits.until(ExpectedConditions.visibilityOf(size));
			WebElement addtobagElement = driver.findElement(By.xpath("//span[@class='myntraweb-sprite pdp-whiteBag sprites-whiteBag pdp-flex pdp-center']"));
			actions.click(addtobagElement).build().perform();
		}
	}
	}
	
	@Test (priority = 3)
	public void takesscreenshot() throws AWTException, IOException {
	
	TakesScreenshot ts = (TakesScreenshot) driver;
	File scr = ts.getScreenshotAs(OutputType.FILE);
	File dst= new File("C:\\Users\\Prasad\\eclipse-workspace\\TestNG2\\target\\Myntra.png");
	FileHandler.copy(scr, dst);
	
		
}
}
