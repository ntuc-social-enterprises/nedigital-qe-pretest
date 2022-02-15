package com.nedigital.testcafe.pageObject;

import com.nedigital.testcafe.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePageObject extends BaseTest {

    By yourName = By.name("name");
    By selectTriedTestCafe = By.xpath("//input[@name = 'tried-test-cafe']");
    By selectTextArea = By.xpath("//textarea[@id='comments']");
    By submitButton = By.xpath("//button[@type='submit']");
    By populateButton = By.xpath("//input[@id='populate']");
    By disableComments = By.xpath("//textarea[@disabled='disabled']");
    By disabledRateScale = By.xpath("//div[@class='ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content ui-slider-disabled ui-state-disabled']");

    public HomePageObject() {
        PageFactory.initElements(driver, this);

    }

    public void setYourName(String name) {
        WebElement e = driver.findElement(yourName);
        e.clear();
        e.sendKeys(name);
    }

    public void selectFeatures(String features) {
        WebElement e = driver.findElement(By.name(features));
        e.click();
    }

    public String getTitle() {
        webDriverWait.until(ExpectedConditions.titleIs("TestCafe Example Page"));
        return driver.getTitle();
    }

    public void chooseOs(String os) {
        WebElement e = driver.findElement(By.xpath("//*[contains(text(),'" + os + "')]"));
        e.click();
    }

    public void inputRatings(int value) {
        WebElement e = driver.findElement(By.xpath("//div[contains(text()," + value + ")]"));
        System.out.println(e);
        e.click();
    }

    public Boolean isRatingDisabled() {
        driver.findElement(disabledRateScale);
        return true;
    }

    public Boolean isDiscriptionDisabled() {
        driver.findElement(disableComments);
        return true;
    }

    public void selectTriedTestCafe(Boolean isTriedTestCafe) {
        if (isTriedTestCafe) {
            driver.findElement(selectTriedTestCafe).click();
        }
    }


    public void enterLetUsKnowWhatYouThink(String description) {
        WebElement e = driver.findElement(selectTextArea);
        e.clear();
        e.sendKeys(description);
    }

    public void clickOnSubmitButton() {
        driver.findElement(submitButton).click();
    }


}
