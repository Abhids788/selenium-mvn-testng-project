// java
package testComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.PageObjects.LandingPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    WebDriver driver = null;
    ExtentReports extent;
    public LandingPage landingPage = null;

    public WebDriver InitializeDriver(String browserName) throws Exception {
        // If TestNG didn't provide a browser, fall back to properties file

        if (browserName == null || browserName.isBlank()) {
            browserName= System.getProperty("browser");
        }

        if (browserName == null || browserName.isBlank()) {
            throw new IllegalStateException("Property `browser` is missing and no TestNG parameter was provided");
        }

        browserName = browserName.trim().toLowerCase();

        try {
            switch (browserName) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browserName);
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize WebDriver for browser: " + browserName, e);
        }
        return driver;
    }

    public String getScreenshot(String testCaseName, WebDriver driver) throws Exception {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(System.getProperty("user.dir") + "\\reports\\ScreenShots\\" + testCaseName + ".png");
        FileUtils.copyFile(source, destinationFile);
        return System.getProperty("user.dir") + "\\reports\\ScreenShots\\" + testCaseName + ".png";
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser", "envUrl"})
    public LandingPage launchApplication(@Optional String browser, @Optional String envUrl) throws Exception {
        driver = InitializeDriver(browser);
        landingPage = new LandingPage(driver);
        landingPage.goTo(envUrl);
        return landingPage;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}