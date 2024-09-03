import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchFlightsTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.skyscanner.com"); // replace with actual travel site URL
    }

    @Test
    public void searchFlights() {
        WebElement fromInput = driver.findElement(By.id("fromInput"));
        fromInput.sendKeys("New York");

        WebElement toInput = driver.findElement(By.id("toInput"));
        toInput.sendKeys("Los Angeles");

        WebElement dateInput = driver.findElement(By.id("dateInput"));
        dateInput.sendKeys("2024-10-01");

        WebElement searchButton = driver.findElement(By.id("searchButton"));
        searchButton.click();

        // Validate that results are displayed
        WebElement results = driver.findElement(By.id("results"));
        assert results.isDisplayed();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

