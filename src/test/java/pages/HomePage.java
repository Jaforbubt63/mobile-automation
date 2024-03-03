package pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    By progressWheelLocator = By.id("progress_wheel");
    By acceptBtnLocator = By.id("btnAccept");
    By productThumbLocator = By.id("ivProductThumb");
    By categoryNameLocator = By.id("tvProductName");
    By electronicsCategoryLocator = By.xpath("//*[@text='Electronics']");
    By foodGroceryCategoryLocator = By.xpath("//*[@text='Food & Grocery']");
    By outdoorCategoryLocator = By.xpath("//*[@text='Outdoor']");


    public HomePage(AndroidDriver driver) {
        super(driver);
    }

    @Step("Wait until loader spinner is invisible")
    public void waitForLoaderRemove() {
        waitForInvisibilityOfElement(progressWheelLocator);
    }

    @Step("Accept Terms and Conditions")
    public void acceptCondition() {
        waitForVisibilityOfElement(acceptBtnLocator);
        clickOnElement(acceptBtnLocator);
    }

    @Step("Swipe left & select electronics category")
    public void selectElectronicsCategory() {
        waitForVisibilityOfElements(productThumbLocator);
        swipeRightToLeft(foodGroceryCategoryLocator);
        swipeRightToLeft(outdoorCategoryLocator);
        clickOnElement(electronicsCategoryLocator);
    }

}
