package com.outlook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.TestCase;

public class LoginSmokeTest extends TestCase {
	
	TestHelper helper = new TestHelper();
	
	public void testCreateAccountAndLoginPositiveScenario() throws InterruptedException {
		String email = "sparktestsuite@outlook.com";
		String password = "testSuitePassword1!";
		
    	System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();
		
		String website = "https://outlook.live.com/owa/";
		driver.get(website);
		
		//Click button for logging in
		driver.findElement(By.xpath("//nav[@class='auxiliary-actions']//a[@class='internal sign-in-link']")).click();
		Thread.sleep(200);
		
		//Check if there is a button for creating a new account
		assertTrue(helper.isElementPresent(driver, By.id("signup")));
		
		//Insert email and click next
		driver.findElement(By.id("i0116")).sendKeys(email);
		driver.findElement(By.id("idSIButton9")).click();	
		Thread.sleep(1000);
		
		//Check if there is a text with the email inserted before
		assertTrue(helper.isElementPresent(driver, By.id("displayName")));
		assertEquals(email,  driver.findElement(By.id("displayName")).getText());
		
		//Check if there is a link for forgotten password
		assertTrue(helper.isElementPresent(driver, By.id("idA_PWD_ForgotPassword")));
		//Insert password and click next
		driver.findElement(By.id("i0118")).sendKeys(password);
		driver.findElement(By.id("idSIButton9")).click();
		Thread.sleep(200);
		
		//Check if new message button is present, then end test
		assertTrue(helper.isElementPresent(driver, By.id("id__3")));
        
        driver.close();
        driver.quit();
    }
	
	

}
