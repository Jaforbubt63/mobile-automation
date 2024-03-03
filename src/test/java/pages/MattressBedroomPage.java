package pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MattressBedroomPage extends BasePage {

    By plusBtnLocator = By.id("btnPlus");
    By addToCartBtnLocator = By.id("btnAddToCart");
    By cartMenuLocator = By.id("menu_cart");

    public MattressBedroomPage(AndroidDriver driver) {
        super(driver);
    }

    @Step("Increase product quantity by clicking on plus icon")
    public void increaseProductQuantity(int count) {
        for (int i = 0; i < count; i++) {
            clickOnElement(plusBtnLocator);
        }
    }

    @Step("Wait until add to cart button is visible")
    public void waitForAddToCartBtnVisibility() {
        waitForVisibilityOfElement(addToCartBtnLocator);
    }

    @Step("Add product to cart")
    public void addProductToCart() {
        clickOnElement(addToCartBtnLocator);
    }

    @Step("Go to shopping cart")
    public void goToShoppingCart() {
        clickOnElement(cartMenuLocator);
    }

}
