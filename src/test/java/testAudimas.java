import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class testAudimas {

    WebDriver _globalDriver;
    public WebElement snoozeUntilElement(By by) {
        WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(30));

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return element;
    }

    public WebElement snoozeUntilClickable(By by) {
        WebElement element = snoozeUntilElement(by);
        WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(30));

        element = wait.until(ExpectedConditions.elementToBeClickable(by));
        return element;
    }



    @BeforeTest
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        _globalDriver = new ChromeDriver(options);
        _globalDriver.get("https://www.audimas.lt");
        _globalDriver.manage().window().maximize();
    }

    @Test
    public void test1() {
        _globalDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[1]/div[2]/button[4]")).click();
        snoozeUntilClickable(By.xpath("/html/body/div[9]/div/div/div/button")).click();
    }

}
