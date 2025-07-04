package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    private WebDriver driver;

    By hubspotLogo = By.cssSelector("a.hs-logo");

	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public void clickLogo() 
	{
		driver.findElement(hubspotLogo).click();
	}

}
