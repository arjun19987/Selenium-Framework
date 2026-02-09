package org.project.supportLibraries;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.xml.XmlTest;

import java.util.Properties;

// This class is a TestNG listener that listens for method invocations during test execution.
// It is user to store test parameters in the SeleniumTestParameters class before the test method is invoked,
// and to perform any necessary cleanup after the test method is executed.

public class WebDriverListener implements IInvokedMethodListener {
    static Logger log = LogManager.getLogger(WebDriverListener.class);
    private static final Properties properties = Settings.getInstance();

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        log.debug("BEGINNING: org.project.supportLibraries.WebDriverListener.beforeInvocation");
        SeleniumTestParameters testParameters = new SeleniumTestParameters();
        if (method.isTestMethod() || method.isConfigurationMethod()) {
            try {
                setDefaultTestParameters(method, testParameters);
                DriverManager.setTestParameters(testParameters);
            } catch (Exception ex) {
                log.error("Error setting test parameters {}", ex.getMessage());
            }

        } else {
            log.warn("Provide method is not a TestNG method !!!");
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        log.debug("ENDING: org.project.supportLibraries.WebDriverListener.afterInvocation");
    }

    private void setDefaultTestParameters(IInvokedMethod method, SeleniumTestParameters testParameters) {
        try {
            XmlTest xmlTest = null;
            if (method.isTestMethod()) {
                xmlTest = method.getTestMethod().getXmlTest();
            } else if (method.isConfigurationMethod()) {
                xmlTest = method.getTestMethod().getTestClass().getXmlTest();
            }
            if (xmlTest == null) {
                log.warn("Unable to set default parameters.Provided method is not a TestNG method.");
                return;
            }
            String executionMode = xmlTest.getLocalParameters().get("ExecutionMode");
            String executionEnvironment = !StringUtils.isEmpty(System.getenv("ExecutionEnvironment"))
                    ? System.getenv("ExecutionEnvironment")
                    : xmlTest.getLocalParameters().get("ExecutionEnvironment");
            String browser = xmlTest.getLocalParameters().get("BrowserName");
            String platform = xmlTest.getLocalParameters().get("Platform");

            testParameters.setExecutionEnvironment(executionEnvironment);

            if (platform != null) {
                testParameters.setPlatform(Platform.valueOf(platform.toUpperCase()));
            } else {
                testParameters.setPlatform(Platform.valueOf(properties.getProperty("DefaultPlatform").toUpperCase()));
            }

            switch (executionMode.toLowerCase()) {
                case "local":
                case "jenkins":
                    testParameters.setExecutionMode(ExecutionMode.valueOf(executionMode.toUpperCase()));
                    if (!StringUtils.isEmpty(browser)) {
                        testParameters.setBrowser(Browser.valueOf(browser.toUpperCase()));
                    } else {
                        testParameters.setBrowser(Browser.valueOf(properties.getProperty("DefaultBrowser").toUpperCase()));
                    }
                    break;
                case "grid":
                    testParameters.setExecutionMode(ExecutionMode.GRID);
                    break;
                case "mobile":
                    testParameters.setExecutionMode(ExecutionMode.MOBILE);
                    break;
                default:
                    testParameters.setExecutionMode(ExecutionMode.valueOf(properties.getProperty("DefaultExecutionMode").toUpperCase()));
                    if (!StringUtils.isEmpty(browser)) {
                        testParameters.setBrowser(Browser.valueOf(browser.toUpperCase()));
                    } else {
                        testParameters.setBrowser(Browser.valueOf(properties.getProperty("DefaultBrowser").toUpperCase()));
                    }
            }
        } catch (Exception ex) {
            log.error("Error getting test parameters" + ex.getMessage());
        }
    }

}
