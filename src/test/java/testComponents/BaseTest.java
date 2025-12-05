// java
package testComponents;

import org.PageObjects.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    WebDriver driver = null;
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

    @BeforeMethod
    public LandingPage launchApplication() throws Exception {
        driver = InitializeDriver();
        landingPage = new LandingPage(driver);
        landingPage.goTo();
        return landingPage;
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}