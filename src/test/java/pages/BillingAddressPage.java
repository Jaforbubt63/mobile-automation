package pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class BillingAddressPage extends BasePage {

    By firstNameInputLocator = By.id("etFirstName");
    By lastNameInputLocator = By.id("etLastName");
    By emailInputLocator = By.id("etEmail");
    By countrySpinnerLocator = By.id("countrySpinner");
    By stateSpinnerLocator = By.id("stateSpinner");
    By listFirstItemLocator = By.xpath("//android.widget.TextView[@index='1']");
    By companyInputLocator = By.id("etCompanyName");
    By cityInputLocator = By.id("etCity");
    By streetAddressInputLocator = By.id("etStreetAddress");
    By zipCodeInputLocator = By.id("etZipCode");
    By btnContinueLocator = By.id("btnContinue");


    public BillingAddressPage(AndroidDriver driver) {
        super(driver);
    }

    @Step("Input all the details in checkout billing details page and click continue")
    public void fillBillingDetails(String firstName, String lastName, String email, String companyName,
                                   String city, String streetAddress, String zipCode) {

        sendText(firstNameInputLocator, firstName);
        sendText(lastNameInputLocator, lastName);
        sendText(emailInputLocator, email);

        clickOnElement(countrySpinnerLocator);
        clickOnElement(listFirstItemLocator);

        waitForVisibilityOfElement(stateSpinnerLocator);
        clickOnElement(stateSpinnerLocator);
        clickOnElement(listFirstItemLocator);

        sendText(companyInputLocator, companyName);
        sendText(cityInputLocator, city);
        sendText(streetAddressInputLocator, streetAddress);

        swipeDownToUp(2);
        sendText(zipCodeInputLocator, zipCode);
        clickOnElement(btnContinueLocator);
    }


}
