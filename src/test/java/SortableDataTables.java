import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class SortableDataTables {
    WebDriver driver = null;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WebElement sortableDataTables = driver.findElement(By.xpath("//li/a[@href=\"/tables\"]"));
        sortableDataTables.click();
        //go tot sortable data tables
    }

    @Test
    public void checkingJohn_sLastName () {
        WebElement johnSmithLastNameTable1 = driver.findElement(By.xpath("//table[1]//tr[1]//td[1]"));
        //find John Smith last name from table 1
        String johnSmithLastName = johnSmithLastNameTable1.getAttribute("textContent");
        //get John Smith actual last name
        System.out.println("1) " + johnSmithLastName);
        Assert.assertEquals(johnSmithLastName, "Smith");
    }

    @Test
    public void checkingFrank_sEmail () {
        WebElement bachFrankEmailTable1 = driver.findElement(By.xpath("//table[1]//tr[2]//td[3]"));
        String frank_sEmailTable1 = bachFrankEmailTable1.getAttribute("textContent");
        //get Frank's email from the table 1
        WebElement bachFrankEmailTable2 = driver.findElement(By.xpath("//tr[2]//td[@class=\"email\"]"));
        String frank_sEmailTable2 = bachFrankEmailTable2.getAttribute("textContent");
        //get Frank's actual email from the first table 2
        Assert.assertEquals(frank_sEmailTable1,frank_sEmailTable2);
        System.out.println("2) " + frank_sEmailTable1 + " = " + frank_sEmailTable2);
    }

    @Test
    public void checkingJason_sDue () {
        WebElement doeJasonDueTable1 = driver.findElement(By.xpath("//tr[3]//td[4]"));
        String jason_sDue = doeJasonDueTable1.getAttribute("textContent");
        //get Jason's due actual value
        System.out.println("3) " + jason_sDue);
        Assert.assertEquals(jason_sDue, "$100.00");
    }

    @Test
    public void checkingTim_sWebSite () {
        WebElement timConwayWebSite = driver.findElement(By.xpath("//table[1]//tr[4]//td[5]"));
        String nameOfTim_sWebSite = timConwayWebSite.getAttribute("textContent");
        //get actual name of Tim's web site
        WebElement timConwayWebSiteTable2 = driver.findElement(By.xpath("//table[2]//tr[4]//td[@class=\"web-site\"]"));
        String nameOfTim_sWebSiteTable2 = timConwayWebSiteTable2.getAttribute("textContent");
        //get actual name of Tim's web site from table 2
        System.out.println("4) " + nameOfTim_sWebSite + " = " + nameOfTim_sWebSiteTable2);
        Assert.assertEquals(nameOfTim_sWebSite, nameOfTim_sWebSiteTable2);
    }

    @Test
    public void isTim_sEditButtonEnabled () {
        WebElement editButton = driver.findElement(By.xpath("//table[2]//tr[4]//a[@href=\"#edit\"]"));
        //find edit button
        System.out.println("5) " + editButton.isEnabled());
        Assert.assertTrue(editButton.isEnabled());
    }

    @AfterTest
    public void quit () {
        driver.quit();
    }
}
