package Utils;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;


public class PickBusiness extends BasePage {

    static WebDriver driver;
    private static WebDriverWait wait;
    private static ExtentTest test;

    public PickBusiness(ExtentTest extentTest) {
        wait = new WebDriverWait(super.driver, Duration.ofSeconds(10));
        test = extentTest;
    }
    @Test
    public void PickBusinessTest() {
        Assert.assertEquals("https://buyme.co.il/search?budget=1&category=438&region=11", driver.getCurrentUrl());

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class='name bm-subtitle-1']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("הכנס סכום"))).sendKeys("250");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ember2596"))).click();
        test.info("clicked business card");
        test.info("type the amount");
        test.info("type the confirm button");
    }
}




