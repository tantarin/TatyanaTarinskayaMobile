package hw_3.pages;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractBasePage {
    protected AppiumDriver driver;

    protected final String APP_PACKAGE_NAME = "platkovsky.alexey.epamtestapp:id/";

    protected AbstractBasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
