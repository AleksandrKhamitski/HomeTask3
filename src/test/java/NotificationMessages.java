import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NotificationMessages {
    WebDriver driver = null;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@href=\"/notification_message\"]")).click();
    }

    @Test
    public void waitingText() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href=\"/notification_message\"]")).click();
        //click link 'click here'
        Thread.sleep(2000);
        String actualMsgText = driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText();
        //get actual msg text
        String expectedMsgText = "Action successful";
        //expected msg text
        System.out.println("actual: " + actualMsgText);
        Assert.assertTrue(actualMsgText.contains(expectedMsgText));
    }

    @AfterTest
    public void quit () {
        driver.quit();
    }
}
