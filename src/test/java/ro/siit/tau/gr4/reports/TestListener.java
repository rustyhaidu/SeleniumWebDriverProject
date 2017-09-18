package ro.siit.tau.gr4.reports;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.lang.reflect.Method;

public class TestListener extends TestListenerAdapter {

    public void onTestStart(ITestResult result) {
        String testMethodName = result.getMethod().getMethodName();
        String testDescription = result.getMethod().getDescription();
        System.out.println();
        System.out.println("START TEST " + testMethodName);
        if (testDescription != null) {
            if (!testDescription.isEmpty()) {
                System.out.println("Description: " + testDescription);
            }
        }
    }

    @Override
    public void onTestSuccess(ITestResult result){

    }

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("#####Start Test Custom Message for Failure#####");
    }

    @Override
    public void onTestSkipped(ITestResult result){
        System.out.println("#####Start Test Custom Message for SKIPPY#####");
    }
}