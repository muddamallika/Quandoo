package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class herokuApp_Login {

	public static WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", "/Users/mallikamudda/eclipse-workspace/Quandoo/lib/geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://the-internet.herokuapp.com/login");
	}
	
	@Test(priority=1)
	//TestScenario 1 - Successful Login and success message verification
	public void testScenario_1() {
		//Locate user name and password fields and send given values
		driver.findElement(By.id("username")).sendKeys("tomsmith");
	    driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
	    
	    //Locate Login button using class name and click to proceed
	    driver.findElement(By.className("radius")).click();
	    
	    //To Locate the success message and store it in a variable
	    String s_msg = driver.findElement(By.id("flash")).getText();
	    
	    //just printing to console for verification
        System.out.println(s_msg);
   
        //verifying whether the success message displayed contains the expected text
        Assert.assertTrue(s_msg.contains("You logged into a"));
        
	}
	
	@Test(priority=2)
	//TestScenario 2 - Unsuccessful Login with Invalid user name and error message verification
	public void testScenario_2() {
		//Locate user name and password fields and send given values
		driver.findElement(By.id("username")).sendKeys("Quandoo");
	    driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
	    
	    //Locate Login button using class name and click to proceed
	    driver.findElement(By.className("radius")).click();
	    
	    //To Locate the error message and store it in a variable
	    String e_msg = driver.findElement(By.id("flash")).getText();
	    
	    //just printing to console for verification
        System.out.println(e_msg);
   
        //verifying whether the error message displayed contains the expected text
        Assert.assertTrue(e_msg.contains("Your username is invalid!"));
	}
	
	@Test(priority=3)
	//TestScenario 2 - Unsuccessful Login with Invalid Password and error message verification
	public void testScenario_3() {
		//Locate user name and password fields and send given values
		driver.findElement(By.id("username")).sendKeys("tomsmith");
	    driver.findElement(By.id("password")).sendKeys("Quandoo");
	    
	    //Locate Login button using class name and click to proceed
	    driver.findElement(By.className("radius")).click();
	    
	    //To Locate the error message and store it in a variable
	    String e_msg = driver.findElement(By.id("flash")).getText();
	    
	    //just printing to console for verification
        System.out.println(e_msg);
   
        //verifying whether the error message displayed contains the expected text
        Assert.assertTrue(e_msg.contains("Your password is invalid!"));
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
	
	
}
