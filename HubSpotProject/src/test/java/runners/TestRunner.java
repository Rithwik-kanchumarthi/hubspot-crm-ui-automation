package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/features",
		glue = {"stepdefinitionfiles", "hooks"},
		plugin = {"pretty", "html:target/cucumber-report.html"},
		tags = "@regression",
		monochrome = true
		)

public class TestRunner extends AbstractTestNGCucumberTests {
}