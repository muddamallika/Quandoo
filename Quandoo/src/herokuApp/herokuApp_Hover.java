package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class herokuApp_Hover {

	public static WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", "/Users/mallikamudda/eclipse-workspace/Quandoo/lib/geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/hovers");
	}
	
	@Test(priority=1)
	public void hoverScenario_tc1() {
		Actions hoverAct = new Actions(driver);
		WebElement hoverElement = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/img"));
		hoverAct.moveToElement(hoverElement).build().perform();
		WebElement hoverData = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/h5"));
        Assert.assertTrue(hoverData.getText().contains("user1"));
        System.out.println("hover data - " + hoverData.getText());
        
        hoverElement = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/img"));
		hoverAct.moveToElement(hoverElement).build().perform();
		hoverData = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/h5"));
        Assert.assertTrue(hoverData.getText().contains("user2"));
        System.out.println("hover data - " + hoverData.getText());
        
        hoverElement = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/img"));
		hoverAct.moveToElement(hoverElement).build().perform();
		hoverData = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/h5"));
        Assert.assertTrue(hoverData.getText().contains("user3"));
        System.out.println("hover data - " + hoverData.getText());
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
