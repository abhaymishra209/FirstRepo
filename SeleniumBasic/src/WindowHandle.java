import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WindowHandle {

	static WebDriver driver;
	static String expectedTitle = "The Internet";
	static String driverPath = "S:/Software/Automation/";
	static String url = "http://the-internet.herokuapp.com/";
	static int temp = 0;
	static String msg = null;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.findElement(By.linkText("Multiple Windows")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Click Here")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Number of opened windows: " + windowHandles.size());

		for (String window : windowHandles) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			System.out.println("actual title: " + title);

			// check whether the url post switch is the desired page
			if (title.equals(expectedTitle)) {
				temp = 1;
				msg = "Window found.";
				break;
			} else {
				temp = 0;
				msg = "Window not found.";
			}
		}

		if (temp == 0) {
			System.out.println(msg);
		} else {
			System.out.println(msg);
		}

		driver.quit();
	}

}
