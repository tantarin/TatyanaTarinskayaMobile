package hw_3.scenarios.webTests;

import hw_3.pages.webPages.BrowserSearchPage;
import hw_3.scenarios.Hooks;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = "web")
public class SimpleWebTests extends Hooks {

    String searchText = "EPAM";

    @Test(description = "Search information at google")
    public void webTest() throws Exception {
        BrowserSearchPage browserSearchPage = new BrowserSearchPage(driver());
        driver().get(SUT);
        driverWait().until(ExpectedConditions.urlContains(SUT));
        browserSearchPage.searchInfoAbout(searchText);
        Assert.assertNotNull(browserSearchPage.getSearchResult());
    }
}
