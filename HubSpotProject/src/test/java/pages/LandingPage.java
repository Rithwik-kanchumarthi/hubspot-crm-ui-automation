package pages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class represents the Landing Page of HubSpot CRM.
 * It includes interaction methods for elements like login, product dropdown, etc.
 * 
 * Author: Rithwik Kanchumarthi
 * 
 */

public class LandingPage 
{
	WebDriver driver;
	WebDriverWait wait;


    // Page Elements
    @FindBy(xpath = "//a[normalize-space()='Get free CRM']")
    WebElement freeCRMbutton;

    @FindBy(css = "input[type='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//label[contains(text(),'Please enter a valid email address.')]")
    WebElement emailError;

    @FindBy(css = "label.hs-error-msg")
    List<WebElement> requiredFieldErrors;

    @FindBy(css = ".global-nav-utility-link.cl-navLink-link.ga_nav_link.nav-utility-login")
    WebElement loginButton;

    @FindBy(id = "hs-eu-confirmation-button")
    WebElement acceptCookiesButton;

    @FindBy(css = "iframe[src*='chat']")
    WebElement chatframeele;

    @FindBy(css = "button[class*='openChat']")
    WebElement chatopenele;

    @FindBy(xpath = "//label[contains(.,'High Contrast')]/preceding-sibling::input")
    WebElement highContrast;

    @FindBy(xpath = "//a[text()='Get free CRM']")
    WebElement remainStable;

    @FindBy(xpath = "//*[contains(text(),'Please enter a valid')]")
    WebElement invalidCharError;

    @FindBy(css = "i18n-string[data-key='views.LANDING_PAGE.buttonLabel']")
    WebElement submitemailForm;

    @FindBy(tagName = "footer")
    WebElement footer;

    @FindBy(css = "footer a")
    List<WebElement> footerLinks;

	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
	}

	public void clickCRMButton() 
	{
		handleAlert();
		acceptCookiesIfPresent();
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
		WebElement clickMenu = wait.until(ExpectedConditions.elementToBeClickable(clickMenuButton));
		clickMenu.click();
	}

	public void pageRedirected(String partialUrl)
	{
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Redirected to: " + currentUrl);
		Assert.assertTrue(currentUrl.contains(partialUrl));
	}

	public void chatWidgetexpand()
	{
		WebElement chatFrame = wait.until(ExpectedConditions.visibilityOfElementLocated((By) chatframeele));
		driver.switchTo().frame(chatFrame);
		WebElement chatOpen = wait.until(ExpectedConditions.visibilityOfElementLocated((By) chatopenele));
		chatOpen.click();
		driver.switchTo().defaultContent();
	}

	public void verifyBlockByChat()
	{
		try 
		{
			WebElement getFreeCrmBtn = driver.findElement(By.xpath("//a[contains(text(),'Get free CRM')]"));
			getFreeCrmBtn.click();
			Assert.fail("The button was clickable even though the chat should be blocking it.");
		} 
		catch (org.openqa.selenium.ElementClickInterceptedException e) 
		{
			System.out.println("Verified: 'Get free CRM' button was not clickable due to the chat overlay.");
			Assert.assertTrue(true);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			Assert.fail("Unexpected error while verifying button block by chat.");
		}
	}
	
	public void highContrast()
	{
		WebElement toggle = wait.until(ExpectedConditions.elementToBeClickable(highContrast));
		if (!toggle.isSelected())
		{
			toggle.click();
		}
	}

	public void remainStable()
	{
		WebElement getFreeCrm = wait.until(ExpectedConditions.visibilityOfElementLocated((By) remainStable));
		assert getFreeCrm.isDisplayed();
	}

	public void emojiInFirstName()
	{
		WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));
		firstName.sendKeys("😊🚀");
	}

	public void scrollAndClickFreeCrm()
	{
		handleAlert();
		acceptCookiesIfPresent();
		try 
		{
			WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated((By) freeCRMbutton));
			((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
			wait.until(ExpectedConditions.elementToBeClickable(button)).click();
			System.out.println("Clicked 'Get free CRM' button successfully.");
		} 
		catch (Exception e) 
		{
			System.out.println("Failed to click 'Get free CRM' button: " + e.getMessage());
		}
	}

	public void scrollToFooter() 
	{
		WebElement footerVar = wait.until(ExpectedConditions.visibilityOfElementLocated((By) footer));
		((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footerVar);
	}
	
	public void footerLinks() 
	{
		handleAlert();
		acceptCookiesIfPresent();
		List<WebElement> footerLinksVar = driver.findElements((By) footerLinks);
		for (WebElement link : footerLinksVar) 
		{
			if (link.isDisplayed()) 
			{
				System.out.println("Displayed: " + link.getText());
				Assert.assertTrue(link.isDisplayed());
			}
		}
	}
	
	public void validateFooterLinks() 
	{
		List<WebElement> footerLinksVar = driver.findElements((By) footerLinks);
		for (WebElement link : footerLinksVar) 
		{
			String href = link.getAttribute("href");
			if (href != null && !href.isEmpty()) 
			{
				System.out.println("Valid link: " + href);
			} else {
				System.out.println("Broken/missing href for: " + link.getText());
			}
		}
	}
	
	public void emailButtonDisabled() 
	{
		WebElement submitEmail = wait.until(ExpectedConditions.elementToBeClickable(submitemailForm));
		Assert.assertFalse(submitEmail.isEnabled());
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
