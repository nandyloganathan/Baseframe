package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

    private static ExtentReports extentReports;
    private static ExtentSparkReporter extentSparkReporter;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    // Initializes the Extent Reports configuration
    public static void startReporter() {
        extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/extentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        extentSparkReporter.config().setDocumentTitle("Automation Report - AgriChain");
        extentSparkReporter.config().setReportName("Test Report");
        extentSparkReporter.config().setTheme(Theme.STANDARD);
        extentSparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }

    // Creates a new test in the report with dynamic name and description
    public static void createTest(String testName, String description) {
        ExtentTest test = extentReports.createTest(testName, description);
        extentTest.set(test);
    }

    // Logs the test result (PASS, FAIL, or SKIP)
    public static void logResult(int status, String name, Throwable throwable) {
        ExtentTest test = extentTest.get();

        if (status == 1) {
            test.log(Status.PASS, name);
        } else if (status == 2) {
            test.log(Status.FAIL, throwable);
        } else {
            test.log(Status.SKIP, name);
        }
    }

    // Flushes the report after all tests are done
    public static void flushReport() {
        extentReports.flush();
    }
}

