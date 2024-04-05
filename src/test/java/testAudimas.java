import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testAudimas {

    WebDriver _globalDriver;

    @BeforeTest
    public void setUp() {
        _globalDriver = new ChromeDriver();
        _globalDriver.get("https://www.audimas.lt/");
        Alert alert = _globalDriver.switchTo().alert();
        alert.dismiss();
    }

    @Test
    public void test1() {
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[1]/div[2]/button[4]")).click();
        
    }
}
