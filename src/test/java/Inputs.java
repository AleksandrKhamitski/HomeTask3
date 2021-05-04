import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Inputs {
    WebDriver driver = null;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void inputs () {
        WebElement inputs = driver.findElement(By.xpath("//li/a[@href=\"/inputs\"]"));
        inputs.click();
        //go to inputs
        WebElement textField = driver.findElement(By.xpath("//input[@type=\"number\"]"));
        textField.click();
        //click to text field
        textField.sendKeys(Keys.ARROW_UP);
        //click up by keyboard
        String arrowUpAnswer = textField.getAttribute("value");
        //get value of text field
        System.out.println(arrowUpAnswer);
        //print actual result
        Assert.assertEquals(arrowUpAnswer, "1");
        textField.click();
        textField.clear();
        //clear text field
        textField.sendKeys(Keys.ARROW_DOWN);
        //click down by keyboard
        String arrowDownAnswer = textField.getAttribute("value");
        //get value of text field
        System.out.println(arrowDownAnswer);
        //print actual result
        Assert.assertEquals(arrowDownAnswer, "-1");
    }

    @AfterTest
    public void quit () {
        driver.quit();
    }
}
