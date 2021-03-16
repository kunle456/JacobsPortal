package readingdatafromexcelsheet;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
	
	public class Tester3 {
		
		public static void main(String[] args) throws Exception {
			String filepath="./resource/testdata.xlsx";
			String sheetName="TC001";
			
			// Create the fin Object 
			FileInputStream fin = new FileInputStream(filepath);
			
			//Created Object Representation of ExcelFile 
			Workbook workBook = WorkbookFactory.create(fin);
			
			// Created the object representation of sheet
			Sheet sheet=workBook.getSheet(sheetName);
			
			String url=sheet.getRow(1).getCell(0).toString();
			String username=sheet.getRow(1).getCell(1).toString();
			String password=sheet.getRow(1).getCell(2).toString();
			
			System.out.println(url);
			System.out.println(username);
			System.out.println(password);
			
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			driver.findElement(By.id("username")).sendKeys("username");
			driver.findElement(By.name("pwd")).sendKeys("password");
			driver.findElement(By.id("loginButton")).click();
			Thread.sleep(10000);
			WebElement logoutLink=driver.findElement(By.id("logoutLink"));
			if(logoutLink.isDisplayed()) {
				System.out.println("Test Case Passed");
				logoutLink.click();
			} else {
				System.out.println("Test Case Failed");
			}
			

	   }
	}
