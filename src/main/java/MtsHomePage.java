import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MtsHomePage extends BasePage {

    @FindBy(id = "cookie-agree")
    private WebElement acceptCookieButton;

    @FindBy(xpath = "//section[@class='pay']//h2[contains(text(),'Онлайн пополнение') and contains(., 'без комиссии')]")
    private WebElement titlePayment;

    @FindBy(xpath = "//div[@class='pay__partners']//ul")
    private WebElement icons;

    @FindBy(xpath = "//section[@class='pay']")
    private WebElement onlinePaymentBlock;

    @FindBy(xpath = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a[contains(text(), 'Подробнее о сервисе')]")
    private WebElement moreAboutServiceLink;

    @FindBy(xpath = "//*[@id=\"connection-phone\"]")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//*[@id=\"connection-sum\"]")
    private WebElement amountField;

    @FindBy(xpath = "//*[@id=\"connection-email\"]")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id=\"pay-connection\"]/button")
    private WebElement continueButton;

    @FindBy(className = "bepaid-iframe")
    private WebElement iframe;

    @FindBy(xpath = "/html/body/app-root")
    private WebElement popup;

    public MtsHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get("https://www.mts.by");
        WebElement acceptCookieButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cookie-agree")));
        if (acceptCookieButton != null && acceptCookieButton.isDisplayed()) {
            acceptCookieButton.click();
        }
    }

    public WebElement getTitlePayment() {
        return titlePayment;
    }

    public WebElement getIcons() {
        return icons;
    }

    public WebElement getMoreAboutServiceLink() {
        return moreAboutServiceLink;
    }

    public WebElement getPhoneNumberField() {
        return phoneNumberField;
    }

    public WebElement getAmountField() {
        return amountField;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public WebElement getIframe() {
        return iframe;
    }

    public WebElement getPopup() {
        return popup;
    }
}