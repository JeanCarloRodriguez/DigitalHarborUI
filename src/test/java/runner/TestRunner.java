package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(glue = {"steps"},
        features = {"src/test/resources/features"},
        plugin = {"pretty", "html:target/cucumber"})
public class TestRunner {
}