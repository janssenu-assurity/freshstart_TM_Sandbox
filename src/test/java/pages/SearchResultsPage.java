package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultsPage {


    private WebDriver driver;

    @FindBy(id="result-stats")
    private WebElement totalCount;

    private void waitForLoad() {
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("footcnt")));
    }

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;

    }

    public List<WebElement> getResults() {
        waitForLoad();

        List<WebElement> results_List = this.driver.findElements(By.tagName("h3"));

        for (int list_Index = 0; list_Index < Math.min(3, results_List.size()); list_Index++) {
            System.out.println(results_List.get(list_Index).getText());
        }

        return(results_List);
    }

    public String getTotalCount() {
        waitForLoad();

        return(totalCount.getText());
    }
}
