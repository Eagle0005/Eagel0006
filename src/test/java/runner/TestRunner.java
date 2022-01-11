
package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

// TestRunner class: it runs on top of cucumber website----

@RunWith (Cucumber.class)
@CucumberOptions ( // will provide some of the features that gonna help test cases ---
		
		// we should provide path for feature file--- // features file tells cucumber where all feature files exist
		features = "classpath:features",  
		
		// path for stepDefinitions--- // glue tells cucumber where all step definitions  classes are located
		glue = "stepDefinitions", 
				// with tags we will run one scenario, or multiple scenarios or entire feature
		tags = "@smokeTest and @test",  // we can put (comma, or , and) to add more tags--
		
		// dryRun checks if there are any missing steps in StepDefinition class for each scenario steps feature file
		dryRun = false,
		
		// monochrome will make console readable
		monochrome = true,
		
		// strict will mark scenario failed if there are any pending steps.
		strict = true,
		
		// pluging will be used for generating readable report
		plugin = {"pretty", "jason:target/cucumber-reports/CucumberTestReport.jason"},
		
		publish = true
		
		
		)

public class TestRunner {
	

}
