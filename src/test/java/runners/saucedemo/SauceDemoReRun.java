package runners.saucedemo;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="@target/uiFailedTests.txt",//feature file content root
        glue = "stepdefinitions/saucedemosteps", //step definitions/source root.
        dryRun = false,
        plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}


)
public class SauceDemoReRun {

}
