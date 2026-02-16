package com.project.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.project.supportLibraries.DriverManager;
import org.project.supportLibraries.Settings;

import java.util.Properties;

public class CukeHooks extends MasterStepDef {

    static Logger log = LogManager.getLogger(CukeHooks.class);
    static Properties properties = Settings.getInstance();


    @Before
    public void setUp(Scenario scenario) {
        try {
            log.debug("org.project.hooks.CukeHooks.setUp");
            currentScenario = scenario;
            currentTestParameters = DriverManager.getTestParameters();
            propertiesFile = properties;
            String scenarioName = scenario.getName();
            currentTestParameters.setScenarioName(scenarioName);
            invokeForWebExecution(scenario);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }


    private void invokeForWebExecution(Scenario scenario) {
        WebDriver driver = DriverManager.getWebDriver();
        log.info("Running the Scenario : {}", scenario.getName());
        log.info("Execution Mode : {}", currentTestParameters.getExecutionMode());
        log.info("Execution Environment : {}", currentTestParameters.getExecutionEnvironment());
        log.info("Browser : {}", currentTestParameters.getBrowser());
        log.info("Platform : {}", currentTestParameters.getPlatform());
        DriverManager.setWebDriver(driver);

    }

    @After
    private static void afterSuite(Scenario scenario) {
        try {
            WebDriver driver = DriverManager.getWebDriver();
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception ex) {
            log.error("Error in after suite: {}", ex.getMessage());
        }
    }

}
