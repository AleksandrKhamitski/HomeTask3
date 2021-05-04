import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Checkboxes {
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
    public void isCheckboxesSelectedOrNo() {
        WebElement checkboxes = driver.findElement(By.xpath("//a[@href=\"/checkboxes\"]"));
        checkboxes.click();
        //go to checkboxes
        WebElement theFirstCheckbox = driver.findElement(By.cssSelector("[type=checkbox]"));
        //find first check box
        Assert.assertFalse(theFirstCheckbox.isSelected(), "false");
        //check the first check box. expected result - false
        theFirstCheckbox.click();
        //click by the first check box
        Assert.assertTrue(theFirstCheckbox.isSelected(), "true");
        //check the first check box. expected result - true
        WebElement theSecondCheckbox = driver.findElement(By.xpath("//input[2]"));
        //find the second check box
        Assert.assertTrue(theSecondCheckbox.isSelected(), "true");
        //check the second check box. expected result - true
        theSecondCheckbox.click();
        //click by the second check box
        Assert.assertFalse(theSecondCheckbox.isSelected(), "false");
        //checking the second checkbox. expected result - false
    }

    @AfterTest
    public  void quit () {
        driver.quit();
    }
}
