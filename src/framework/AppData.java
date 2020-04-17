package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AppData {
	
	
public WebDriver driver;
	
@Test(priority=1)
	  public  void search(WebDriver driver) throws InterruptedException
		{
		  
		  
		  //search for kids cycle
		  driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("kidscycle");;
		  Thread.sleep(2000);
		  
		  //click on search button
		  driver.findElement(By.xpath("//button[@class='vh79eN']")).click();
		  Thread.sleep(3000);
		  
		  
		  JavascriptExecutor jse = (JavascriptExecutor) driver;
		  jse.executeScript("window.scrollBy(1156, 694)", "");
	  
	}
@Test(priority=2)
	  public void logout(WebDriver driver) throws InterruptedException
		{
		// mouseHover	  
		  WebElement dropdown= driver.findElement(By.xpath("//body/div[@id='container']/div/div[@class='_3ybBIU']/div[@class='_1tz-RS']/div[@class='_3pNZKl']/div[3]/div[1]/*[1]"));
		  Actions act = new Actions(driver);
		  act.moveToElement(dropdown).perform();
		  Thread.sleep(5000);

		  
		  // finding the invisible elemenet. logout button
		  driver.findElement(By.partialLinkText("Logout")).click();

	
	
	
		
}
}





