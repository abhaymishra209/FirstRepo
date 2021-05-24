import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

class simpleWebInteractionsDemo {

	static WebDriver driver;
	static String driverPath="S:/Software/Automation/";
	static String url = "http://the-internet.herokuapp.com/";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	
	@BeforeEach
	void setUp() throws Exception {
		driver.navigate().to(url);
		Thread.sleep(2000);
	}

	@Test
	void checkboxTest() throws InterruptedException {
		driver.findElement(By.linkText("Checkboxes")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//form/input[1]")).click();
		Thread.sleep(5000);
	}

	@Test
	void dropDownTest() throws InterruptedException {
		driver.findElement(By.linkText("Dropdown")).click();
		Thread.sleep(2000);

		Select select = new Select(driver.findElement(By.id("dropdown")));
		//select.selectByVisibleText("Option 2");
		select.selectByValue("1");
		//select.selectByIndex(1);
		//select.deselectAll();
		Thread.sleep(5000);		
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.close();
	}
	

}
