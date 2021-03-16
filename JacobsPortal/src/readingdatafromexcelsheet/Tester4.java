package readingdatafromexcelsheet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester4 {
	
	public static void main(String[] args) {
		String filepath="./resource/testdata.xlsx";
		String sheetName="TC001";
		
		// This method is easier to understand than the previous methods 
		
		//String url=ExcelLibrary.getData(filepath, sheetName, 1, 0);
		//String username=ExcelLibrary.getData(filepath, sheetName, 1, 1 );
		//String password=ExcelLibrary.getData(filepath, sheetName, 1, 2 );//*
		
		String url=ExcelLibrary.getStringData(filepath, sheetName, 1, 0);
		String username=ExcelLibrary.getStringData(filepath, sheetName, 1, 1 );
		String password=ExcelLibrary.getStringData(filepath, sheetName, 1, 2 );
		
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
		
		

   }
}



