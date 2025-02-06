package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import lombok.Getter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;


public class BaseTest {


    protected  static WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;



    @BeforeSuite
    public void setUpSuite() {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("reports/extent.html"); // Customize report path
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }


    @BeforeClass
    public void rep(ITestContext context) throws NoSuchMethodException {
        String testName = context.getName(); // Get test name from ITestContext
        test = extent.createTest(testName); // Create ExtentTest instance
    }



    public WebDriver getDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        return driver;
    }


    @AfterSuite
    public void tearDownSuite() {
        extent.flush(); // Generate the report
    }

    public static String captureScreenshot(WebDriver driver, String testName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String destination = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timestamp + ".png"; // Customize path
        File target = new File(destination);
        try {
            FileUtils.copyFile(source, target);
            return destination; // Return the path to the screenshot
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) { // Add ITestResult
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = captureScreenshot(driver, result.getName());
            test.log(Status.FAIL, "Test Failed: " + result.getThrowable().getMessage());
            if (screenshotPath != null) {
                test.addScreenCaptureFromPath(screenshotPath);
            }
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Skipped");
        } else {
            test.log(Status.PASS, "Test Passed");
        }


        if (driver != null) {
            driver.quit();
        }
    }


    public static void takeScreenshotOnSuccess(WebDriver driver, String fileName) {
        // Convert WebDriver object to TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        // Capture screenshot as File
        File source = ts.getScreenshotAs(OutputType.FILE);

        // Define destination file
        File destination = new File(System.getProperty("user.dir") + "/screenshots/" + fileName);

        try {
            // Copy the file to the destination
            FileHandler.copy(source, destination);
            System.out.println("Screenshot saved: " + destination.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
