package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features/customers.feature",
        glue = "stepdefinitions",
        tags = "@Regression",
        plugin = {"pretty",
                "html:target/cucumber-Report.html", "json:target/report.json"},
        monochrome = true
)
public class TestNgRunner extends AbstractTestNGCucumberTests {
}
