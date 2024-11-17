import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MtsTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private MtsHomePage mtsHomePage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        mtsHomePage = new MtsHomePage(driver);
        mtsHomePage.open();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    @DisplayName("Check title Payment Section")
    public void checkTitlePaymentSection() {
        assertTrue(mtsHomePage.getTitlePayment().isDisplayed());
    }

    @Test
    @DisplayName("Check icons for pay Payment Section")
    public void checkIconsForPayPaymentSection() {
        String[] expectedIcons = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"};
        for (String text : expectedIcons) {
            WebElement icon = mtsHomePage.getIcons().findElement(By.xpath(".//img[@alt='" + text + "']"));
            assertTrue(((WebElement) icon).isDisplayed());
        }
    }

    @Test
    @DisplayName("Check link about service")
    public void checkLinkAboutService() {
        WebElement moreAboutServiceLink = mtsHomePage.getMoreAboutServiceLink();
        assertTrue(moreAboutServiceLink.isDisplayed(), "Ссылка 'Подробнее о сервисе' найдена на странице.");
        moreAboutServiceLink.click();
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(actualUrl, expectedUrl, "Переход на страницу 'Подробнее о сервисе' не произошел.");
    }

    @Test
    @DisplayName("Test Form Online Payment")
    public void testFormOnlinePayment() {
        mtsHomePage.getPhoneNumberField().sendKeys("297777777");
        mtsHomePage.getAmountField().sendKeys("100");
        mtsHomePage.getEmailField().sendKeys("ivanov2000@gmail.com");
        mtsHomePage.getContinueButton().click();

        driver.switchTo().frame(mtsHomePage.getIframe());
        assertTrue(mtsHomePage.getPopup().isDisplayed(), "Всплывающее окно отображается.");
        driver.switchTo().defaultContent();
    }

    @Test
    @DisplayName("Test Metod")
    public void testMetod() {
        checkTitlePaymentSection();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkTitlePaymentSection());
    }
}