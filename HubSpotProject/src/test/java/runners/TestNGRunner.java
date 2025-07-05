package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"stepdefinitionfiles", "hooks"},
		plugin = {"pretty", "html:target/cucumber-report.html"},
		tags = "@Regression",
		monochrome = true
		)

public class TestNGRunner extends AbstractTestNGCucumberTests {
}