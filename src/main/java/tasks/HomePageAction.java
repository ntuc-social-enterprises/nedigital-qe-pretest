package tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pageobjects.HomePage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotEnabled;

public class HomePageAction {
	
	public static Performable launchApplication() {
		return Task.where("Opens the application", Open.browserOn().the(HomePage.class));
	}
	
	public static Performable verifyText(String text) {
		return Task.where("Verify Text as Example in the home page", 
				WaitUntil.the(HomePage.TXT_EXAMPLE, isVisible()),
				Ensure.thatTheCurrentPage().title().isEqualTo("TestCafe Example Page"),
				Ensure.that(HomePage.TXT_EXAMPLE).text().isEqualTo(text));
	}
	
	public static Performable setName(String name) {
		return Task.where("Set Name - "+name, 
				WaitUntil.the(HomePage.TXT_NAME, isVisible()),
				Enter.theValue(name).into(HomePage.TXT_NAME));
	}
	
	public static Performable selectOS(String os) {
		return Task.where("Select OS - "+os, 
				Click.on(HomePage.select_OS(os)).afterWaitingUntilPresent());
	}
	
	public static Performable clickSubmit() {
		return Task.where("Click Submit button", 
				WaitUntil.the(HomePage.BTN_SUBMIT, isEnabled()),
				Click.on(HomePage.BTN_SUBMIT));
	}
	
	public static Performable selectFeature() {
		return Task.where("Select all the features", 
				Click.on(HomePage.CHK_REMOTE_DEVICES),
				Click.on(HomePage.CHK_JAVASCRIPT_CODE),
				Click.on(HomePage.CHK_MULTIPE_BROWSERS),
				Click.on(HomePage.CHK_EASY_EMBEDDING),
				Click.on(HomePage.CHK_ADVANCED_TRAFFIC));
	}
	
	public static Performable selectInterface(String valuee) {
		return Task.where("Select Interface", 
			    SelectFromOptions.byVisibleText(valuee).from(HomePage.SELECT_INTERFACE));
			
	}
	
	public static Performable selectTestcafe() {
		return Task.where("Select tried Testcafe option", Click.on(HomePage.CHK_TESTCAFE));
	}
	
	public static Performable setComments(String comment) {
		return Task.where("Set Comments - "+comment, 
				WaitUntil.the(HomePage.TXT_COMMENTS, isVisible()),
				Enter.theValue(comment).into(HomePage.TXT_COMMENTS));
	}

	public static Performable verifyThankyou(String text) {
		return Task.where("Verify the text as Thank You", 
				WaitUntil.the(HomePage.TXT_THANKYOU, isVisible()),
				Ensure.thatTheCurrentPage().title().isEqualTo("Thank you!"),
				Ensure.that(HomePage.TXT_THANKYOU).text().isEqualTo(text));
	}
	
	public static Performable verifySubmitDisabled() {
		return Task.where("Verify Submit button Disabled",
				WaitUntil.the(HomePage.BTN_SUBMIT, isVisible()),
				Ensure.that(HomePage.BTN_SUBMIT).isDisabled());
	}
	
	public static Performable clickPopulate() {
		return Task.where("Click Populate button", 
				WaitUntil.the(HomePage.BTN_POPULATE, isEnabled()),
				Click.on(HomePage.BTN_POPULATE));

	}
	
	public static Performable verifyPopup() {
		return Task.where("Verify Popup message", 
				WaitUntil.the(HomePage.BTN_OK, isEnabled()),
				Click.on(HomePage.BTN_OK));
	}
	
}
