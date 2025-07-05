package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class DemoFormPage
{
    WebDriver driver;

    By firstName = By.name("firstname");
    By lastName = By.name("lastname");
    By email = By.name("email");
    By phone = By.name("phone");
    By company = By.name("company");
    By website = By.name("website");
    By employees = By.name("employees__c");
    By headquarters = By.name("country_dropdown");
    By submitButton = By.cssSelector("input[type='submit']");

    public DemoFormPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void fillForm(String fn, String ln, String em, String ph, String co, String we, String emp, String hq) {
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

    public boolean confirmationDisplayed() {
        return driver.getPageSource().contains("Thank you") || driver.getCurrentUrl().contains("thank-you");
    }
}