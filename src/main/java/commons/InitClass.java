package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class InitClass {

    static Properties properties;
    protected static WebDriver driver;
    public static WebDriverWait webDriverWait;

    public  static void  readProperties() throws IOException {

        properties = new Properties();

        try {
            FileInputStream input = new FileInputStream("src/main//resources/config.properties");
            properties.load(input);

        }


        catch (FileNotFoundException e) {

            e.printStackTrace();
        }
    }

    public static  String getObject(String Data) throws IOException
    {
        readProperties();
        String data=properties.getProperty(Data);
        return data;
    }

    public static void launchApp() throws IOException {
        String path=getObject("path");
        System. setProperty("webdriver.chrome.driver",path);
        if(driver==null)
        {
            driver=new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, 30);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.get(properties.getProperty("url"));
    }


    public static void tearDown(){
        driver.close();

    }



}
