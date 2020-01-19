package hw_2.pages;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;
import hw_2.setup.Driver;

public class AbstractBasePage {
    protected AppiumDriver driver;

    protected final String APP_PACKAGE_NAME = "platkovsky.alexey.epamtestapp:id/";

    protected AbstractBasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
