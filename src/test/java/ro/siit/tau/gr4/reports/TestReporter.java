package ro.siit.tau.gr4.reports;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import java.io.*;
import java.util.List;


public class TestReporter implements IReporter {

    public void generateReport(List<XmlSuite> xml, List<ISuite> suites, String outDir)

    {
        PrintWriter reportWriter = null;
        File targetFile = new File("G:\\Scoala Informala Testare Automata\\Projects\\ShopProject1\\siit-gr4-team1\\report.html");
        try {
            reportWriter = new PrintWriter(new BufferedWriter(new FileWriter(targetFile)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        reportWriter.println("<!DOCTYPE html>");
        reportWriter.println("<html><head><title>Test Run Report</title></head>");
        reportWriter.println("<body>");
        reportWriter.println("<p>This is my custom test report</p>");
        reportWriter.println("</body>");
        reportWriter.println("</html>");
        reportWriter.flush();
        reportWriter.close();
    }
}


