package stepDefinitions;

import core.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.CucumberReportingConfig;

public class Initializer extends Base {

	// in this class we will define before Hooks and After hooks of Cucumber
	// Before hooks will run before each scenario
	// After hooks will run after each scenario

	@Before // tags ---
	// any method or blocks of code comes under this will execute before each
	// scenario ---
	// scenario passed as an argument it is a class which will give us the status of
	// a scenario (scenario passed or failed) ---
	public void beforHooks(Scenario scenario) {

		// it will logs that which scenario started at time of execution
		logger.info("Scenariio " + scenario.getName() + " Started");
		browser(); // this method comes from Base class and will lunch browser
		openBrowser(); // this method comes from Base class and will lunch url

	}

	// any method or blocks of code comes under this will execute after each
	// scenario ----
	@After // tags coming from cucumber ---
	public void afterHooks() {

		tearDown();
		CucumberReportingConfig.reportConfig();
		logger.info("Scenario" + scenario.getName() + " " scenario.getStatus());
	}
}
