package ntuc_cucumber.stepDefinations;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import ntuc_cucumber.TestBase;
import pageObjects.ExamplePage;

import java.util.List;
import java.util.Map;

public class CreateProfile extends TestBase {

    ExamplePage exPage = new ExamplePage(driver);

    @Then("Enter user name and feedback")
    public void enterUserNameAndFeedback(DataTable dt) throws InterruptedException {
        List<Map<String, String>> map = dt.asMaps();
        System.out.println("Enter name");
        System.out.println(map.get(0).get("name"));
        //Enter name
        exPage.enterName(map.get(0).get("name"));

        //Select features
        String[] fet = map.get(0).get("features").split("#");
        for(int i=0;i<fet.length;i++){
            System.out.println(fet[i]);
            exPage.checkFeatureCheckbox(fet[i]);
        }

        //Select OS
        exPage.selectOSRadioButton(map.get(0).get("os"));

        //select interfaces
        exPage.selectInterface(map.get(0).get("interface"));

        //Select checkbox
        if (map.get(0).get("testcafeTried").toLowerCase().contains("not")){
            if(exPage.triedTestCafeChkbox.isSelected()){
                exPage.triedTestCafeChkbox.click();
            }
        }else{
            exPage.triedTestCafeChkbox.click();
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            exPage.selectScale(map.get(0).get("rating"));
            exPage.enterComments(map.get(0).get("comments"));
        }


    }


}
