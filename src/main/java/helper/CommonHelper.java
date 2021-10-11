package helper;

import constants.Constants;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;


public class CommonHelper {
    Logger logger = LoggerHelper.getLogger(CommonHelper.class);

    private WebDriver driver;
    //WebDriverWait wait = new WebDriverWait(driver, Constants.timeOut);
    WaitHelper wait;
    public CommonHelper(WebDriver driver){
        this.driver = driver;
    }
    public void pageRefresh() {
        driver.navigate().refresh();
    }

/*
    public void waitForVisibality(WebElement we) {
        wait.until(ExpectedConditions.visibilityOfAllElements(we));
    }*/

    public void screenShot(String fileName) {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkElementExists(WebElement ele){
        wait.WaitForElement(ele, Constants.timeOut);
        return ele.isDisplayed();
    }
}
