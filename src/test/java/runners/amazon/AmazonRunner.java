package runners.amazon;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/resources/features/com.amazon",//feature file content root
        glue = "stepdefinitions/amazonsteps", //step definitions/source root.
        dryRun = false,
        tags = "@amazon",//optional
        plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}

)
public class AmazonRunner {
}
