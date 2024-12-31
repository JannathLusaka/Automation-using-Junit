import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class Task_1_Assignment {
WebDriver driver;
    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
@Test
@DisplayName("Check if sucessful submission message is showing properly")
    public void formFillUp() throws InterruptedException {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("edit-name")).sendKeys("Noor-A-Jannath");
        driver.findElement(By.id("edit-number")).sendKeys("01701789259");
        driver.findElement(By.id("edit-date")).sendKeys("12/30/2024");
driver.findElement(By.id("edit-email")).sendKeys("jannathlusaka@email.com");

Scrolling.scroll(driver,710);

driver.findElement(By.id("edit-tell-us-a-bit-about-yourself-")).
        sendKeys("Hello, Im Lusaka and Im currently pursuing a carrer in sqa");
driver.findElement(By.id("edit-uploadocument-upload")).
        sendKeys(System.getProperty("user.dir")+"/src/test/resources/images.jpg");

driver.findElement(By.id("edit-age")).click();
    Thread.sleep(3000);
driver.findElement(By.id("edit-submit")).click();
    Thread.sleep(3000);

String submitMsg= driver.findElement(By.tagName("h1")).getText();
String actualMsg="Thank you for your submission!";
Assertions.assertTrue(submitMsg.contains(actualMsg));

    }
}
