package myntra.com;

import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.lang.module.ModuleDescriptor.Builder;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {
	
	static WebDriver driver;
public static void main(String[] args) throws InterruptedException {
	
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	
	driver.get("https://www.myntra.com/?utm_source=dms_google&utm_medium=searchbrand_cpc&utm_campaign=dms_google_searchbrand_cpc_Search_Brand_Myntra_Brand_India_BM_TROAS_SOK_New&gad_source=1&gclid=Cj0KCQjwv_m-BhC4ARIsAIqNeBu1aJ47xYme9TqnY2pxgwtj40QGqomFvTJ2XSIJVkxs-J1nP3WHq3EaAunUEALw_wcB");
	driver.manage().window().maximize();
	
	Actions a = new Actions(driver);
	WebElement men = driver.findElement(By.xpath("//a[@data-group='men']"));
	a.moveToElement(men).build().perform();
	WebElement Tshirts = driver.findElement(By.xpath("//a[@data-reactid='31']"));
	a.click(Tshirts).build().perform();
	
//	String Parentwindow = driver.getWindowHandle();
//	System.out.println("Parent window" +Parentwindow);
//	
	List<WebElement> Tshirtss = driver.findElements(By.xpath("//h4[@class='product-product']"));
	
	for (WebElement element : Tshirtss) {
		String text = element.getText();
		System.out.println(text);
	}
	

	String ref = "Men Solid Slim Fit T-shirt";
	
	for (WebElement element : Tshirtss) {
		if (element.getText().equals(ref)) {
			element.click();
		}
		
		Thread.sleep(2000);
	}
	
	
	//
	
//	Set<String> childwindow = driver.getWindowHandles();
//	for(String x: childwindow) {
//		if(!x.equals(Parentwindow)) {
//			System.out.println(x);
//			driver.switchTo().window(x);
//			Thread.sleep(2000);
//			WebElement size = driver.findElement(By.xpath("//p[text()='L']"));
//			a.click(size).build().perform();
//			Thread.sleep(1000);
//			WebElement addtobagElement = driver.findElement(By.xpath("//span[@class='myntraweb-sprite pdp-whiteBag sprites-whiteBag pdp-flex pdp-center']"));
//			a.click(addtobagElement).build().perform();
//		}
//	}
//	
//	
}
}
