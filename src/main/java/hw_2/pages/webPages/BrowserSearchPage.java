package hw_2.pages.webPages;

import io.appium.java_client.AppiumDriver;
import hw_2.pages.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class BrowserSearchPage extends AbstractBasePage {

    public BrowserSearchPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='q']")
    private
    WebElement textInput;
    @FindBy(xpath = "//div[@id='search']")
    private
    WebElement searchResult;

    public void searchInfoAbout(String info) {
        textInput.sendKeys(info + "\n");
    }

    public WebElement getSearchResult(){
        return searchResult;
    }
}

