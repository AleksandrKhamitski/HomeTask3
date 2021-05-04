import com.sun.org.apache.xpath.internal.operations.Equals;
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

public class Dropdown {
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
    public void checkingAllElementsOfDropdownAnd() {
        WebElement dropdown = driver.findElement(By.xpath("//li/a[@href=\"/dropdown\"]"));
        dropdown.click();
        //click to dropdown
        //boolean found = false;
        //create boolean found
        WebElement elementsOfDropdown = driver.findElement(By.id("dropdown"));
        Select selectAllElementsOfDropdown = new Select(elementsOfDropdown);
        //select all elements of dropdown
        List<WebElement> allElements = selectAllElementsOfDropdown.getOptions();
        //create list of all elements of dropdown
        for (int i=0; i<allElements.size(); i++) {
            String tempOption = allElements.get(i).getText();
            if (i == 0) {
                System.out.println("1 " + tempOption);
                Assert.assertEquals(tempOption, "Please select an option");
            }
            else {
                System.out.println(i+1 + " " + tempOption);
                Assert.assertEquals(tempOption, "Option " + i);
            }
        }

        elementsOfDropdown.click();
        //click to elements of dropdown
        WebElement option1 = driver.findElement(By.xpath("//option[@value=\"1\"]"));
        option1.click();
        //click option 1 at dropdown list
        Assert.assertTrue(option1.isSelected());

        elementsOfDropdown.click();
        //click to elements of dropdown
        WebElement option2 = driver.findElement(By.xpath("//option[@value=\"2\"]"));
        option2.click();
        //click option 2 at dropdown list
        Assert.assertTrue(option2.isSelected());
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }
}
