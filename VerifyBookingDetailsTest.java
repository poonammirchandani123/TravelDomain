import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class VerifyBookingDetailsTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.orbitz.com"); // replace with actual travel site URL
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));// Wait up to 10 seconds
        WebElement flightDetails = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("flightDetails")));

    }

    @Test
    public void verifyBookingDetails() {
        WebElement flightDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flightDetails")));
        assert flightDetails.getText().contains("New York to Los Angeles");

        WebElement bookingDate = driver.findElement(By.id("bookingDate"));
        assert bookingDate.getText().equals("2024-10-01");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
