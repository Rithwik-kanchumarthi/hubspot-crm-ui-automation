package pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage 
{
    WebDriver driver;
    WebDriverWait wait;

    By freeCRMbutton = By.xpath("//a[@rel='noreferrer ']");
    By submitButton = By.cssSelector("input[type='submit']");
    By emailError = By.xpath("//label[contains(text(),'Please enter a valid email address.')]");
    By requiredFieldErrors = By.cssSelector("label.hs-error-msg");
    By loginButton = By.cssSelector(".global-nav-utility-link.cl-navLink-link.ga_nav_link.nav-utility-login");
    By acceptCookiesButton = By.id("hs-eu-confirmation-button");
    
    
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
	}

	public void clickCRMButton() 
	{
		WebElement crmButton = wait.until(ExpectedConditions.elementToBeClickable(freeCRMbutton));
		crmButton.click();
	}
	
	public void clickLogin() throws InterruptedException 
	{
		handleAlert();
		acceptCookiesIfPresent();
		WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginBtn);
	}
	
	public void clickDropdown(String dropDownName) 
	{
		handleAlert();
		acceptCookiesIfPresent();
		By dropDownButton = By.xpath("//span[@class='global-nav-tab-title cl-navLink-link ga_nav_link' and text()='" + dropDownName + "']");
		WebElement dropDown = wait.until(ExpectedConditions.elementToBeClickable(dropDownButton));
		dropDown.click();
	}
	
	public void dropDownisEnabled(String dropDownName)
	{
		handleAlert();
		acceptCookiesIfPresent();
		By dropDownButton = By.xpath("//span[@class='global-nav-tab-title cl-navLink-link ga_nav_link' and text()='" + dropDownName + "']");
		WebElement dropDown = wait.until(ExpectedConditions.elementToBeClickable(dropDownButton));
		dropDown.click();
		boolean dropDownSelect = dropDown.isEnabled();
		Assert.assertTrue(dropDownSelect);
	}
	
	public void clickMenu(String menuButton)
	{
		handleAlert();
		acceptCookiesIfPresent();
		By clickMenuButton = By.xpath("(//li//a[@data-ga_nav_tree_text='" + menuButton + "'])[1]");
		//li[@class="global-nav-main-products-hub-list-item "]//a[@data-ga_nav_tree_text="Marketing Hub"]
		WebElement clickMenu = wait.until(ExpectedConditions.elementToBeClickable(clickMenuButton));
        clickMenu.click();
	}
	
	public void pageRedirected(String partialUrl)
	{
		String currentUrl = driver.getCurrentUrl();
	    System.out.println("Redirected to: " + currentUrl);
	    Assert.assertTrue(currentUrl.contains(partialUrl));
	}

    public void submitForm()
    {
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submit.click();
    }
    
    //handling the alert on the landing page
    public void handleAlert()
    {
    	try 
    	{
    	    Alert alert = driver.switchTo().alert();
    	    wait.until(ExpectedConditions.alertIsPresent());
    	    System.out.println("Alert detected: " + alert.getText());
    	    alert.dismiss();
    	}
    	catch (NoAlertPresentException e) 
    	{
    	    System.out.println("No alert present");
    	}
    }

    public void acceptCookiesIfPresent()
    {
        try 
        {
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));
            cookieButton.click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("hs-eu-cookie-confirmation-buttons-area")));
        } 
        catch (TimeoutException e) 
        {
            System.out.println("No cookie banner displayed.");
        }
    }
   

}
