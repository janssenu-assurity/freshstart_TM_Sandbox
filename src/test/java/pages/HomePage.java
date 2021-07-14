package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {


    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public SearchResultsPage search(String input_String) {
        WebElement input_Box = this.driver.findElement(By.name("q"));

        input_Box.sendKeys(input_String);
        input_Box.submit();

        return new SearchResultsPage(driver);
    }
}
