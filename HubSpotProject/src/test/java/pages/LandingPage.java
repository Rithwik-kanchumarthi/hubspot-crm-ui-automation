package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    private WebDriver driver;

    By freeCRMbutton = By.cssSelector(".cl-button.-primary.-medium.wf-page-header__cta.freecrm-hero");

	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public void clickCRMButton() 
	{
		driver.findElement(freeCRMbutton).click();
	}

}
