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
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    WebDriver driver = null;
    ExtentReports extent;
    public LandingPage landingPage=null;

    public WebDriver InitializeDriver() throws Exception {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/org/resources/Global.properties")) {
            prop.load(fis);
        }

        String browserName = prop.getProperty("browser");
        if (browserName == null || browserName.isBlank()) {
            throw new IllegalStateException("Property `browser` is missing in `src/main/java/org/resources/Global.properties`");
        }

        // Sanitize the value: remove surrounding quotes and whitespace
        browserName = browserName.replaceAll("^['\"]+|['\"]+$", "").trim().toLowerCase();

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
        TakesScreenshot ts=(TakesScreenshot)driver;
        File source= ts.getScreenshotAs(OutputType.FILE);
        File destinationFile=new File(System.getProperty("user.dir")+"\\reports\\ScreenShots\\"+testCaseName+".png");
        FileUtils.copyFile(source,destinationFile);
        return System.getProperty("user.dir")+"\\reports\\ScreenShots\\"+testCaseName+".png";
    }

    @BeforeMethod(alwaysRun = true)
    public LandingPage launchApplication() throws Exception {
        driver = InitializeDriver();
        landingPage = new LandingPage(driver);
        landingPage.goTo();
        return landingPage;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

//    @BeforeTest(alwaysRun = true)
//    public  void setUp() {
//        String path =System.getProperty("user.dir")+"\\reports\\extentReport\\index.html";
//        ExtentSparkReporter reporter= new ExtentSparkReporter(path);
//        reporter.config().setReportName("Web Automation Results");
//        reporter.config().setDocumentTitle("Test Results");
//
//        extent= new ExtentReports();
//        extent.attachReporter(reporter);
//        extent.setSystemInfo("Tester", "Abhijit Das");
//    }
}