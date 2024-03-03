package pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ShoppingCartPage extends BasePage {

    By mattressBedroomTitleLocator = By.xpath("//*[@text='Mattress Bedroom']");
    By itemQuantityLocator = By.id("tvItemQuantity");
    By btnCheckOutLocator = By.id("btnCheckOut");
    By btnGuestCheckoutLocator = By.id("btnGuestCheckout");

    public ShoppingCartPage(AndroidDriver driver) {
        super(driver);
    }

    @Step("Check if mattress bedroom title visible")
    public Boolean isMattressBedroomTitleVisible() {
        return isElementVisible(mattressBedroomTitleLocator);
    }

    @Step("Get product item quantity")
    public String getItemQuantity() {
        return getText(itemQuantityLocator);
    }

    @Step("Checkout as guest")
    public void checkoutAsGuest() {
        clickOnElement(btnCheckOutLocator);
        clickOnElement(btnGuestCheckoutLocator);
    }

}
