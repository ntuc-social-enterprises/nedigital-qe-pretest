package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import commons.InitClass;
import pageobjects.ExamplePage;
import org.junit.Assert;

public class ExampleSteps extends InitClass {

    ExamplePage ex ;

    @Given("^Launch the Application$")
    public void launch_the_Application()  throws Throwable {

        InitClass.launchApp();
    }

    @Then("^Title of the page  is displayed as Example$")
    public void title_of_the_page_is_displayed_as_Example() throws Throwable {
    ex= new ExamplePage(driver);
    ex.verifyPageTitle();
    }

    @When("^User enters the name as \"([^\"]*)\"$")
    public void user_enters_the_name_as(String name) throws Throwable {
        ex= new ExamplePage(driver);
        ex.enterName(name);

    }

    @When("^selects inputs as \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void selects_inputs_as(String feature,String os,String interfacevalue) throws Throwable {
        ex.selectFeature(feature);
        ex.selectOperatingSystem(os);
        ex.selectInterface(interfacevalue);

    }

    @When("^selects tried Testcafe,\"([^\"]*)\" ,enter comments as \"([^\"]*)\"and submit$")
    public void selects_tried_Testcafe_and_submit(String rating,String comment) throws Throwable {
        ex.selecttriedTestCafe();
        ex.selectScale(rating);
        Thread.sleep(1000);
        ex.enterComments(comment);
        ex.clickSubmit();

    }
    @When("^Don't select tried Testcafe and submit$")
    public void dont_select_tried_Testcafe_and_submit() throws Throwable {

        ex.clickSubmit();

    }
    @When("^tried Testcafe checkbox is not selected$")
    public void tried_Testcafe_checkbox_is_not_selected() throws Throwable {
       System.out.println("testcafe is not selected");
    }
    @Then("^Ratingslider and Comments are not enabled$")
    public void ratingslider_and_Comments_are_not_enabled() throws Throwable {
       boolean commentvalue=ex.isCommentEnabled();
       Assert.assertEquals(commentvalue,false);
           ex.isSliderDisabled();

    }

    @Then("^Thankyou page is  displayed with text  \"([^\"]*)\"$")
    public void thankyou_page_is_displayed_with_text(String arg1) throws Throwable {

        ex.thankYouNote.isDisplayed();

    }

    @When("^click on populate$")
    public void click_on_populate() throws Throwable {
         ex.clickPopulateButton();
    }

    @Then("^Reset Information Popup is displayed$")
    public void reset_Information_Popup_is_displayed() throws Throwable {
        ex.alertAction(true);
        InitClass.tearDown();


    }


}
