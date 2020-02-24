package com.outlook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestHelper {
	
	public boolean isElementPresent(WebDriver driver, By locatorKey) {
        try {
            driver.findElement(locatorKey);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
        catch (org.openqa.selenium.ElementNotVisibleException e) {
            return false;
        }
    }

}
