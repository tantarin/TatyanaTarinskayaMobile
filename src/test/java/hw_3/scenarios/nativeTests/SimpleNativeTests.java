package hw_3.scenarios.nativeTests;


import hw_3.pages.nativePages.BudgetPage;
import hw_3.pages.nativePages.LoginPage;
import hw_3.pages.nativePages.RegistrationPage;
import hw_3.scenarios.Hooks;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = {"native"})
public class SimpleNativeTests extends Hooks {

    @Test(description = "Register a new account and sign in")
    public void simplestTest() throws Exception {
        LoginPage loginPage = new LoginPage(driver());
        driverWait().until(ExpectedConditions.visibilityOf(loginPage.getRegisterButton()));
        loginPage.registerButtonClick();
        RegistrationPage registrationPage = new RegistrationPage(driver());
        driverWait().until(ExpectedConditions.visibilityOf(registrationPage.getRegistrationEmail()));
        registrationPage.registerNewUser(email,username,password);
        driverWait().until(ExpectedConditions.visibilityOf(loginPage.getLoginEmailInput()));
        loginPage.signIn(email, password);
        BudgetPage budgetPage = new BudgetPage(driver());
        Assert.assertEquals(budgetPage.getBudgetPageTitle(), "BudgetActivity");
    }
}
