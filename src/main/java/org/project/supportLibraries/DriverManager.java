package org.project.supportLibraries;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class DriverManager {

    private static ThreadLocal<SeleniumTestParameters> testParameters = new ThreadLocal<>();
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
    protected static int timeout = Integer.parseInt(Settings.getProperty("Timeout"));


    public static void setTestParameters(SeleniumTestParameters testParameters) {
        DriverManager.testParameters.set(testParameters);
    }

    public static SeleniumTestParameters getTestParameters() {
        SeleniumTestParameters parameters = testParameters.get();
        return parameters == null ? new SeleniumTestParameters() : parameters;
    }

    public static WebDriver getWebDriver() {
        if (webDriver.get() == null) {
            setWebDriver(WebDriverFactory.getWebDriver());
        }
        return webDriver.get();
    }

    public static void setWebDriver(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
        DriverManager.webDriver.set(driver);
    }
}
