package com.nedigital.testcafe.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;
    public static Properties prop;
    public static WebDriverWait webDriverWait;

    public BaseTest() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +
                    "/src/main/resources/configuration.properties");
            prop.load(fis);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void initialization() {
        System.setProperty("webdriver.chrome.driver", "ChromeDriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, 30);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }

    public void closeBrowser(){
        driver.close();
    }


}
