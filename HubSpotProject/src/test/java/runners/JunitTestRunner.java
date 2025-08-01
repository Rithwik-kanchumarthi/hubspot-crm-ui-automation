package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"stepdefinitionfiles", "hooks"},
		plugin = {"pretty", "html:target/cucumber-report.html"},
		tags = "@Test",
		monochrome = true
		)

public class JunitTestRunner 
{

}
