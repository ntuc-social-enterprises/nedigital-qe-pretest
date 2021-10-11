package ntuc_cucumber.stepDefinations;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ntuc_cucumber.TestBase;
import pageObjects.ExamplePage;
import static org.junit.Assert.*;


public class CheckOpenedPage extends TestBase {

    ExamplePage exPage = new ExamplePage(driver);

    @Then("{string} input box {string} exists")
    public void verify_input_box_exists(String element, String isExists){
        boolean result = false;
         //if(element.toLowerCase().equals("name")) {
             result = exPage.checkNameInputboxExists();
         //}

        if (isExists.toLowerCase().equals("is")){
            assertTrue(result);
         }else{
            assertFalse(result);
         }
     }
     @When("user Enters {string} name")
     public void user_Enters_name(String name){
         exPage.enterName(name);
     }
     @Then("I am selecting {string} feature")
     public void i_am_selecting_feature_checkbox(String value){
        exPage.checkFeatureCheckbox(value);
     }
     @Then("I am selecting {string} Operating System")
     public void i_am_selecting_os(String osName){
        exPage.selectOSRadioButton(osName);
     }

     @Then("I am selecting {string} interface")
    public void i_am_selecting_interface_dropdown(String value){
        exPage.selectInterface(value);
     }

     @When("I am clicking on submit button")
    public void i_am_clicking_submit_button(){
        exPage.clickSubmitButton();
     }
     @Then("I get thank you {string}")
     public void thankyou_note(String name){
        String exp = "Thank you, " + name +"!";
        assertEquals(exPage.getThankYouText(), exp);
     }

     @When("I have {string} TestCafe")
    public void i_have_tried_testCafe(String value){
        if (value.toLowerCase().contains("not")){
            if(exPage.triedTestCafeChkbox.isSelected()){
                exPage.triedTestCafeChkbox.click();
            }
        }else{
            exPage.triedTestCafeChkbox.click();
        }
     }

    @Then("I see comments is {string}")
    public void is_comment_enabled(String isEnabled){
        if(isEnabled.toLowerCase().equals("enabled")){
            assertTrue(exPage.isCommentEnabled());
        }else{
            assertFalse(exPage.isCommentEnabled());
        }
    }

    @Then("I rate TestCafe as {string}")
    public void i_rate_testCafe(String val){
        try {
            exPage.selectScale(val);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("I enter comment as {string}")
    public void i_enter_comment(String comment){
        exPage.enterComments(comment);
    }

    @When("I click Populate button")
    public void i_click_populate_button(){
        exPage.clickPopulateButton();
    }

    @Then("I should get alert message")
    public void get_alert_msg(){
        assertTrue(exPage.checkAlert());
    }

    @Then("I {string} alert")
    public void i_click_on_alert(String action){
        if(action.toLowerCase().contains("cancel")){
            exPage.alertAction(false);
        }else{
            exPage.alertAction(true);
        }
    }

}
