package pages;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoFormPage
{
    WebDriver driver;
    WebDriverWait explicitWait;

    By firstName = By.name("firstname");
    By lastName = By.name("lastname");
    By email = By.name("email");
    By phone = By.name("phone");
    By company = By.name("company");
    By website = By.name("website");
    By employees = By.name("employees__c");
    By headquarters = By.name("country_dropdown");
    By submitButton = By.cssSelector("input[type='submit']");
    By errorMsgs = By.cssSelector(".hs-error-msg");
    By emailErrorelement = By.cssSelector(".hs-error-msg.hs-main-font-element");

    public DemoFormPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void fillForm(String fn, String ln, String em, String ph, String co, String we, String emp, String hq) 
    {
        driver.findElement(firstName).sendKeys(fn);
        driver.findElement(lastName).sendKeys(ln);
        driver.findElement(email).sendKeys(em);
        driver.findElement(phone).sendKeys(ph);
        driver.findElement(company).sendKeys(co);
        driver.findElement(website).sendKeys(we);
        driver.findElement(employees).sendKeys(emp);
        driver.findElement(headquarters).sendKeys(hq);
    }
    
    public void employeesDropdown()
    {
    	 WebElement dropdownElement1 = driver.findElement(employees);
         Select dropdown = new Select(dropdownElement1);
         dropdown.selectByVisibleText("1");
    }
    
    public void headquartersDropdown()
    {
    	 WebElement dropdownElement2 = driver.findElement(headquarters);
         Select dropdown = new Select(dropdownElement2);
         dropdown.selectByVisibleText("India");
    }

    public void submit()
    {
        driver.findElement(submitButton).click();
    }

    public boolean confirmationDisplayed() 
    {
        return driver.getPageSource().contains("Thank you") || driver.getCurrentUrl().contains("thank-you");
    }
    
    public void submitWithMissingFields() 
    {
    	submit();
    }

    public boolean isRequiredFieldErrorDisplayed()
    {
        List<WebElement> errors = driver.findElements(errorMsgs);
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(errors));
        return errors.stream().anyMatch(WebElement::isDisplayed);
    }

    public void fillFormWithInvalidEmail()
    {
    	driver.findElement(firstName).sendKeys("Rithwik Venkatesh");
        driver.findElement(lastName).sendKeys("Kanchumarthi");
        driver.findElement(email).sendKeys("1@g.com");
        driver.findElement(phone).sendKeys("6303864339");
        driver.findElement(company).sendKeys("TCS");
        driver.findElement(website).sendKeys("http://tcs.com");
        driver.findElement(employees).sendKeys("1");
        driver.findElement(headquarters).sendKeys("India");
    	submit();
    }

    public boolean isEmailErrorDisplayed() 
    {
        WebElement emailError = driver.findElement(emailErrorelement);
        explicitWait.until(ExpectedConditions.visibilityOf(emailError));
        return emailError.isDisplayed();
    }

}