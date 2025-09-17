package ExtentReporter;

import base.BaseClass;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static ExtentReporter.ExtentReport.test;

public class Listeners extends BaseClass implements ITestListener, ISuiteListener {
    /**
     * Overrides the onStart method defined in the ISuiteListener interface
     * Triggered when the test suite execution starts
     * Initializes the Extent Reports for generating test execution reports
     *
     * @param suite The current test suite instance provided by TestNG. Represents the entire suite of tests being run
     */
    @Override
    public void onStart(ISuite suite) {
        try {
            ExtentReport.initReports();
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    /**
     * Overrides the onFinish method defined in the ISuiteListener interface
     * Triggered when a TestNG suite finishes execution
     * Finalizes and flushes the Extent Reports, ensuring that all test execution data is saved
     *
     * @param suite The current test suite instance provided by TestNG, representing the suite that has just finished execution
     */
    @Override
    public void onFinish(ISuite suite) {
        try {
            ExtentReport.flushReports();
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    /**
     * Overrides the onTestStart method defined in the ITestListener interface
     * Triggered at the start of an individual test case execution
     * Initializes a new test in the Extent Report, associating it with the test method being executed
     *
     * @param result The ITestResult instance provided by TestNG, which contains metadata about the test method that is starting, such as its name, class, and parameters
     */
    @Override
    public void onTestStart(ITestResult result) {
        try {
            ExtentReport.createTest(result.getMethod().getDescription());
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    /**
     * Overrides the onTestSuccess method defined in the ITestListener interface
     * Triggered when a test case executes successfully
     * Logs the success status of the test using the ExtentLogger utility
     *
     * @param result The ITestResult instance provided by TestNG, which contains metadata about the test method that is starting, such as its name, class, and parameters
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        try {
//            ExtentLogger.pass(result.getMethod().getDescription() + " >>  passed");
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    /**
     * Overrides the onTestFailure method defined in the ITestListener interface
     * Triggered when a test case fails during execution
     * Logs the failure status of the test and captures the exception or error message that caused the failure using the ExtentLogger utility
     *
     * @param result The ITestResult instance provided by TestNG, which contains metadata about the test method that failed, including its name, class, parameters, and the throwable that caused the failure
     */
    @Override
    public void onTestFailure(ITestResult result) {
        try {
            ExtentLogger.fail(result.getMethod().getDescription() + " >> failed >> "+result.getThrowable());
        } catch (Exception e) {
            test.fail(new RuntimeException());
        }
    }
}