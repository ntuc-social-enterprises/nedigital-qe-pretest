package stepdefinitions;

import java.awt.Robot;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;
import pageobjects.HomePage;
import tasks.HomePageAction;

public class HomePageStepDefinition {
	
private static Logger logger = LoggerFactory.getLogger(HomePageStepDefinition.class);
    
    Actor actor;
    
	private EnvironmentVariables environmentVariables;
	
	@Managed
	WebDriver browser;
    
	@Before
	public void setTheStage() {
    	String webBaseUrl = EnvironmentSpecificConfiguration.from(environmentVariables)
				.getProperty("webdriver.base.url");
		OnStage.setTheStage(OnlineCast.whereEveryoneCan(CallAnApi.at(webBaseUrl)));
		actor = Actor.named("James").whoCan(CallAnApi.at(webBaseUrl))
    			.whoCan(BrowseTheWeb.with(browser));
	}
	
    @After
	public void drawTheCurtain() {
		OnStage.drawTheCurtain();
	}
    
    @When("{actor} opens the TestCafe application")
	public void actorAccessTheApplication(Actor actor) {
		actor.wasAbleTo(HomePageAction.launchApplication());
		logger.info("Opened the Application");
	}
    
    @When("{actor} verify the title and text on the screen is displayed as {string}")
	public void actorVerifyText(Actor actor, String text) {
		actor.attemptsTo(HomePageAction.verifyText(text));
	}
    
    @When("{actor} enter the name in the testcafe webpage {string}")
	public void actorEnterName(Actor actor, String text) {
		actor.attemptsTo(HomePageAction.setName(text));
	}
    
    @When("{actor} select primary operating system as {string}")
	public void actorSelectOS(Actor actor, String os) {
		actor.attemptsTo(HomePageAction.selectOS(os));
	}
    
    @When("{actor} select all features")
   	public void actorSelectsall(Actor actor) {
   		actor.attemptsTo(HomePageAction.selectFeature());
   	}
       
    @When("{actor} select the Interface as {string}")
   	public void actorSelectInterface(Actor actor, String value) {
   		actor.attemptsTo(HomePageAction.selectInterface(value));
   	}
    
    @When("{actor} select tried Testcafe")
   	public void actorSelectTestcafe(Actor actor) {
   		actor.attemptsTo(HomePageAction.selectTestcafe());
   	}
    
    @When("{actor} select the rating scale of testcafe as {int}")
   	public void actorSelectRate(Actor actor, int rating) {
    	for(int i=1;i<rating;i++)
        	actor.attemptsTo(Hit.the(Keys.ARROW_RIGHT).into(HomePage.IMG_SLIDER));
   	}
  
    @When("{actor} enter his comments on the tutorials page {string}")
	public void actorEnterComments(Actor actor, String text) {
		actor.attemptsTo(HomePageAction.setComments(text));
	}
    
 	 @When("{actor} click on the submit button") 
	 public void actorClickSubmitButton(Actor actor) {
	  actor.attemptsTo(HomePageAction.clickSubmit()); 
	 }
 	 
 	@When("{actor} verify the page redirects with text displayed as {string}")
	public void actorVerifyThankYouScreen(Actor actor, String text) {
		actor.attemptsTo(HomePageAction.verifyThankyou(text));
	}
 	
    @When("{actor} verify submit is disabled when name is not entered") 
	 public void actorSubmitDisabled(Actor actor) {
	  actor.attemptsTo(HomePageAction.verifySubmitDisabled()); 
	 }
    
	 @When("{actor} click on Populate button next to name") 
	 public void actorClickPopulateButton(Actor actor) throws InterruptedException {
	  actor.attemptsTo(HomePageAction.clickPopulate());
	 }
	 
	 @When("{actor} verify the popup message with ok button") 
	 public void actorVerifyPopupOk(Actor actor) {
	  Actions a=new Actions(Serenity.getDriver());
	  a.sendKeys(Keys.ENTER);
	 }
 }


