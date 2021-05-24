import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

class AlertPopUpDemo {

	static WebDriver driver;
	static String driverPath = "S:/Software/Automation/";
	static String url = "http://the-internet.herokuapp.com/javascript_alerts";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	void alertAccept() throws InterruptedException {
		driver.get(url);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='content']/div/ul/li[1]/button")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println("alert text: " + alert.getText());
		Thread.sleep(2000);
		alert.accept();
	}

	@Test
	void alertDismis() throws InterruptedException {
		driver.get(url);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='content']/div/ul/li[2]/button")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println("alert text: " + alert.getText());
		Thread.sleep(2000);
		alert.dismiss();
	}

	@Test
	void alertInput() throws InterruptedException {
		driver.get(url);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='content']/div/ul/li[3]/button")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("hello alert");   //not working 
		System.out.println("alert text: " + alert.getText());		
		System.out.println("done");		
		Thread.sleep(5000);
		alert.accept();
		
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.close();
	}
	

}
