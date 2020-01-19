package hw_2.setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.net.URL;


public class Driver extends TestProperties {

    private static AppiumDriver driverSingle = null;
    private static WebDriverWait waitSingle;

    protected String SUT; // site under testing

    public Driver() {
    }

    protected void prepareDriver() throws Exception {
        String PLATFORM_NAME = getProp("platformName"); //ios or driver
        String DRIVER = getProp("driver");
        String DEVICE_NAME = getProp("device");
        String BROWSER;
        String t_sut = getProp("sut");
        SUT = t_sut == null ? null : "https://" + t_sut;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);

        switch (PLATFORM_NAME) {
            case "Android":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
                BROWSER = "Chrome";
                break;
            case "IOS":
                BROWSER = "Safari";
                break;
            default:
                throw new Exception("Unknown mobile platform");
        }
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);

        switch (propertyFileName) {
            case "web":
                String chromeDriver = getProp("chromedriver");
                File chrome = new File(chromeDriver);
                capabilities.setCapability("chromedriverExecutable", chrome.getAbsolutePath());
                capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BROWSER);
                driverSingle = new AppiumDriver(new URL(DRIVER), capabilities);
                if(waitSingle == null) waitSingle = new WebDriverWait(driverSingle, 10);
                break;
            case "native":
                String AUT = getProp("appName");  //  app under testing
                File app = new File(AUT);
                capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
                driverSingle = new AppiumDriver(new URL(DRIVER), capabilities);
                if(waitSingle == null) waitSingle = new WebDriverWait(driverSingle, 10);
                break;
            default:
                throw new Exception("Unclear type of mobile app");
        }

        }
    protected AppiumDriver driver() throws Exception {
        if(driverSingle == null) prepareDriver();
        return driverSingle;
    }

    protected WebDriverWait driverWait() throws Exception {
        return waitSingle;
    }
}
