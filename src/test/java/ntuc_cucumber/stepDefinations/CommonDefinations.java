package ntuc_cucumber.stepDefinations;

import constants.Constants;
import io.cucumber.java.en.Given;
import ntuc_cucumber.TestBase;
import pageObjects.ExamplePage;
import utils.Utils;

import java.util.concurrent.TimeUnit;

public class CommonDefinations extends TestBase {

    ExamplePage exPage = new ExamplePage(driver);
    @Given("user opened {string} page")
    public void user_opened_page(String subUrl) {
        String url = Utils.getProperty("url") + subUrl;
        System.out.println(url);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Constants.impliciteWait, TimeUnit.SECONDS);
    }
}
