package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.NoSuchElementException;

public class LoginRegister {
    private WebDriver driver;

    private By userNameLocator = By.name("username");
    private By passwordLocator = By.name("password");
    private By loginButton = By.cssSelector("input.button");
    private By registerLink = By.linkText("Register"); // Corrected naming convention
    private By firstNameLocator = By.id("customer.firstName");
    private By lastNameLocator = By.id("customer.lastName");
    private By addressLocator = By.id("customer.address.street");
    private By cityLocator = By.id("customer.address.city");
    private By stateLocator = By.id("customer.address.state");
    private By zipCodeLocator = By.id("customer.address.zipCode");
    private By phoneNumberLocator = By.id("customer.phoneNumber");
    private By SSNLocator = By.id("customer.ssn");
    private By registerUserNameLocator = By.id("customer.username");
    private By registerPasswordLocator = By.id("customer.password");
    private By confirmPasswordLocator = By.id("repeatedPassword");
    private By registerButton = By.cssSelector("tr td input.button");
    private By errorMessageLocator = By.cssSelector("p.error");

    public LoginRegister(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String userName) {
        driver.findElement(userNameLocator).sendKeys(userName);
    }

    public void setPassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void clickRegisterLink() {
        driver.findElement(registerLink).click();
    }

    public void setFirstName(String firstName) {
        driver.findElement(firstNameLocator).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(lastNameLocator).sendKeys(lastName);
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

    public void setSSN(String ssn) {
        driver.findElement(SSNLocator).sendKeys(ssn);
    }

    public void setRegisterUserName(String registerUserName) {
        driver.findElement(registerUserNameLocator).sendKeys(registerUserName);
    }

    public void setRegisterPassword(String registerPassword) {
        driver.findElement(registerPasswordLocator).sendKeys(registerPassword);
    }

    public void setConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordLocator).sendKeys(confirmPassword);
    }

    public EnteringPayeeInformation handleLoginOrRegister(String userName, String password,
                                                          String firstName, String lastName,
                                                          String address, String city,
                                                          String state, String zipCode,
                                                          String phoneNumber, String ssn,
                                                          String registerUserName, String registerPassword) {
        // Attempt login
        setUserName(userName);
        setPassword(password);
        driver.findElement(loginButton).click();

        // Check for error message
        if (isErrorMessagePresent()) {
            // Navigate to the registration page
            driver.findElement(registerLink).click();

            // Fill in registration details
            setFirstName(firstName);
            setLastName(lastName);
            setAddress(address);
            setCity(city);
            setState(state);
            setZipCode(zipCode);
            setPhoneNumber(phoneNumber);
            setSSN(ssn);
            setRegisterUserName(registerUserName);
            setRegisterPassword(registerPassword);
            setConfirmPassword(registerPassword);

            // Submit registration
            driver.findElement(registerButton).click();
        }

        return new EnteringPayeeInformation(driver);
    }

    // Check for the presence of the error message
    private boolean isErrorMessagePresent() {
        try {
            return driver.findElement(errorMessageLocator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}

