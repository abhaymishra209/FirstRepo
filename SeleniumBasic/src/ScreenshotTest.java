import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

class ScreenshotTest {

	static WebDriver driver;
	static String driverPath = "S:/Software/Automation/";
	static String url = "http://the-internet.herokuapp.com/";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	}

	@Test
	void test() throws IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy_HH-mm-ss.SSS");
		String image_timestamp = sdf.format(new Date());
		String imageName = driverPath + image_timestamp + ".png";

		// Typecast the driver reference variable with TakesScreenshot for access the
		// methods from TakesScreenshot interface
		// getScreenshotAs method will take arguement for the output type of the file
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Using the FileUtils or Files class copy the generated screenshot file to any
		// location with time as name
		Files.copy(scrFile, new File(imageName));
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {

		driver.quit();
	}

}
