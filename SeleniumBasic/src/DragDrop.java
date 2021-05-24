import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDrop {

	static WebDriver driver;
	static String expectedTitle = "The Internet";
	static String driverPath = "S:/Software/Automation/";
	static String url = "http://the-internet.herokuapp.com/";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Drag and Drop")).click();
		Thread.sleep(2000);

		WebElement sourceEle = driver.findElement(By.id("column-a"));
		WebElement destinationEle = driver.findElement(By.id("column-b"));
		System.out.println(driver.findElement(By.xpath("//div[@id='column-a']/header")).getText());
		Actions action = new Actions(driver);
		action.dragAndDrop(destinationEle, sourceEle).perform();    //not working
		//action.clickAndHold(sourceEle).moveToElement(destinationEle).perform();
		System.out.println("drag and droped");
		Thread.sleep(2000);
		driver.close();

	}

}
