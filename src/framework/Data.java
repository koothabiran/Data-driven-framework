package framework;


	
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	
	public class Data  {
		
	public static 	WebDriver driver;
	public static	WebDriverWait wait;
	public static	XSSFWorkbook workbook;
	public static	XSSFSheet sheet;
	public static	XSSFCell cell;
	
    AppData obj = new AppData();
	

	 @BeforeTest
	 public void TestSetup()
	{
		// Set the path of the Firefox driver.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Koothabiran\\eclipse-workspace\\Driven\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		// Enter url.
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		wait = new WebDriverWait(driver,30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	 
	
	
	@Test
	 public  void ReadData() throws IOException, InterruptedException
	 {
		 // Import excel sheet.
		 File src=new File("C:\\Users\\Koothabiran\\eclipse-workspace\\Driven\\excel\\automation.xlsx");
		 
		 // Load the file.
		 FileInputStream finput = new FileInputStream(src);
		 
		 // Load he workbook.
		workbook = new XSSFWorkbook(finput);
		 
	     // Load the sheet in which data is stored.
		 sheet= workbook.getSheetAt(0);
		 
		 
		 
		 for(int i=1; i<=sheet.getLastRowNum(); i++)
		 {
			 // Import data for Email.
			 cell = sheet.getRow(i).getCell(1);
			 cell.setCellType(Cell.CELL_TYPE_STRING);
			 driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(cell.getStringCellValue());
			 
			 Thread.sleep(3000);
			 
			 // Import data for password.
			 cell = sheet.getRow(i).getCell(2);
			 cell.setCellType(Cell.CELL_TYPE_STRING);
			 driver.findElement(By.xpath("//input[@type='password']")).sendKeys(cell.getStringCellValue());
			 Thread.sleep(3000);
			 
			 driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
			 Thread.sleep(3000);
			 
			 
			 
			  int a =driver.findElements(By.xpath("(//*[@class='_34Yjv1'])[1]")).size();
		        
		        // Specify the message needs to be written.          
		           String message = "Pass";
		           String message1 = "Fail";
		           if(a==1)
		        
		        {    
		        
		        Thread.sleep(3000);  
		       sheet.getRow(i).createCell(3).setCellValue(message);
		      
		        }
		      
		       else
		             {
		              Thread.sleep(3000);
		              sheet.getRow(i).createCell(3).setCellValue(message1);                    
		              
		             }
			 
			 
			 
			 // Write data in the excel.
		    FileOutputStream foutput=new FileOutputStream(src);
			
			
		    
		    // finally write content
		    workbook.write(foutput);
		    
		    
		   
		    driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).click();
			 Thread.sleep(6000);
			 
			obj.search(driver);
			
			 Thread.sleep(6000);
			 
			 obj.logout(driver);
			 Thread.sleep(4000);
 
		     // close the file
			  foutput.flush();
			  Thread.sleep(4000);
		    foutput.close();
		  

		 
		 }
		 
		
		 
	 } 
	
	
	}
	
	
	
	


