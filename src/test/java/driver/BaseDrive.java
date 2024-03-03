package driver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import static utils.PropertiesDataParser.loadProperties;
import static utils.TakeScreenshot.screenshotForAllure;


public class BaseDrive {

    public static AndroidDriver driver = null;

    @BeforeSuite
    public static void driverSetup() throws MalformedURLException, URISyntaxException {
        Properties properties = loadProperties("config");
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("platformName", "Android");
        capability.setCapability("udid", "emulator-5554");
        capability.setCapability("automationName", "UiAutomator2");

        File appDir = new File("src/test/java/resources/apk");
        File appName = new File(appDir, properties.getProperty("apk_file_name"));
        capability.setCapability("app", appName.getAbsolutePath());

        URL serverUrl = new URI(properties.getProperty("appium_server_url")).toURL();

        driver = new AndroidDriver(serverUrl, capability);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterMethod
    public void checkFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            screenshotForAllure(result.getName());
        }
    }

    @AfterSuite
    public static void driverTeardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}