import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

class ConfigurationDemo {

	static WebDriver driver;
	static String browser="ie";
	static String driverPath="S:/Software/Automation/";
	static String url = "http://the-internet.herokuapp.com/";
	static String expectedTitle="The Internet";
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("BeforeAll");
		//System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		//driver = new ChromeDriver();
				
		if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver",driverPath+"IEDriverServer.exe");
			driver = new InternetExplorerDriver();
				}
		else{
			throw new Exception("Browser is not correct");
		}		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get(url);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("AfterAll  method");
		driver.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("BeforeEach  method");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("AfterEach  method");
	}

	@Test
	void test1() throws InterruptedException {
		//Thread.sleep(5000);
		System.out.println("Test1  method");
		
		String actualTitle= driver.getTitle();
		System.out.println(actualTitle);
		
		Assert.assertEquals(expectedTitle, actualTitle);
		System.out.println("test1 pass");
		
	}
	@Test
	void test2() {
		System.out.println("Test2 method");
		System.out.println(driver.findElement(By.linkText("Checkboxes")).getCssValue("font-size"));
	}

}
