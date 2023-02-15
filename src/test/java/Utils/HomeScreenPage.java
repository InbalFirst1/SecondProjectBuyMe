package Utils;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeScreenPage extends BasePage {

    static WebDriver driver;
    private static WebDriverWait wait;
    private static ExtentTest test;

    public HomeScreenPage(ExtentTest test) {
        super();
        wait = new WebDriverWait(super.driver, Duration.ofSeconds(10));
    }

    @BeforeClass
    public static void runOnceBeforeClass() {
        driver = new DriverSingleton().getDriverInstance();
        driver.get("https://buyme.co.il");
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    public void homeScreenTest() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title='סכום']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ember1077"))).click();
        test.info("click the amount button");
        test.info("choose the amount");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title='אזור']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ember1111"))).click();
        test.info("click the region button");
        test.info("select region");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title='קטגוריה']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ember1171"))).click();
        test.info("click the category button");
        test.info("select category");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("תמצאו לי מתנה"))).click();
        test.info("click the find me a gift button");

    }

}
