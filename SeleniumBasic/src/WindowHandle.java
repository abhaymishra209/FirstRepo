import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	static WebDriver driver;
	static String expectedTitle = "The Internet";
	static String driverPath = "S:/Software/Automation/";
	static String url = "http://the-internet.herokuapp.com/";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.findElement(By.linkText("Multiple Windows")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Click Here")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Number of opened windows: " + windowHandles.size());

		Integer temp = 0;
		String msg = null;

		for (String string : windowHandles) {
			driver.switchTo().window(string);
			String title = driver.getTitle();

			// check whether the url post switch is the desired page
			if (!title.equals("The Internet")) {
				temp = 1;
				msg = "Window found.";
				break;
			} else {
				temp = 0;
			}
		}

		if (temp == 1) {

			System.out.println(msg);

			// Find some element from the switched page to verify that the switch is
			// succsefull
			WebElement Bankname = driver.findElement(By.xpath("/html/body/div/span[1]"));
			System.out.println(Bankname.getText() + " Bank");
		} else if (temp == 0) {
			System.out.println("Desired Window not found.");
		}

	}

}
