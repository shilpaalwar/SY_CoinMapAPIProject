package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (monochrome = true,
dryRun = false,
plugin = {"pretty", "json:target/cucmber-json-report.json",
		"html:target/cucmber.html", "summary"},
features = {"src/test/resources/features/" },
glue = "stepdefs")

public class TestRunner extends AbstractTestNGCucumberTests {

}
