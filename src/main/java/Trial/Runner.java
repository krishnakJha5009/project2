package Trial;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "/Users/krishnakantjha/Wipro/IRCTCApp/src/main"
				+ "/java/Trial/LogInTest.feature"
		,glue={"Trial"},
		tags = "@Brands",
		dryRun = true,
		monochrome = true,
		plugin = {"pretty"}
		)

public class Runner {

}
