package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


public class EnteringPayeeInformation {
    private WebDriver driver;

    private By billPayLocator = By.linkText("Bill Pay");
    private By payeeNameLocator = By.name("payee.name");
    private By addressLocator = By.name("payee.address.street");
    private By cityLocator = By.name("payee.address.city");
    private By stateLocator = By.name("payee.address.state");
    private By zipCodeLocator = By.name("payee.address.zipCode");
    private By phoneNumberLocator = By.name("payee.phoneNumber");
    private By accountLocator = By.name("payee.accountNumber");
    private By verifyAccountLocator = By.name("verifyAccount");
    private By amountLocator = By.name("amount");
    private By sendPaymentButton = By.cssSelector("input.button");
    private By succesMessageLocator = By.cssSelector("div#billpayResult h1.title");
    private By errorMessageEmptyAccountNumberField = By.cssSelector("span#validationModel-account-empty.error");

    public EnteringPayeeInformation(WebDriver driver) {
        this.driver = driver;
    }


    public void clickBillPayButton() {
        driver.findElement(billPayLocator).click();
    }

    public void setPayeeName(String payeeName) {
        driver.findElement(payeeNameLocator).sendKeys(payeeName);
    }

    public void setAddress(String address) {
        driver.findElement(addressLocator).sendKeys(address);
    }

    public void setCity(String city) {
        driver.findElement(cityLocator).sendKeys(city);
    }

    public void setState(String state) {
        driver.findElement(stateLocator).sendKeys(state);
    }

    public void setZipCode(String zipCode) {
        driver.findElement(zipCodeLocator).sendKeys(zipCode);
    }

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberLocator).sendKeys(phoneNumber);
    }

    public void setAccount(String account) {
        driver.findElement(accountLocator).sendKeys(account);
    }

    public void setVerifyAccount(String verifyAccount) {
        driver.findElement(verifyAccountLocator).sendKeys(verifyAccount);
    }

    public void setAmount(String amount) {
        driver.findElement(amountLocator).sendKeys(amount);
    }

    public void clickSendPaymentButton() {
        driver.findElement(sendPaymentButton).click();
    }

    public void fillPayeeDetails(String payeeName, String address, String city, String state,
                                 String zipCode, String phoneNumber, String account,
                                 String verifyAccount, String amount) {
        setPayeeName(payeeName);
        setAddress(address);
        setCity(city);
        setState(state);
        setZipCode(zipCode);
        setPhoneNumber(phoneNumber);
        setAccount(account);
        setVerifyAccount(verifyAccount);
        setAmount(amount);
    }

    // Utility method to wait for an element
    private WebElement waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Method to get the success message
    public String getBillPayCompleteMessage() {
        WebElement messageElement = waitForElement(succesMessageLocator);
        return messageElement.getText();
    }

    // Method to get the validation message for empty field
    public String getErrorMessageForEmptyAccountNumberField() {
        WebElement errorElement = waitForElement(errorMessageEmptyAccountNumberField);
        return errorElement.getText();
    }

}

