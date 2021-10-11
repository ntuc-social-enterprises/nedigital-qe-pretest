package ntuc_cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/ntuc_cucumber",
        glue = {"ntuc_cucumber/stepDefinations"},
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-pretty.html"}
)
public class RunCucumberTest {

}
