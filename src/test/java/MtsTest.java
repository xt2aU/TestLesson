import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MtsTest {

    private WebDriver driver;

    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.mts.by");
        WebElement acceptCookieButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cookie-agree")));
        if (acceptCookieButton != null && acceptCookieButton.isDisplayed()) {
            acceptCookieButton.click();
        }
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
        WebElement titlePayment = driver.findElement(By.xpath("//section[@class='pay']//h2[contains(text(),'Онлайн пополнение') and " +
                "contains(., 'без комиссии')]"));
        assertTrue(titlePayment.isDisplayed());
    }

    @Test
    @DisplayName("Check icons for pay Payment Section")
    public void checkIconsForPayPaymentSection() {
        WebElement icons = driver.findElement(By.xpath("//div[@class='pay__partners']//ul"));

        String [] expectedIcons = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code","Белкарт"};
                for (String text: expectedIcons) {
                    WebElement icon = icons.findElement(By.xpath(".//img[@alt='" + text + "']"));
                    assertTrue(icon.isDisplayed());
                }
    }

    @Test
    @DisplayName("Check link about service")
    public void checkLinkAboutService() {
        WebElement onlinePaymentBlock = driver.findElement(By.xpath("//section[@class='pay']"));

                WebElement moreAboutServiceLink = onlinePaymentBlock.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a[contains(text(), 'Подробнее о сервисе')]"));

        // Проверь, что ссылка присутствует на странице
        assertTrue(moreAboutServiceLink.isDisplayed(), "Ссылка 'Подробнее о сервисе' найдена на странице.");

        // Кликни по ссылке
        moreAboutServiceLink.click();

        // Проверь, что переход на новую страницу произошел успешно
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(actualUrl, expectedUrl, "Переход на страницу 'Подробнее о сервисе' не произошел.");
    }

    @Test
    @DisplayName("Test Form Online Payment")
    public void testFormOnlinePayment() {
        // Найди блок "Онлайн пополнение без комиссии"
        WebElement onlinePaymentBlock = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section"));

        // Найди поле для ввода номера телефона внутри этого блока
        WebElement phoneNumberField = onlinePaymentBlock.findElement(By.xpath("//*[@id=\"connection-phone\"]"));

        // Найди поле для ввода суммы пополнения внутри этого блока
        WebElement amountField = onlinePaymentBlock.findElement(By.xpath("//*[@id=\"connection-sum\"]"));

        // Найди поле для ввода e-mail внутри этого блока
        WebElement emailField = onlinePaymentBlock.findElement(By.xpath("//*[@id=\"connection-email\"]"));

        // Найди кнопку "Продолжить" внутри этого блока
        WebElement continueButton = onlinePaymentBlock.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));

        // Заполни поле для ввода номера телефона
        phoneNumberField.sendKeys("297777777");

        // Заполни поле для ввода суммы пополнения
        amountField.sendKeys("100");

        // Заполни поле для ввода e-mail
        emailField.sendKeys("ivanov2000@gmail.com");

        // Кликни по кнопке "Продолжить"
        continueButton.click();

        // Переключись на iframe, содержащий всплывающее окно
        WebElement iframe = driver.findElement(By.xpath("/html/body/div[8]/div/iframe")); // Замени на фактический класс или идентификатор iframe
        driver.switchTo().frame(iframe);

        // Найди всплывающее окно внутри iframe
        WebElement popup = driver.findElement(By.xpath("/html/body/app-root")); // Замени на фактический класс или идентификатор всплывающего окна

        // Проверь, что всплывающее окно отображается
        assertTrue(popup.isDisplayed(), "Всплывающее окно не отображается.");

        // Вернись к основному контенту страницы
        driver.switchTo().defaultContent();
    }

}

