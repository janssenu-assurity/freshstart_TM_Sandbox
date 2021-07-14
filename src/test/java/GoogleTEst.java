import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleTEst {


    private WebDriver driver;

    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.get("https://www.tmsandbox.co.nz");
    }

    @AfterEach
    private void closeBrowser() {
        driver.quit();
    }

    @Test
    public void checkTitle() {
        String title = driver.getTitle();
        assertEquals("Google", title);
    }

    @Test
    public void testGold() throws Exception {
        WebElement queryBox = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div[2]/div/div/form/div[1]/div/div[1]/input[1]"));
        WebElement submitButton = driver.findElement(By.cssSelector("#generalSearch > div.field.field-right"));
        queryBox.sendKeys("gold");
        submitButton.click();

        Thread.sleep(20000);

        List<WebElement> link_List = driver.findElements(By.className("supergrid-listing"));
        for (WebElement element: link_List) {
            String title = element.getText();
            System.out.println(title);
            
        }
    }
}
