package pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class PaymentPage extends BasePage {

    By checkMoneyOrderLocator = By.xpath("//*[@text='Check / Money Order']");
    By btnContinueLocator = By.xpath("(//*[@text='CONTINUE'])[2]");

    public PaymentPage(AndroidDriver driver) {
        super(driver);
    }

    @Step("Select 'Check/Money Order' then continue")
    public void selectCheckMoneyOrderThenContinue() {
        swipeDownToUp(7);
        clickOnElement(checkMoneyOrderLocator);
        clickOnElement(btnContinueLocator);
    }

}
