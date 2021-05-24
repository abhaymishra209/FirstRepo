import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class ExcelFileHandling {

	static WebDriver driver;
	static String driverPath = "S:/Software/Automation/";
	static String url = "http://the-internet.herokuapp.com/";
	static String filePath = driverPath + "/automationInput.xlsx";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try {

			FileInputStream fis = new FileInputStream(filePath);
			XSSFWorkbook book = new XSSFWorkbook(fis);
			XSSFSheet sheet = book.getSheet("Sheet1");
			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
			System.out.println(rowCount);

			for (int i = 0; i < rowCount; i++) {

				System.out.println();
				for (int j = 0; j <= 1; j++) {
					
					//check value of column
					if (sheet.getRow(i).getCell(j).getStringCellValue().equalsIgnoreCase("browser")) {
						System.out.print("browser is: " + sheet.getRow(i).getCell(j + 1).getStringCellValue());
						 break;
					}
					
					// To print excel content on console
					System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() + "  ");

				}
			}
		} catch (IOException e) {
			System.out.println("IOException Message: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception Message: " + e.getMessage());
		}

	}

	@Test
	void test() throws InterruptedException {
		// driver.get(url);
		Thread.sleep(2000);
		System.out.println("working on excel work");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.close();
	}

}
