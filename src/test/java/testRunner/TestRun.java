package testRunner;

 import cucumber.api.CucumberOptions;
	import cucumber.api.junit.Cucumber;
	import org.junit.runner.RunWith;

	@RunWith(Cucumber.class)
	@CucumberOptions 
	       (
	    	features="src/test/resources/features",
	    	glue="stepDefinations",
	        dryRun = false,
	    	monochrome=true,
	        plugin = {"pretty", "html:target/site/cucumber-pretty", "json:build/cucumber- test.json", "junit:build/cucumber.xml"},
	        tags= {"@sanity, @regression"})
	    			
			
	public class TestRun {
		

	}


