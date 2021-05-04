import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
public class AddRemoveElements {
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
    public void quantityOfElements() {
        WebElement addRemoveElementsButton = driver.findElement(By.xpath("//a[@href=\"/add_remove_elements/\"]"));
        addRemoveElementsButton.click();
        //click  add/remove elements button
        WebElement addButton = driver.findElement(By.xpath("//button[text()=\"Add Element\"]"));
        addButton.click();
        addButton.click();
        //twice click to add button
        WebElement deleteButton = driver.findElement(By.xpath("//button[@onclick=\"deleteElement()\"]"));
        deleteButton.click();
        //delete one button
        int quantityOfButtons = driver.findElements(By.xpath("//button[@class=\"added-manually\"]")).size();
        //get quantity of buttons
        Assert.assertEquals(quantityOfButtons, 1);
        System.out.println("1) " + quantityOfButtons);
        //print quantity of buttons
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }
}
