package pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class ConfirmPage extends BasePage {

    By orderDetailsLocator = By.id("tvCardDetails2");
    By subTotalPriceLocator = By.id("tvSubTotal");
    By totalPriceLocator = By.id("tvTotal");
    By confirmBtnLocator = By.id("checkoutButton");
    By orderSuccessfulMessageLocator = By.id("md_text_message");

    public ConfirmPage(AndroidDriver driver) {
        super(driver);
    }

    @Step("Get order details")
    public ArrayList<String> getOrderDetails() {
        return getListOfText(orderDetailsLocator);
    }

    @Step("Get sub-total price")
    public String getSubTotalPrice() {
        return getText(subTotalPriceLocator);
    }

    @Step("Get total price")
    public String getTotalPrice() {
        return getText(totalPriceLocator);
    }

    @Step("Click on comfirm order button")
    public void comfirmOrder() {
        clickOnElement(confirmBtnLocator);
    }

    @Step("Get order successful message")
    public String getOrderSuccessfulMessage() {
        return getText(orderSuccessfulMessageLocator);
    }


}
