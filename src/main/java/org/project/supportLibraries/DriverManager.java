package org.project.supportLibraries;

import io.cucumber.java.Scenario;

public class DriverManager {

    private static ThreadLocal<SeleniumTestParameters> testParameters = new ThreadLocal<>();


    public static void setTestParameters(SeleniumTestParameters testParameters) {
        DriverManager.testParameters = testParameters;
    }

    public static SeleniumTestParameters getTestParameters() {
        SeleniumTestParameters parameters = testParameters.get();
        return parameters == null ? new SeleniumTestParameters() : parameters;
    }
}
