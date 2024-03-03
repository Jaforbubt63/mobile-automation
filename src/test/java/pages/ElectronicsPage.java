package pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ElectronicsPage extends BasePage {

    By electronicsHeaderLocator = By.xpath("//*[@text='ELECTRONICS']");
    By mattressBedroomLocator = By.xpath("//*[@text='Mattress Bedroom']");

    public ElectronicsPage(AndroidDriver driver) {
        super(driver);
    }

    @Step("Wait until electronics header is visible")
    public void waitForElectronicsHeaderVisibility(){
        waitForVisibilityOfElement(electronicsHeaderLocator);
    }

    @Step("Select Mattress Bedroom")
    public void selectMattressBedroom(){
        clickOnElement(mattressBedroomLocator);
    }

}
