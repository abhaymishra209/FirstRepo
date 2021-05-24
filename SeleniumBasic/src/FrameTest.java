import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

class FrameTest {

	static WebDriver driver;
	static String driverPath="S:/Software/Automation/";
	static String url = "http://the-internet.herokuapp.com/";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("BeforeAll method");
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);

	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("BeforeEach  method");
		driver.navigate().to(url);
		Thread.sleep(2000);
	}

	@Test
	void iFrameTest() throws InterruptedException {
		// Thread.sleep(5000);
		driver.findElement(By.linkText("Frames")).click();
		driver.findElement(By.linkText("iFrame")).click();
		System.out.println("frame counts = " + driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame("mce_0_ifr");
		driver.findElement(By.xpath("//body[@id='tinymce']/p")).clear();
		driver.findElement(By.xpath("//body[@id='tinymce']/p")).sendKeys("Hii");
		Thread.sleep(5000);

		driver.switchTo().parentFrame();
	}

	@Test
	void nestedFrameTest() {
		driver.findElement(By.linkText("Frames")).click();
		driver.findElement(By.linkText("Nested Frames")).click();
		System.out.println("frame counts = " + driver.findElements(By.tagName("iframe")).size());
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("AfterAll  method");
		driver.close();
	}

}
