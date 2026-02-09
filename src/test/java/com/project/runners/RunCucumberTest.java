package com.project.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@LoginTest",
        features = "src/test/resources/features",
        glue = "com.project.stepdefs",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)

public class RunCucumberTest extends AbstractTestNGCucumberTests {

}
