import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class YouTubeSearchTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.youtube.com");

//         Thread.sleep(2000);

        WebElement searchInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("search_query")));

         searchInput.sendKeys("Rick Astley - Never Gonna Give You Up");

//         Thread.sleep(1000);

         WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Search']")));
         searchButton.click();
//         Thread.sleep(8000);

        WebElement searchResult = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[@aria-label='Rick Astley - Never Gonna Give You Up (Official Video) (4K Remaster) 3 minutes, 34 seconds']")
                )
        );
        assert searchResult.isDisplayed();

        driver.quit();
    }
}
