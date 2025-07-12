package listeners;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import base.ScreenshotUtil;


public class ExtentTestListener implements ITestListener 
{

    private static ExtentReports extent;
    private static ExtentTest test;

    @Override
    public void onStart(ITestContext context) 
    {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setDocumentTitle("HubSpot Automation Report");
        spark.config().setReportName("HubSpot Test Execution Report");

        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @Override
    public void onTestStart(ITestResult result) 
    {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        test.pass("Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        test.fail("Test Failed: " + result.getMethod().getMethodName());
        test.fail(result.getThrowable());

        // Capture screenshot
        String screenshotPath = ScreenshotUtil.captureScreenshot(result.getMethod().getMethodName());
        test.addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) 
    {
        test.skip("Test Skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) 
    {
        extent.flush();
    }
}
