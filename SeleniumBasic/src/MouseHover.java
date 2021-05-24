import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseHover {

	static WebDriver driver;
	static String driverPath = "S:/Software/Automation/";
	static String url = "http://the-internet.herokuapp.com/hovers";

	public static void main(String[] args) {
		//
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		driver = new ChromeDriver();

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);

		WebElement image2 = driver.findElement(By.xpath("//div[@id='content']/div/div[2]"));
		WebElement profile2 = driver.findElement(By.xpath("//div[@id='content']/div/div[2]/div/a"));

		WebDriverWait wait = new WebDriverWait(driver, 10); // Explicit wait
		wait.until(ExpectedConditions.visibilityOf(image2));

		Actions action = new Actions(driver);
		action.moveToElement(image2).moveToElement(profile2).click().build().perform();

		System.out.println(driver.getCurrentUrl());
		driver.close();
	}
}
