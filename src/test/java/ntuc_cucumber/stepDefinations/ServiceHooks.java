package ntuc_cucumber.stepDefinations;

import enums.Browsers;
import helper.LoggerHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import ntuc_cucumber.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

public class ServiceHooks {
    TestBase testBase;

    Logger log = LoggerHelper.getLogger(ServiceHooks.class);

    @Before
    public void initializeTest() {
        testBase = new TestBase();
        testBase.selectBrowser(Browsers.CHROME.name());
    }

    @After
    public void endTest(Scenario scenario) {
        if (scenario.isFailed()) {

            try {
                log.info(scenario.getName() + " is Failed");
                final byte[] screenshot = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png","fail"); // ... and embed it in
            } catch (WebDriverException e) {
                e.printStackTrace();
            }

        } else {
            try {
                log.info(scenario.getName() + " is pass");
                scenario.attach(((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES),
                        "image/png","pass");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        TestBase.driver.quit();
    }
}
