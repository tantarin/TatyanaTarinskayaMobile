package hw_2.pages.nativePages;

import io.appium.java_client.AppiumDriver;
import hw_2.pages.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BudgetPage extends AbstractBasePage {

        public BudgetPage(AppiumDriver driver) {
            super(driver);
        }

        @FindBy(xpath = "/hierarchy/android.widget." +
                "FrameLayout/android.widget.LinearLayout/android." +
                "widget.FrameLayout/android.view.ViewGroup/android.widget." +
                "FrameLayout[2]/android.view.ViewGroup/android.widget.TextView")
        private
        WebElement actionBar;

    public WebElement getActionBar()  {
        return actionBar;
    }

    public String getBudgetPageTitle() {
        return actionBar.getText();
    }
}
