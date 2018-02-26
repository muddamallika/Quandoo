package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class herokuApp_Tables {

	WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", "/Users/mallikamudda/eclipse-workspace/Quandoo/lib/geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/tables");
	}
	
	@Test
	public void tablesScenario_tc1() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@id='table2']/thead/tr/th/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@id='table2']/thead/tr/th/span")).click();
	    Thread.sleep(2000);
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
