package com.project.stepdefs;

import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.project.supportLibraries.SeleniumTestParameters;
import org.testng.Assert;

import java.util.Properties;

public class MasterStepDef {
    static Logger log = LogManager.getLogger(MasterStepDef.class);

    protected static Scenario currentScenario;
    protected static SeleniumTestParameters currentTestParameters;
    protected static Properties propertiesFile;


    /**
     * Method to log a message and fail the test with the provided message.
     * @param msg the message to log and use for failing the test
     */
    public void fail(String msg) {
        log.error(msg);
        Assert.fail(msg);
    }
}
