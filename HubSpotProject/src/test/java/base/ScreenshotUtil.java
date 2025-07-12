package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtil 
{
	public static String captureScreenshot(String testName)
	{
	    try {
	        File src = ((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.FILE);
	        String path = "test-output/screenshots/" + testName + ".png";
	        Files.createDirectories(Paths.get("test-output/screenshots/"));
	        File dest = new File(path);
	        org.openqa.selenium.io.FileHandler.copy(src, dest);
	        return path;
	    } catch (Exception e)
	    {
	        e.printStackTrace();
	        return null;
	    }
	}
}

