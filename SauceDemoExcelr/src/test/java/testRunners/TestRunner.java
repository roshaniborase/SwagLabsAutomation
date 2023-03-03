package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= "./src/test/resources/Feature" , glue= {"StepDefinition"},
plugin= {"pretty","json:target/jsonReport/Cucumber.json",
		"junit:target/xmlReport/Cucumber.xml",
		"html:target/htmlReort/cucumber.html"}, monochrome=true 
)
public class TestRunner {
	
}
