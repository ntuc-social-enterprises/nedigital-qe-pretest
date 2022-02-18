
package pageobjects;


import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ExamplePage {

    WebDriver driver;

    @FindBy(xpath = "//input[@id='developer-name']")
    public WebElement yourNameTextBox;

    @FindBy(xpath = "//input[@id='populate']")
    public WebElement populateButton;

    @FindBy(xpath = "//input[@id='tried-test-cafe']")
    public WebElement triedTestCafeCheckbox;

    @FindBy(xpath = "//select[@id='preferred-interface']")
    public WebElement interfaceDropdown;

    @FindBy(xpath = "//textarea[@id='comments']")
    public WebElement commentbox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;

    @FindBy(xpath = "//*[@id='article-header']")
    public WebElement thankYouNote;

    @FindBy(xpath = "//*[@id='slider']/span")
    public WebElement slider;

    @FindBy(xpath = "//h1[text()='Example']")
    public WebElement headerText;

       @FindBy(xpath = "//div[@class='ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content ui-slider-disabled ui-state-disabled']")
    public WebElement sliderdisabled;


    public ExamplePage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void verifyPageTitle() {
        Assert.assertTrue("title is displayed as expected", headerText.isDisplayed());

    }

    public void enterName(String name) {
        yourNameTextBox.sendKeys(name);

    }

    public void selectFeature(String feature) throws InterruptedException {

        driver.findElement(By.xpath("//input[@type='checkbox' and @name = '" + feature + "']")).click();


    }

    public void selectOperatingSystem(String os) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='radio' and @id='" + os + "']")).click();

    }

    public void selectInterface(String value) {
        Select select = new Select(interfaceDropdown);
        select.selectByVisibleText(value);
    }

    public void selecttriedTestCafe() {
        triedTestCafeCheckbox.click();
    }

    public void selectRating(int rating) {

        driver.findElement(By.xpath("//div[contains(text()," + rating + ")]\"")).click();

    }
    public void selectScale(String val) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        float percent = (Float.valueOf(val)/10)*100;
        String arg = "arguments[0].setAttribute('style', 'left: "+ Float.toString(percent) +"%;')";
        js.executeScript(arg,slider);
        Thread.sleep(300);
    }

    public void enterComments(String comment) {
        commentbox.sendKeys(comment);
    }

    public void clickSubmit() {
        submit.click();
    }

    public void verifyThankYouPage() {
        thankYouNote.getText();

    }

    public void clickPopulateButton() {
        populateButton.click();
    }

    public boolean isCommentEnabled() {
        return commentbox.isEnabled();
    }

    public void isSliderDisabled() {
       sliderdisabled.isDisplayed();
    }



    public void alertAction(boolean alert) {
        try {
            String alertMessage = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();

        } catch (Exception e) {

           e.getStackTrace();
        }
    }
}
