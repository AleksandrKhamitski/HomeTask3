import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Typos {
    WebDriver driver = null;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WebElement typos = driver.findElement(By.xpath("//a[@href=\"/typos\"]"));
        typos.click();
        //go tot sortable data tables
    }

    @Test
    public void isTyposOk () {
        String textMsg = driver.findElement(By.xpath("//p[2]")).getAttribute("textContent");
        //get msg text
        String expectedText = "\n" +
                "  Sometimes you'll see a typo, other times you won't.";
        //full expected text
        String[] oneWord = textMsg.split(" ");
        //split full text by " "
        String expectedWord = "won't.\n";
        System.out.println("actual: " + oneWord[10]);
        //print actual word
        System.out.println("expected: " + expectedWord);
        //print expected word
        Assert.assertTrue(oneWord[10].contains(expectedWord));
    }

    @AfterTest
    public void quit () {
        driver.quit();
    }
}
