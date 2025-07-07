package pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage 
{
    private WebDriver driver;
    WebDriverWait wait;
    
    String dropDownName;

    By freeCRMbutton = By.xpath("//a[@rel='noreferrer ']");
    By submitButton = By.cssSelector("input[type='submit']");
    By emailError = By.xpath("//label[contains(text(),'Please enter a valid email address.')]");
    By requiredFieldErrors = By.cssSelector("label.hs-error-msg");
    By loginButton = By.cssSelector(".global-nav-utility-link.cl-navLink-link.ga_nav_link.nav-utility-login");
    By dropDownButton = By.xpath("//span[@class='global-nav-tab-title cl-navLink-link ga_nav_link' and text()='" + dropDownName + "']");
    
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 15);
	}

	public void clickCRMButton() 
	{
		WebElement crmButton = wait.until(ExpectedConditions.elementToBeClickable(freeCRMbutton));
		crmButton.click();
	}
	
	public void clickLogin() throws InterruptedException 
	{
		WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginBtn);
	}
	
	public void clickDropdown() 
	{
		WebElement dropDown = wait.until(ExpectedConditions.elementToBeClickable(dropDownButton));
		dropDown.click();
	}
	
	public void dropDownisSelected()
	{
		WebElement dropDown = wait.until(ExpectedConditions.elementToBeClickable(dropDownButton));
		boolean dropDownSelect = dropDown.isSelected();
		Assert.assertTrue(dropDownSelect);
	}

    public void submitForm()
    {
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submit.click();
    }
   

}
