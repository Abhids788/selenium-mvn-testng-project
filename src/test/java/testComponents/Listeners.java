// java
package testComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.resources.ExtentReporterNG;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.reflect.Field;

public class Listeners implements ITestListener {
    ExtentTest test;
    private ExtentReports reportObject = ExtentReporterNG.getReportObject();
    private ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = reportObject.createTest(result.getMethod().getMethodName());
        testThread.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        testThread.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = testThread.get();
        test.log(Status.FAIL, result.getThrowable());

        Object instance = result.getInstance();
        WebDriver driver = null;

        try {
            if (instance instanceof BaseTest) {
                // preferred, safe access
                driver = ((BaseTest) instance).driver;
            } else {
                // fallback: try to find 'driver' in class hierarchy
                Class<?> cls = result.getTestClass().getRealClass();
                Field driverField = null;
                while (cls != null && driverField == null) {
                    try {
                        driverField = cls.getDeclaredField("driver");
                    } catch (NoSuchFieldException e) {
                        cls = cls.getSuperclass();
                    }
                }
                if (driverField != null) {
                    driverField.setAccessible(true);
                    driver = (WebDriver) driverField.get(instance);
                }
            }

            if (driver != null) {
                String path = ((BaseTest) result.getInstance()).getScreenshot(result.getMethod().getMethodName(), driver);
                test.addScreenCaptureFromPath(path, result.getMethod().getMethodName());
            } else {
                test.info("WebDriver not available; skipping screenshot");
            }
        } catch (Exception e) {
            // log to report but do NOT rethrow — prevent stopping the suite
            test.warning("Failed to capture/attach screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        testThread.get().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // no-op
    }

    @Override
    public void onStart(ITestContext context) {
        // no-op
    }

    @Override
    public void onFinish(ITestContext context) {
        reportObject.flush();
    }
}
