import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.SearchResultsPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleTEst {


    private WebDriver driver;
    private HomePage homePage;

    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        homePage = new HomePage(driver);
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
        SearchResultsPage searchResultsPage = homePage.search("gold");
        List<WebElement> results_List = searchResultsPage.getResults();

        System.out.println(results_List);


    }
}
