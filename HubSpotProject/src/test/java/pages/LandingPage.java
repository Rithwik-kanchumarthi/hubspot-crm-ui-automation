package pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage 
{
    private WebDriver driver;

    By freeCRMbutton = By.xpath("//a[@rel='noreferrer ']");

	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public void clickCRMButton() 
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement crmButton = wait.until(ExpectedConditions.elementToBeClickable(freeCRMbutton));
		crmButton.click();
	}
	
}
