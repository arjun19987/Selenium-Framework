package com.project.hooks;

import com.project.stepdefs.MasterStepDef;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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


    private void invokeForWebExecution(Scenario scenario){

    }

}
