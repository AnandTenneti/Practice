package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".//features/customers.feature",
        glue = "stepdefinitions",
        dryRun = true,
        plugin = {"pretty", "html:target/test-output.html"},
        monochrome = true
)
class testRunner {
}
