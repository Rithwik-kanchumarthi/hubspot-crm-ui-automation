package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	    protected static WebDriver driver;

	    public static void initializeDriver() 
	    {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	    }

	    public static void quitDriver() 
	    {
	        if (driver != null) {
	            driver.quit();
	        }
	    }

	    public static WebDriver getDriver() 
	    {
	        return driver;
	    }	

}
