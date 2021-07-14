import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TradeMeTest {


    private WebDriver driver;

    @BeforeAll
    public static void setupDriver2() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void openBrowser2() {
        driver = new ChromeDriver();
        driver.get("https://www.tmsandbox.co.nz");

        WebElement queryBox = driver.findElement(By.cssSelector("#searchString"));
        WebElement submitButton = driver.findElement(By.cssSelector("#generalSearch > div.field.field-right"));
        queryBox.sendKeys("gold");
        submitButton.click();
    }

    @AfterEach
    private void closeBrowser2() {
        driver.quit();
    }

    @Test
    private void test() {
        System.out.println("This is a test");
    }
}
//
//    @Test
//    private void getListingsNumber() {
//        List<WebElement> listings_List = driver.findElements(By.className("supergrid-listing"));
//        System.out.println(listings_List.stream().count());
//    }
//
//    @Test
//    private void getPrice() {
//        List<WebElement> listings_List = driver.findElements(By.className("supergrid-listing"));
//        System.out.println(listings_List.get(0).getAttribute("class"));
//    }
//
//    @Test
//    private void getTitles() {
//        List<WebElement> listings_List = driver.findElements(By.className("supergrid-listing"));
//
//        for (WebElement element: listings_List) {
//            String title = element.getText();
//            System.out.println(title);
//        }
//    }
//}
