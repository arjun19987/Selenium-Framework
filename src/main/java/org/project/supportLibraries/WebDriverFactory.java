package org.project.supportLibraries;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class WebDriverFactory {

    static Logger log = LogManager.getLogger(WebDriverFactory.class);

    public static WebDriver getWebDriver() {
        Browser browser = DriverManager.getTestParameters().getBrowser();
        WebDriver driver = null;
        try {
            if (browser != null) {
                switch (browser) {
                    case CHROME:
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        break;
                    case FIREFOX:
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        break;
                    case EDGE:
                        WebDriverManager.edgedriver().setup();
                        driver = new EdgeDriver();
                        break;
                    case SAFARI:
                        WebDriverManager.safaridriver().setup();
                        driver = new SafariDriver();
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported browser: " + browser);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return driver;
    }
}
