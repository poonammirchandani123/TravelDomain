import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectFlightTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.skyscanner.com");
    }

    @Test
    public void selectFlight() {

        WebElement flightOption = driver.findElement(By.xpath("//div[@class='flight-option']"));
        flightOption.click();

        // Validate that the booking page is displayed
        WebElement bookingPage = driver.findElement(By.id("bookingPage"));
        assert bookingPage.isDisplayed();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

