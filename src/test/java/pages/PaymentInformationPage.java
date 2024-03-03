package pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class PaymentInformationPage extends BasePage {

    By nextBtnLocator = By.xpath("//*[@text='Next']");

    public PaymentInformationPage(AndroidDriver driver) {
        super(driver);
    }

    @Step("Click on next button")
    public void clickOnNextBtn() {
        clickOnElement(nextBtnLocator);
    }

}
