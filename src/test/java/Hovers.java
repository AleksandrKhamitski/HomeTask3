import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Hovers {
    WebDriver driver = null;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WebElement hovers = driver.findElement(By.xpath("//a[@href=\"/hovers\"]"));
        hovers.click();
        //go to hovers
    }

    @Test
    public  void user1ActionTest () {
        Actions action = new Actions(driver);
        WebElement user1 = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/img"));
        action.moveToElement(user1).build().perform();
        //go to user 1
        String actualUser1Name = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5")).getText();
        //get user 1 name
        System.out.println("1 " + actualUser1Name);
        Assert.assertEquals(actualUser1Name, "name: user1");
        //
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/a")).click();
        //user 1 link click
        String actualUser1ErrorText = driver.findElement(By.xpath("//body/h1")).getText();
        //get error text
        System.out.println("1.1 " + actualUser1ErrorText);
        Assert.assertEquals(actualUser1ErrorText, "Not Found");
    }

    @Test
    public  void user2ActionTest () throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement user2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"));
        action.moveToElement(user2).build().perform();
        //go to user 2
        Thread.sleep(5000);
        String actualUser2Name = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h5")).getAttribute("textContent");
        //get user 2 name
        System.out.println("2 " + actualUser2Name);
        Assert.assertEquals(actualUser2Name, "name: user2");
        //
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/a")).click();
        //user 2 link click
        String actualUser2ErrorText = driver.findElement(By.xpath("//body/h1")).getAttribute("textContent");
        //get error text
        System.out.println("2.1 " + actualUser2ErrorText);
        Assert.assertEquals(actualUser2ErrorText, "Not Found");
    }

    @Test
    public  void user3ActionTest () {
        Actions action = new Actions(driver);
        WebElement user3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"));
        action.moveToElement(user3).build().perform();
        //go to user 3
        String actualUser3Name = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/h5")).getText();
        //get user 3 name
        System.out.println("3 " + actualUser3Name);
        Assert.assertEquals(actualUser3Name, "name: user3");
        //
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/a")).click();
        //user 3 link click
        String actualUser2ErrorText = driver.findElement(By.xpath("//body/h1")).getText();
        //get error text
        System.out.println("3.1 " + actualUser2ErrorText);
        Assert.assertEquals(actualUser2ErrorText, "Not Found");
    }

    @AfterMethod (alwaysRun = true)
    public void firstPage () {
        driver.get("http://the-internet.herokuapp.com/");
        WebElement hovers = driver.findElement(By.xpath("//a[@href=\"/hovers\"]"));
        hovers.click();
        //go to hovers
    }

    @AfterTest
    public void quit () {
        driver.quit();
    }
}
