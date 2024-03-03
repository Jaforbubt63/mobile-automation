package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class BasePage {

    AndroidDriver driver;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public int getTotalElementCount(By locator) {
        return getElements(locator).size();
    }

    public void sendText(By locator, String value) {
        WebElement element = getElement(locator);
        element.clear();
        element.sendKeys(value);
    }

    public void clickOnElement(By locator) {
        waitForElementToBeClickable(locator);
        getElement(locator).click();
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    public String getAttribute(By locator, String attribute) {
        WebElement element = getElement(locator);
        return element.getAttribute(attribute);
    }

    public String getText(By locator) {
        return getElement(locator).getText().trim();
    }

    public ArrayList<String> getListOfText(By locator) {
        ArrayList<String> text_list = new ArrayList<>();
        for (WebElement element : getElements(locator)) {
            text_list.add(element.getText().trim());
        }
        return text_list;
    }

    public void waitForVisibilityOfElement(By locator, int... maxWait) {
        int waitTime = (maxWait.length > 0) ? maxWait[0] : 30;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForVisibilityOfElements(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void waitForInvisibilityOfElement(By locator, int... maxWait) {
        int waitTime = (maxWait.length > 0) ? maxWait[0] : 30;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForInvisibilityOfElements(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOfAllElements(getElements(locator)));
    }

    public void waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForTextToBePresentInElement(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public boolean isElementVisible(By locator) {
        try {
            waitForVisibilityOfElement(locator, 10);
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public void swipeRightToLeft(By elementLocator) {
        WebElement element = getElement(elementLocator);
        // Get the size of the screen
        Dimension size = driver.manage().window().getSize();

        // Find the coordinates for the starting and ending points of the swipe
        int startX = (int) (size.width * 0.9);
        int endX = (int) (size.width * 0.1);
        int startY = element.getLocation().getY() + (element.getSize().height / 2);

        // Perform swipe action using TouchAction
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(PointOption.point(startX, startY))
                .moveTo(PointOption.point(endX, startY))
                .release()
                .perform();
    }


    public void swipeDownToUp(int swipeCount) {
        for (int i = 0; i < swipeCount; i++) {
            // Get the size of the screen
            Dimension size = driver.manage().window().getSize();

            // Find the coordinates for the starting and ending points of the swipe
            int startX = size.width / 2;
            int startY = (int) (size.height * 0.8);
            int endY = (int) (size.height * 0.5);

            // Perform swipe action using TouchAction
            TouchAction touchAction = new TouchAction(driver);
            touchAction.longPress(PointOption.point(startX, startY))
                    .moveTo(PointOption.point(startX, endY))
                    .release()
                    .perform();
        }
    }


}