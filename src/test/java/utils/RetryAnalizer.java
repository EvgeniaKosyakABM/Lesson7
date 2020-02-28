package test.java.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalizer implements IRetryAnalyzer {
    int count = 1;
    int retryCount = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(count < retryCount){
            count ++;
            return true;
        }
        return false;
    }
}
