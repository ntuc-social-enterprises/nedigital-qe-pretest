const { Given, When, Then } = require('@cucumber/cucumber');
const { expect } = require('chai');
const common = require('../../../cucumberframework/utils/common.js');
const ObjRep = require('../../objects/feedback');
const scope = require('../../../cucumberframework/utils/hooks.js');
let { setDefaultTimeout } = require('@cucumber/cucumber');
setDefaultTimeout(common.OBJECT_TIMEOUT_MS);
const setWaitForObject = 2 * 1000;

Then(
    'ClickButton {string}', async (buttonName) => {
      await page.click('text=' + buttonName);
    }
  );
 Given('Feedback page opened',async() => {
    let page_title = await page.title();
    expect(page_title).to.be.equal('TestCafe Example Page');
    
 });
 When('Enter Feedback Details', async (table) => {
    var dataVals = table.hashes();
    global.FBname = dataVals[0].name;
    //Handle dialog when click on Populate
    page.on('dialog', async dialog => {
        console.log(dialog.message());
        await dialog.accept();
    });
    await page.click(ObjRep.POPULATE);
    //Enter Name
    await page.fill(ObjRep.NAME, FBname);
    //Select OS
    if (dataVals[0].OS!= "")
        await page.click(common.getLocator(ObjRep.OS,dataVals[0].OS));
    //Select Features
    let features = (dataVals[0].features).split("#");
    for (let each of features) {
        let feature_id = "";
        switch(each) {
            case 'remote':
                feature_id = "remote-testing";
                break;
            case 'jsreuse':
                feature_id = "reusing-js-code";
                break;
            case 'backgroundtests':
                feature_id = "background-parallel-testing";
                break;
            case 'CI':
                feature_id = "continuous-integration-embedding";
                break;
            case 'analysis':
                feature_id = "traffic-markup-analysis";
                break;
            default:
                console.log(`No features selected`);
                
        }
        if (feature_id != "")
            await common.selectCheckBoxes("true",common.getLocator(ObjRep.FEATURE,feature_id));
    }
    //Select TestCafe Interface
    if (dataVals[0].interface!= "")
        await page.selectOption(ObjRep.INTERFACE, { label: dataVals[0].interface });
    //Selct If Tried TestCafe
    if (dataVals[0].testcafe_tried!= "")
        await common.selectCheckBoxes(dataVals[0].testcafe_tried,ObjRep.TRIED_CHECKBOX);
    //Select Rating
    if (dataVals[0].rating!= ""){
        for (let i=1; i<dataVals[0].rating; i++) {
            await page.press(ObjRep.SLIDER, 'Control+ArrowRight');
        }
    }
    //Enter comments
    if (dataVals[0].comments!= "")
        await page.fill(ObjRep.COMMENTS,dataVals[0].comments);
 });
 Then('Feedback Submitted Successfully',async() => {
    let confirm_message = await page.innerText(ObjRep.CONFIRMATION);
    expect(confirm_message).to.be.equal(`Thank you, ${FBname}!`);
    
 });
