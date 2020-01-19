package hw_2.pages.nativePages;

import io.appium.java_client.AppiumDriver;
import hw_2.pages.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends AbstractBasePage {

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(id = APP_PACKAGE_NAME + "login_email")
    private WebElement login_email_input;
    @FindBy(id = APP_PACKAGE_NAME + "login_pwd")
    private WebElement login_pwd_input;
    @FindBy(id = APP_PACKAGE_NAME + "email_sign_in_button")
    private WebElement email_sign_in_button;
    @FindBy(id = APP_PACKAGE_NAME + "register_button")
    private WebElement register_button;

    public WebElement getRegisterButton()  {
        return register_button;
    }

    public WebElement getLoginEmailInput()  {
        return login_email_input;
    }

    public void registerButtonClick()  {
        getRegisterButton().click();
    }

    public void signIn(String email, String password) {
        login_email_input.sendKeys(email);
        login_pwd_input.sendKeys(password);
        email_sign_in_button.click();
    }
}
