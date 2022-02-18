package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/java/feature",
            glue={"stepdefinitions"},
            strict = true,
            dryRun = false,
            plugin = { "pretty",
                    "json:target/cucumber-report/cucumber.json",
                    "html:target/cucumber-report/cucumber.html"},
            monochrome = true
    )
    public class TestRunner {
    }

