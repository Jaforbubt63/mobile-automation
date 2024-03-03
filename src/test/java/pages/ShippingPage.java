package pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ShippingPage extends BasePage {

    By nextDayAirLocator = By.xpath("(//*[@text='Next Day Air'])[1]");
    By btnContinueLocator = By.xpath("(//*[@text='CONTINUE'])[2]");

    public ShippingPage(AndroidDriver driver) {
        super(driver);
    }

    @Step("Select 'Next Day Air' then continue")
    public void selectNextDayAirThenContinue() {
        swipeDownToUp(2);
        clickOnElement(nextDayAirLocator);
        clickOnElement(btnContinueLocator);
    }


}
