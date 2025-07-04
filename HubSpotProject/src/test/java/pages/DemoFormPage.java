package pages;

import org.openqa.selenium.*;

public class DemoFormPage
{
    WebDriver driver;

    By firstName = By.name("firstname");
    By lastName = By.name("lastname");
    By email = By.name("email");
    By phone = By.name("phone");
    By company = By.name("company");
    By submitButton = By.cssSelector("input[type='submit']");

    public DemoFormPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void fillForm(String fn, String ln, String em, String ph, String co) {
        driver.findElement(firstName).sendKeys(fn);
        driver.findElement(lastName).sendKeys(ln);
        driver.findElement(email).sendKeys(em);
        driver.findElement(phone).sendKeys(ph);
        driver.findElement(company).sendKeys(co);
    }

    public void submit()
    {
        driver.findElement(submitButton).click();
    }

    public boolean confirmationDisplayed() {
        return driver.getPageSource().contains("Thank you") || driver.getCurrentUrl().contains("thank-you");
    }
}