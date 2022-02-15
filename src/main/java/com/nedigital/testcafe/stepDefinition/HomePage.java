package com.nedigital.testcafe.stepDefinition;

import com.nedigital.testcafe.base.BaseTest;
import com.nedigital.testcafe.pageObject.HomePageObject;
import com.nedigital.testcafe.pageObject.ThankYouPageObject;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BaseTest {
    HomePageObject homePage = new HomePageObject();
    ThankYouPageObject thankYouPage = new ThankYouPageObject();


    @Given("^Open chrome browser and navigate to homepage$")
    public void open_chrome_browser_and_navigate_to_homepage() {
        BaseTest.initialization();
    }

    @When("^I am on homepage specify following details \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void i_am_on_homepage_specify_following_details(String name, String feature, String os, String triedTc, int rateScale, String description) throws Throwable {
        Assert.assertTrue(webDriverWait.until(ExpectedConditions.titleIs("TestCafe Example Page")));
        homePage.setYourName(name);
        homePage.selectFeatures(feature);
        homePage.chooseOs(os);
        homePage.selectTriedTestCafe(Boolean.parseBoolean(triedTc));
        homePage.inputRatings(rateScale);
        homePage.enterLetUsKnowWhatYouThink(description);
        homePage.clickOnSubmitButton();
    }


    @Then("^Submit should be successful \"([^\"]*)\"$")
    public void submit_should_be_successful(String expected) throws Throwable {
        Assert.assertEquals(expected, thankYouPage.getText());
        closeBrowser();
    }


    @When("^I am on homepage specify following details \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void i_am_on_homepage_specify_following_details(String name, String feature, String os, String triedTc) {
        homePage.setYourName(name);
        homePage.selectFeatures(feature);
        homePage.chooseOs(os);
        homePage.selectTriedTestCafe(Boolean.parseBoolean(triedTc));
    }

    @Then("^Description and rate scale should be greyed$")
    public void description_and_rate_scale_should_be_greyed() {
        Assert.assertTrue(homePage.isRatingDisabled());
        Assert.assertTrue(homePage.isDiscriptionDisabled());
        closeBrowser();

    }

}
