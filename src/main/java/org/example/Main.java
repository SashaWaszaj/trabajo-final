package org.example;

import Pages.LoginRegister;
import Pages.EnteringPayeeInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        // Set up WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Navigate to the website
        driver.get("https://parabank.parasoft.com/parabank/");

        LoginRegister login = new LoginRegister(driver);
        EnteringPayeeInformation enteringPayeeInfo = login.handleLoginOrRegister(
                "sasha",      // Login Username
                "12345",               // Login Password
                "Sasha",               // First Name for Registration
                "Smith",               // Last Name
                "123 Main St",         // Address
                "Los Angeles",         // City
                "CA",                  // State
                "90001",               // Zip Code
                "1234567890",          // Phone Number
                "987654321",           // SSN
                "sasha",               // Registration Username
                "12345"                // Registration Password
        );


        // Click "Bill Pay" button to navigate to the bill payment section
        enteringPayeeInfo.clickBillPayButton();

        // Fill in payee details
        enteringPayeeInfo.fillPayeeDetails(
                "Sasha Waszaj",              // Payee Name
                "123 Street",                           // Address
                "Encarnacion",                          // City
                "Itapua",                               // State
                "6000",                                 // Zip Code
                "1234567890",                           // Phone Number
                "987654321",                            // Account
                "987654321",                            // Verify Account
                "500"                                   // Amount
        );

        // Submit the payment
        enteringPayeeInfo.clickSendPaymentButton();

        // Close the browser
        //driver.quit();
    }
}
