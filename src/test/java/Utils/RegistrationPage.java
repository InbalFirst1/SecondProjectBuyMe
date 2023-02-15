package Utils;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.time.Duration;


public class RegistrationPage extends BasePage {
    private static WebDriverWait wait;
    private static ExtentTest test;

    public RegistrationPage(ExtentTest extentTest){
        super();
        wait = new WebDriverWait(super.driver, Duration.ofSeconds(5));
        test = extentTest;
    }

    public void register() {
        clickElement(By.linkText("כניסה / הרשמה"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='text-link theme']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ember1862"))).sendKeys("ענבל פירסט");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ember1869"))).sendKeys("inbalf0612+2@gmail.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("valPass"))).sendKeys("1q2w3e$R");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ember1883"))).sendKeys("1q2w3e$R");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("circle[class='fill']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']"))).click();
        test.info("Click register button");
        test.info("Insert user name");
        test.info("Insert email");
        test.info("Insert password twice");

    }
    public void login() {
            clickElement(By.linkText("כניסה / הרשמה"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ember1836"))).sendKeys("inbalf0612+1@gmail.com");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ember1843"))).sendKeys("1q2w3e$R");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ember1852"))).click();
            test.info("Click register button");
            test.info("Insert email");
            test.info("Insert password");
        }
    }

