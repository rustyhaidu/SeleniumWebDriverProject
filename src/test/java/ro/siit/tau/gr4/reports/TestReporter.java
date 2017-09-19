package ro.siit.tau.gr4.reports;

import com.relevantcodes.extentreports.ExtentReports;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.io.*;
import java.util.List;
import java.util.Map;


public class TestReporter implements IReporter {

    public void generateReport(List<XmlSuite> xml, List<ISuite> suites, String outDir) {

        int passed = 0, failed = 0, skipped = 0, total = 0;/* Iterate over each suite */
        for (ISuite suite : suites) {   /* Get all results from the current suite */
            Map<String, ISuiteResult> suiteResults = suite.getResults();
            for (ISuiteResult sr : suiteResults.values()) {
                ITestContext tc = sr.getTestContext();      /* Get all test methods */
                for (ITestNGMethod n : tc.getAllTestMethods()) {
                    total++;
                }      /* Get all passed test scenarios */
                for (ITestResult r : tc.getPassedTests().getAllResults()) {
                    passed++;
                }      /* Get all failed test scenarios */
                for (ITestResult r : tc.getFailedTests().getAllResults()) {
                    failed++;
                }      /* Get all skipped test scenarios */
                for (ITestResult r : tc.getSkippedTests().getAllResults()) {
                    skipped++;
                }
            }


            PrintWriter reportWriter = null;
            File targetFile = new File("basicReport.html");
            try {
                reportWriter = new PrintWriter(new BufferedWriter(new FileWriter(targetFile)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            reportWriter.println("<!DOCTYPE html>");
            reportWriter.println("<html><head><title>Test Run Report</title></head>");
            reportWriter.println("<body>");
            reportWriter.println("<p>This is my custom test report</p>");
            reportWriter.println("<p>PASSED:  "+passed+"</p>");
            reportWriter.println("<p>FAILED: "+failed+"</p>");
            reportWriter.println("<p>SKIPPED: "+skipped+"</p>");
            reportWriter.println("</body>");
            reportWriter.println("</html>");
            reportWriter.flush();
            reportWriter.close();

            reportWriter.flush();
            reportWriter.close();
        }

    }
}

