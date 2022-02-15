package com.nedigital.testcafe.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/com/nedigital/testcafe/feature",
        glue = {"stepDefinition"},
        strict = true,
        dryRun = false
)
public class TestRunner {
}
