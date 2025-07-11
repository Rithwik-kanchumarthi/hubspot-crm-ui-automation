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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage 
{
	WebDriver driver;
	WebDriverWait wait;

	By freeCRMbutton = By.xpath("//a[normalize-space()='Get free CRM']");
	By submitButton = By.cssSelector("input[type='submit']");
	By emailError = By.xpath("//label[contains(text(),'Please enter a valid email address.')]");
	By requiredFieldErrors = By.cssSelector("label.hs-error-msg");
	By loginButton = By.cssSelector(".global-nav-utility-link.cl-navLink-link.ga_nav_link.nav-utility-login");
	By acceptCookiesButton = By.id("hs-eu-confirmation-button");
	By chatframeele = By.cssSelector("iframe[src*='chat']");
	By chatopenele = By.cssSelector("button[class*='openChat']");
	By highContrast = By.xpath("//label[contains(.,'High Contrast')]/preceding-sibling::input");
	By remainStable = By.xpath("//a[text()='Get free CRM']");
	By invalidCharError = By.xpath("//*[contains(text(),'Please enter a valid')]");
	By submitemailForm = By.cssSelector("i18n-string[data-key='views.LANDING_PAGE.buttonLabel']");
	By footer = By.tagName("footer");
	By footerLinks = By.cssSelector("footer a");

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
		WebElement chatFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(chatframeele));
		driver.switchTo().frame(chatFrame);
		WebElement chatOpen = wait.until(ExpectedConditions.visibilityOfElementLocated(chatopenele));
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
		WebElement getFreeCrm = wait.until(ExpectedConditions.visibilityOfElementLocated(remainStable));
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
			WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(freeCRMbutton));
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
		WebElement footerVar = wait.until(ExpectedConditions.visibilityOfElementLocated(footer));
		((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footerVar);
	}
	
	public void footerLinks() 
	{
		List<WebElement> footerLinksVar = driver.findElements(footerLinks);
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
		List<WebElement> footerLinksVar = driver.findElements(footerLinks);
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
