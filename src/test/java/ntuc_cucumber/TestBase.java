package ntuc_cucumber;

import helper.CommonHelper;
import helper.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import enums.Browsers;
import enums.OS;
public class TestBase {
    public  static WebDriver driver;
    WaitHelper waitHelper = new WaitHelper(driver);
    CommonHelper commonHelper = new CommonHelper(driver);

    public WebDriver selectBrowser(String browser) {
        if (System.getProperty("os.name").toLowerCase().contains(OS.WINDOW.name().toLowerCase())) {
            if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/driver/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }
        }
        return driver;
    }
}
