package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/customers.feature",
        glue = "stepdefinitions",
        dryRun = true,
        tags= "@Products",
        plugin = {"pretty", "html:target/test-output.html"},
        monochrome = true
)
class testRunner {
}
