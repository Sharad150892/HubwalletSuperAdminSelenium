package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {".//Features/Business.feature"},
		glue={"stepDefination","myHooks"},
		dryRun=false,
		monochrome = true, tags="@SL",
		plugin= {"pretty","html:test-output"}
		)

public class Runner {
	
	
}