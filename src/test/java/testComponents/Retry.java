package testComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    int count = 0;
    int maxTry = 2; // Run the failed test 2 times

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (count < maxTry) {
                count++;
                return true;                    // Tells TestNG to re-run the test
            }
        return false;
    }
}
