package Utils;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class SenderReceiver extends BasePage {

    static WebDriver driver;
    private static WebDriverWait wait;
    private static ExtentTest test;

    public SenderReceiver(ExtentTest test) {
        super();
        wait = new WebDriverWait(super.driver, Duration.ofSeconds(10));
    }

    @Test
    public void SenderReceiverTest() {

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title='למישהו אחר']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ember2382"))).click();
        test.info("clicked the for someone else button");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title='שם מקבל המתנה']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ember2386"))).sendKeys("Daniel G");
        test.info("entered receiver name");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='selected-name']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[value='8']"))).click();
        test.info("select the event type");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title='ברכה']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ember2386"))).sendKeys("Nice blessing like happy birthday");
        test.info("enter a blessing");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title='תמונה/וידאו']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ember2405"))).sendKeys("/Users/ifirst/Downloads/0090151479.pdf");
        test.info("Upload a picture");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title='המשך']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ember2407"))).click();
        test.info("Click the continue button");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title='עכשיו']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ember2528"))).click();
        test.info("Click the Now button");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title='מייל מקבל/ת המתנה']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("inbalf0612@gmail.com");
        test.info("Enter the receiver email");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title='שם שולח המתנה']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ember2557"))).sendKeys("Inbal F");
        test.info("Enter the sender name");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title='המשך לתשלום']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ember2557"))).click();
        test.info("Click the continue for payment button");

        String receiver = "span[title='שם מקבל המתנה']";
        String sender = "span[title='שם שולח המתנה']";
        Assert.assertEquals(receiver, "Daniel G");
        Assert.assertEquals(sender, "Inbal F");

    }
}




