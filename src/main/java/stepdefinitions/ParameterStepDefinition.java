package stepdefinitions;

import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

public class ParameterStepDefinition {
	
	@ParameterType(".*")
	public Actor actor(String actor) {
		return OnStage.theActorCalled(actor);
	}
}
