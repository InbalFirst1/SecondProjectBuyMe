import Utils.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Main {
    private static WebDriver driver;
    private static ExtentReports extent;
    private static ExtentTest test;
    private String ScreenShotTime = "/Users/ifirst/Downloads/SecondProject/src" + String.valueOf(System.currentTimeMillis());


    @BeforeClass
    public void initSanity() {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("/Users/ifirst/Downloads/SecondProject/src/Report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest("Tests", "Start");
        test.log(Status.INFO, "@Before class");
        driver = DriverSingleton.getDriverInstance();
        driver.get(DriverSingleton.getData("Browser"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(priority = 1)
    public void registrationPageTest()  {
        RegistrationPage registrationPage = new RegistrationPage(test);

        try {
            test.info("Registration page");
            registrationPage.register();
            //registrationPage.login();
            test.info("End of Registration test");
        } catch (NoSuchElementException e){
            e.printStackTrace();
            test.fail("Registration failure", MediaEntityBuilder.createScreenCaptureFromPath(AddScreenShot(ScreenShotTime)).build());
        }
    }

    @Test(priority = 2)
    public void HomeScreenTest() {
        HomeScreenPage homeScreenPage = new HomeScreenPage(test);

        try {
            test.info("HomeScreen page");
            homeScreenPage.homeScreenTest();
            test.info("End of HomeScreen test");
        } catch (NoSuchElementException e){
            e.printStackTrace();
            test.fail("HomeScreen failure", MediaEntityBuilder.createScreenCaptureFromPath(AddScreenShot(ScreenShotTime)).build());
        }
    }

    @Test(priority = 3)
    public void PickBusinessTest() {
        PickBusiness pickBusiness = new PickBusiness(test);

        try {
            test.info("Pick a business page");
            pickBusiness.PickBusinessTest();
            test.info("End of pick a business test");
        } catch (NoSuchElementException e){
            e.printStackTrace();
            test.fail("Business page failure", MediaEntityBuilder.createScreenCaptureFromPath(AddScreenShot(ScreenShotTime)).build());
        }
    }

    @Test(priority = 4)
    public void SenderReceiverTest() {
        SenderReceiver senderReceiver = new SenderReceiver(test);

        try {
            test.info("Sender Receiver page");
            senderReceiver.SenderReceiverTest();
            test.info("End of SenderReceiver test");
        } catch (NoSuchElementException e){
            e.printStackTrace();
            test.fail("SenderReceiver page failure", MediaEntityBuilder.createScreenCaptureFromPath(AddScreenShot(ScreenShotTime)).build());
        }
    }


    private static String AddScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath + ".png";
    }

    @AfterClass
    public void tearDown(){
        test.log(Status.INFO, "End of testing");
        driver.quit();
        extent.flush();
    }
}