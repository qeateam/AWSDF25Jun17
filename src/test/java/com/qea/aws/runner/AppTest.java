package com.qea.aws.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

//TODO - import globalobjects

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"}, glue = {"com.qea.aws.tests", "com.qea.aws.utils"}, dryRun = false)
public class AppTest {
	@BeforeClass
	public static void setup(){
		
	}
}