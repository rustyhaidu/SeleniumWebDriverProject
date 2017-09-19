package ro.siit.tau.gr4.reports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


public class TestListener extends TestListenerAdapter {
    private ExtentReports extentReports = new ExtentReports();

    @Override
    public void onStart(ITestContext iTestContext) {
        super.onStart(iTestContext);
        extentReports.init("extent-report.html",true);
    }


    public void onTestStart(ITestResult result) {
        String testMethodName = result.getMethod().getMethodName();
        String testDescription = result.getMethod().getDescription();
        System.out.println();
        System.out.println("START TEST " + testMethodName);

        //extentReports = ExtentReports.get(result.getTestClass().getRealClass());
        extentReports.startTest(testMethodName);
        if (testDescription != null) {
            if (!testDescription.isEmpty()) {
                System.out.println("Description: " + testDescription);
            }
        }
    }

    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("#####Start Test Custom Message for Success#####");
        String testMethodName = result.getMethod().getMethodName();
        extentReports.log(LogStatus.PASS,testMethodName);
        extentReports.endTest();
    }

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("#####Start Test Custom Message for Failure#####");
        String testMethodName = result.getMethod().getMethodName();
        extentReports.log(LogStatus.FAIL,testMethodName);
        extentReports.endTest();
    }

    @Override
    public void onTestSkipped(ITestResult result){
        System.out.println("#####Start Test Custom Message for SKIPPY#####");
        String testMethodName = result.getMethod().getMethodName();
        extentReports.log(LogStatus.SKIP,testMethodName);
        extentReports.endTest();
    }


    @Override
    public void onFinish(ITestContext iTestContext) {
        super.onFinish(iTestContext);

    }
}