package hw_3.setup;

import hw_3.api.MobileCloudRestApi;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;


public class Driver extends TestProperties {

    private static AppiumDriver driverSingle = null;
    private static WebDriverWait waitSingle;
    protected static String platformName;

    protected String SUT; // site under testing

    public Driver() {
    }

    protected void prepareDriver() throws Exception {
        String DRIVER = getProp("driver");
        String BROWSER; //chrome or safari
        //using in tests
        String t_sut = getProp("sut");
        SUT = t_sut == null ? null : "https://" + t_sut;
        String APP_PACKAGE = getProp("app_package");
        String APP_ACTIVITY = getProp("app_activity");
        String AUTOMATION_NAME = getProp("automation_name");
        String UDID;
        File app;



        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", AUTOMATION_NAME);

        switch (platformName) {
            case "Android":
                UDID = getProp("udidAndroid");
                capabilities.setCapability(MobileCapabilityType.UDID, UDID);
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                BROWSER = "Chrome";
                break;
            case "IOS":
                UDID = getProp("udidIOS");
                capabilities.setCapability(MobileCapabilityType.UDID, UDID);
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
                BROWSER = "Safari";
                break;
            default:
                throw new Exception("Unknown mobile platform");
        }


        switch (propertyFileName) {
            case "web":
                capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BROWSER);
                driverSingle = new AppiumDriver(new URL(DRIVER), capabilities);
                if(waitSingle == null) waitSingle = new WebDriverWait(driverSingle, 10);
                break;
            case "native":
                if(platformName.equals("Android")) {
                    String AUT = getProp("appNameAndroid");  //  app under testing
                    app = new File(AUT);
                    capabilities.setCapability("appPackage", APP_PACKAGE);
                    capabilities.setCapability("appActivity", APP_ACTIVITY);
                    capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
                } else {
                    String AUT = getProp("appNameIOS");
                    app = new File(AUT);
                    capabilities.setCapability("bundleId", getProp("bundleId"));
                }
                MobileCloudRestApi
                        .with()
                        .file(app)
                        .serial(UDID)
                        .installApp();
                MobileCloudRestApi
                        .with()
                        .getDevice();
                
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
