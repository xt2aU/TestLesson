import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MtsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public void acceptCookies() {
        WebElement acceptCookieButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cookie-agree")));
        if (acceptCookieButton != null && acceptCookieButton.isDisplayed()) {
            acceptCookieButton.click();
        }
    }

    public WebElement getTitlePaymentSection() {
        return driver.findElement(By.xpath("//section[@class='pay']//h2[contains(text(),'Онлайн пополнение') and contains(., 'без комиссии')]"));
    }

    public WebElement getIconsForPayPaymentSection() {
        return driver.findElement(By.xpath("//div[@class='pay__partners']//ul"));
    }

    public WebElement getMoreAboutServiceLink() {
        WebElement onlinePaymentBlock = driver.findElement(By.xpath("//section[@class='pay']"));
        return onlinePaymentBlock.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a[contains(text(), 'Подробнее о сервисе')]"));
    }

    public WebElement getPhoneNumberField() {
        WebElement onlinePaymentBlock = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section"));
        return onlinePaymentBlock.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
    }

    public WebElement getAmountField() {
        WebElement onlinePaymentBlock = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section"));
        return onlinePaymentBlock.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
    }

    public WebElement getEmailField() {
        WebElement onlinePaymentBlock = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section"));
        return onlinePaymentBlock.findElement(By.xpath("//*[@id=\"connection-email\"]"));
    }

    public WebElement getContinueButton() {
        WebElement onlinePaymentBlock = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section"));
        return onlinePaymentBlock.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
    }

    public WebElement getPopup() {
        WebElement iframe = driver.findElement(By.xpath("/html/body/div[8]/div/iframe"));
        driver.switchTo().frame(iframe);
        WebElement popup = driver.findElement(By.xpath("/html/body/app-root"));
        return popup;
    }
}