package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/Features",
    glue = {"stepDefinition"},
    // Below tags will run Activity1 to Activity 5 at once
    tags = "@activity1 or @activity2 or @activity3 or @activity4 or @activity5 or @activity6",
    //tags = "@SmokeTest", // Run separately for Activity 6
    plugin = {"pretty"},
    //plugin = {"html: test-reports"}, // Run separately for Activity 6
    monochrome = true
)

public class ActivitiesRunner {

}
