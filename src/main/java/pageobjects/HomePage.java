package pageobjects;

import org.openqa.selenium.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class HomePage extends PageObject {
	
	public static final Target TXT_EXAMPLE = Target.the("Example").located(By.xpath("//h1[contains(text(),'Example')]"));
	
	public static final Target TXT_NAME = Target.the("Your Name text box").located(By.id("developer-name"));
	public static final Target TXT_COMMENTS = Target.the("Please let us know what you think")
			.located(By.id("comments"));
					
	public static final Target BTN_SUBMIT = Target.the("Submit button").located(By.id("submit-button"));
	
	public static final String BTN_OK = "#OK";
	
	public static final Target BTN_POPULATE = Target.the("Populate button").located(By.id("populate"));
			
	public static final Target CHK_REMOTE_DEVICES = Target.the("Support for Testing on remote devices")
			.located(By.id("remote-testing"));
	public static final Target CHK_JAVASCRIPT_CODE = Target.the("Re-using exiting Javascript code")
			.located(By.id("reusing-js-code"));
	public static final Target CHK_MULTIPE_BROWSERS = Target.the("Running tests in backgroud")
			.located(By.id("background-parallel-testing"));
	public static final Target CHK_EASY_EMBEDDING = Target.the("Easy embedding into CI system")
			.located(By.id("continuous-integration-embedding"));
	public static final Target CHK_ADVANCED_TRAFFIC = Target.the("Advanced traffic and markup analysis")
			.located(By.id("traffic-markup-analysis"));
	public static final Target CHK_TESTCAFE = Target.the("Have tried TestCafe")
			.located(By.id("tried-test-cafe"));
	
	public static final Target select_OS(String os) {
		String locator = String.format("//label[.='%s']", os);
		return Target.the("Select OS - "+os).located(By.xpath(locator));
	}
	
	public static final Target SELECT_INTERFACE = Target.the("Select the Interface")
				.located(By.id("preferred-interface"));
	
	public static final Target CLICK_RATE = Target.the("Click the rating").located(By.xpath("//div[@class='slider-value']"));
	public static final Target IMG_SLIDER = Target.the("Slider").located(By.xpath("//div[@id='slider']/span"));

	public static final Target TXT_THANKYOU = Target.the("Thank you").located(By.xpath("//h1[contains(text(),'Thank you')]"));

}
	

	

