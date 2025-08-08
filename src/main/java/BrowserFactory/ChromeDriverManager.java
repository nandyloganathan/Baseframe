package BrowserFactory;

import Utils.ExtentReportManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class ChromeDriverManager {

    protected WebDriver driver;

    // Starts the reporter from ExtentReportManager
    @BeforeTest
    public void startReporter() {
        ExtentReportManager.startReporter();
    }

    // Sets up the Chrome WebDriver and creates a test entry in ExtentReportManager
    @BeforeMethod
    public void setUp(Method method) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Create dynamic test name and description in ExtentReportManager
        String testName = method.getName();
        String description = "Execution of " + testName;
        ExtentReportManager.createTest(testName, description);
    }

    // Captures the result of each test and logs it to ExtentReportManager
    @AfterMethod
    public void getResult(ITestResult result) {
        int status = result.getStatus();
        String name = result.getName();
        Throwable throwable = result.getThrowable();

        ExtentReportManager.logResult(status, name, throwable);
    }

    // Quits the browser after each test method
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Flushes the report after all tests are done
    @AfterTest
    public void flushReport() {
        ExtentReportManager.flushReport();
    }

    // Returns the current WebDriver instance
    public WebDriver getDriver() {
        return driver;
    }
}
