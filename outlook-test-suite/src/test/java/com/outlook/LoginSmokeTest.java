package com.outlook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.TestCase;

public class LoginSmokeTest extends TestCase {
	
	public void testCreateAccountAndLoginPositiveScenario() {
    	System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();			
		
		String website = "https://outlook.live.com/owa/";
		driver.get(website);

        
        driver.close();
        driver.quit();
    }

}
