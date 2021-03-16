package LoginPage;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jp.princesofpower.org/");
		driver.findElement(By.xpath("//a[@id=\'list-login-list\']")).click();
		driver.findElement(By.xpath("//span[text()='Sign in with Google']")).click();
		
		Set<String> windowIds=driver.getWindowHandles();
		
	for(String windowId:windowIds) {
		driver.switchTo().window(windowId);
		
	}
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("kunle.adebayo93@gmail.com");
		
		
  }
}
