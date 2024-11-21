package Tests;

import Pages.EnteringPayeeInformation;
import Pages.LoginRegister;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnteringPayeeInformationTest extends BaseTest{

    @Test
    public void BillPayCompletedSuccessfully() {

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

        // Complete the bill payment
        enteringPayeeInfo.clickBillPayButton();
        enteringPayeeInfo.fillPayeeDetails(
                "Maria",
                "123 Street",
                "Los Angeles",
                "CA",
                "90001",
                "1234567890",
                "9876",
                "9876",
                "500"
        );
        enteringPayeeInfo.clickSendPaymentButton();

        // Verify the success message
        String successMessage = enteringPayeeInfo.getBillPayCompleteMessage();
        String expectedMessage = "Bill Payment Complete";

        assertEquals(expectedMessage, successMessage, "The bill payment was not completed successfully.");
    }

    @Test
    public void UnsuccessfulSubmissionWithEmptyAccountNumberField() {
        driver.get("https://parabank.parasoft.com/parabank/");

        LoginRegister login = new LoginRegister(driver);
        EnteringPayeeInformation enteringPayeeInfo = login.handleLoginOrRegister(
                "sasha",      // Login Username
                "12345",               // Login Password

                "Sasha",               // First Name for Registration
                "Waszaj",               // Last Name
                "123 Main St",         // Address
                "Los Angeles",         // City
                "CA",                  // State
                "90001",               // Zip Code
                "1234567890",          // Phone Number
                "987654321",           // SSN
                "sasha",               // Registration Username
                "12345"                // Registration Password
        );

        // Complete the bill payment except Account field
        enteringPayeeInfo.clickBillPayButton();
        enteringPayeeInfo.fillPayeeDetails(
                "Maria",
                "Palma",
                "Los Angeles",
                "CA",
                "90001",
                "1234567890",
                "",
                "9876",
                "500"
        );
        enteringPayeeInfo.clickSendPaymentButton();

        // Verify the validation message
        String errorMessage = enteringPayeeInfo.getErrorMessageForEmptyAccountNumberField();
        String expectedMessage = "Account number is required.";

        assertEquals(expectedMessage, errorMessage, "The form did not show an error message that matches the expected one.");
    }
}

