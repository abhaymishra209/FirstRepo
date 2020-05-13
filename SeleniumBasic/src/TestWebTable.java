import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWebTable {

	static WebDriver driver;

	public static void main(String[] args) {
		//
		System.setProperty("webdriver.chrome.driver", "S:/Software/Automation/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		java.util.List<WebElement> rowNum = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));

		System.out.println("Total rows are : " + rowNum.size());

		java.util.List<WebElement> colNum = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td"));

		System.out.println("Total cols are : " + colNum.size());

		for (int rows = 1; rows <= rowNum.size(); rows++) {

			for (int cols = 1; cols <= colNum.size(); cols++) {

				System.out.print(driver
						.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[" + rows + "]/td[" + cols + "]"))
						.getText() + "   ");
			}

			System.out.println("test");
		}

		driver.close();
	}

}
