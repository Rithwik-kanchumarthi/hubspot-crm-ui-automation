package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"stepdefinitionfiles", "hooks"},
		plugin = {"pretty",
				"html:target/cucumber-report.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		tags = "@Test",
		monochrome = true
		)

public class TestNGRunner extends AbstractTestNGCucumberTests
{
	
}