package com.nedigital.testcafe.pageObject;


import com.nedigital.testcafe.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ThankYouPageObject extends BaseTest {
    By h1Text = By.xpath("//h1");

    public ThankYouPageObject() {
        PageFactory.initElements(driver, this);
    }

    public String getText() {
        WebElement e = driver.findElement(h1Text);
        webDriverWait.until(ExpectedConditions.visibilityOf(e));
        return e.getText();
    }
}
