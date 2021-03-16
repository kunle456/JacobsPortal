package readingdatafromexcelsheet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester5 {
	
	public static void main(String[] args) {
		String filePath="./resource/multiplestdata.xlsx";
		String sheetName="TC002";
		
		String[][] sarr=ExcelLibrary.getMultipleData(filePath, sheetName);
		for(int i=1;i<=sarr.length-1;i++) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://demo.actitime.com");
			driver.findElement(By.id("username")).sendKeys(sarr[i][0]);
			driver.findElement(By.name("pwd")).sendKeys(sarr[i][1]);
			driver.findElement(By.id("loginButton")).click();
			
			
		}

}

     }
	
