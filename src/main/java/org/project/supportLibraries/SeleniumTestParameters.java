package org.project.supportLibraries;

import org.openqa.selenium.Platform;

public class SeleniumTestParameters {
    private ExecutionMode executionMode;
    private Browser browser;
    private Platform platform;
    private String executionEnvironment;
    private String scenarioName;

    /**
     * Method to get the execution mode for the test.
     * This will determine how the test is executed (e.g., local, on Jenkins, on a Selenium Grid, or on a mobile device).
     * @return execution mode for the test
     */
    public ExecutionMode getExecutionMode() {
        return executionMode;
    }

    /**
     * Method to set the execution mode for the test.
     * This will determine how the test is executed (e.g., local, on Jenkins, on a Selenium Grid, or on a mobile device).
     * @param executionMode for the test (e.g., local, jenkins, grid, mobile)
     */
    public void setExecutionMode(ExecutionMode executionMode) {
        this.executionMode = executionMode;
    }

    /**
     * Method to get the browser for the test.
     * This will determine which browser the test will run on (e.g., Chrome, Firefox, Edge, Safari).
     * @return browser for the test
     */
    public Browser getBrowser() {
        return browser;
    }

    /**
     * Method to set the browser for the test.
     * This will determine which browser the test will run on (e.g., Chrome, Firefox, Edge, Safari).
     * @param browser for the test
     */
    public void setBrowser(Browser browser) {
        this.browser = browser;
    }

    /**
     * Method to get the platform for the test.
     * This will determine which platform the test will run on (e.g., Windows, macOS, Linux).
     * @return platform for the test
     */
    public Platform getPlatform() {
        return platform;
    }

    /**
     * Method to set the platform for the test.
     * This will determine which platform the test will run on (e.g., Windows, macOS, Linux).
     * @param platform for the test
     */
    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    /**
     * Method to get the execution environment for the test.
     * This will determine the specific environment where the test will be executed (e.g., Integration, Staging).
     * @return execution environment for the test
     */
    public String getExecutionEnvironment() {
        return executionEnvironment;
    }

    /**
     * Method to set the execution environment for the test.
     * This will determine the specific environment where the test will be executed (e.g., Integration, Staging).
     * @param executionEnvironment for the test
     */
    public void setExecutionEnvironment(String executionEnvironment) {
        this.executionEnvironment = executionEnvironment;
    }

    /**
     * Method to get the scenario name for the test.
     * This will determine the name of the scenario being executed, which can be useful for logging and reporting purposes.
     * @return scenario name for the test
     */
    public String getScenarioName() {
        return scenarioName;
    }

    /**
     * Method to set the scenario name for the test.
     * This will determine the name of the scenario being executed, which can be useful for logging and reporting purposes.
     * @param scenarioName for the test
     */
    public void setScenarioName(String scenarioName) {
        this.scenarioName = scenarioName;
    }
}
