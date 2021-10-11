package pageObjects;

import appElements.ExamplePageElements;
import helper.CommonHelper;
import helper.LoggerHelper;
import helper.WaitHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ExamplePage {
    Logger log = LoggerHelper.getLogger(ExamplePage.class);

    private WebDriver driver;
    ExamplePageElements elements = new ExamplePageElements();
    String a  = ExamplePageElements.Xpath.h1Text;

    @FindBy(xpath="//input[@id='developer-name']")
    public WebElement yourNameInputBox;

    @FindBy(xpath = "//input[@type='button' and @id='populate']")
    public WebElement populateButton;

    @FindBy(xpath = "//input[@id='tried-test-cafe']")
    public WebElement triedTestCafeChkbox;

    @FindBy(xpath = "//select[@id='preferred-interface']")
    public WebElement interfaceDropdown;

    @FindBy(xpath = "//textarea[@id='comments']")
    public WebElement comment;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;

    @FindBy(xpath = "//*[@id='article-header']")
    public WebElement thankYouNote;

    @FindBy(xpath = "//*[@id='slider']/span")
    public WebElement slider;

    WaitHelper waitHelper;
    CommonHelper commonHelper;

    public ExamplePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        //waitHelper.WaitForElement(userName, 60);
    }

    public String getHeaderText(String ele){
        String text = null;
        try {
           text = driver.findElement(By.xpath(ExamplePageElements.Xpath.h1Text.replace("[Name]", ele))).getText();
        }catch (ElementNotVisibleException e){
            log.error(String.format("Webelement {0} not exists", ele));
        }
        return text;
    }

    public boolean checkNameInputboxExists(){
       // System.out.println(webElement.getAttribute("id"));
        waitHelper.WaitForElement(yourNameInputBox);
        return yourNameInputBox.isDisplayed();
       // return commonHelper.checkElementExists(webElement);
    }

    public void enterName(String name){
        yourNameInputBox.sendKeys(name);
    }

    public void clickPopulateButton(){
        populateButton.click();
    }

    public boolean checkAlert(){
        boolean flag=false;
        try {
            String alertMessage= driver.switchTo().alert().getText(); // capture alert message
            log.info("Alert message after clicking populate button " + alertMessage);
            flag = true;
        }catch (Exception e){
            log.error(e.getMessage() + e.getLocalizedMessage());
            log.trace(e.getStackTrace());
        }
        return flag;
    }

    public void alertAction(boolean alert){
        try {
            String alertMessage= driver.switchTo().alert().getText(); // capture alert message
            log.info("Alert message after clicking populate button " + alertMessage);
            if(alert) {
                driver.switchTo().alert().accept();
            }else{
                driver.switchTo().alert().dismiss();
            }
        }catch (Exception e){
            log.error(e.getMessage() + e.getLocalizedMessage());
            log.trace(e.getStackTrace());
        }
    }


    public void checkFeatureCheckbox(String featureName){
        System.out.println(ExamplePageElements.Xpath
                .featuresCheckbox.replace("[Name]", featureName));
        driver.findElement(By.xpath(ExamplePageElements.Xpath
                .featuresCheckbox.replace("[Name]", featureName))).click();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectOSRadioButton(String osName){
        driver.findElement(By.xpath(ExamplePageElements.Xpath
                .osRadioButton.replace("[Name]", osName))).click();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void selectInterface(String value){
        Select select = new Select(interfaceDropdown);
        select.selectByVisibleText(value);
    }

    public void triedCheckbox(){
        triedTestCafeChkbox.click();
    }

    public boolean isCommentEnabled(){
        return comment.isEnabled();
    }

    public void selectScale(String val) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        float perct = (Float.valueOf(val)/10)*100;
        String arg = "arguments[0].setAttribute('style', 'left: "+ Float.toString(perct) +"%;')";
        js.executeScript(arg,slider);
        Thread.sleep(300);
    }

    public void enterComments(String text){
        comment.sendKeys(text);
    }

    public void clickSubmitButton(){
        submit.click();
    }

    public String getThankYouText(){
        return thankYouNote.getText();
    }
}
