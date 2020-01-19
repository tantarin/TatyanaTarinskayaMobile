package hw_3.pages.nativePages;

import hw_2.pages.AbstractBasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegistrationPage extends AbstractBasePage {

    public RegistrationPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(id = APP_PACKAGE_NAME + "registration_email")
    private
    WebElement registration_email;
    @FindBy(id = APP_PACKAGE_NAME + "registration_username")
    private
    WebElement registration_username;
    @FindBy(id = APP_PACKAGE_NAME + "registration_password")
    private
    WebElement registration_password;
    @FindBy(id = APP_PACKAGE_NAME + "registration_confirm_password")
    private
    WebElement registration_confirm_password;
    @FindBy(id = APP_PACKAGE_NAME + "register_new_account_button")
    private
    WebElement register_new_account_button;

    public WebElement getRegistrationEmail()  {
        return registration_email;
    }

    public void registerNewUser(String email, String userName, String password){
        String text = "REGISTER NEW ACCOUNT";
        registration_email.sendKeys(email);
        registration_username.sendKeys(userName);
        registration_password.sendKeys(password);
        registration_confirm_password.sendKeys(password);
        driver.hideKeyboard();
        register_new_account_button.click();
    }
}

