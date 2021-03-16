package readingdatafromexcelsheet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester6 {
	public static void main(String[] args) throws Exception {
		
		String filePath = "./resource/config.properties";
		
		FileInputStream fin = new FileInputStream(filePath);
		
		Properties prop = new Properties();
		
		prop.load(fin);
		
		String chromeKey=PropertyFileLibrary.getData(filePath, "chromeKey");
		String chromePath=PropertyFileLibrary.getData(filePath, "chromePath");
		String appURL=PropertyFileLibrary.getData(filePath, "appUrl");
		String username=PropertyFileLibrary.getData(filePath,"username");
		String password=PropertyFileLibrary.getData(filePath, "password");
		
		System.setProperty(chromeKey, chromePath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);
		driver.findElement(By.id("loginButton")).click();
	}

}
