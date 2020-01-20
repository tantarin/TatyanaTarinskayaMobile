package hw_3.scenarios;

import hw_3.setup.Driver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;

public class Hooks extends Driver {
    protected String email;
    protected String username;
    protected String password;

    @BeforeGroups(groups = {"native"}, description = "Prepare driver to run native test(s)")
    public void setUpNative() throws Exception {
        propertyFileName = "native";
        platformName = "Android";
        email = getProp("email");
        username = getProp("username");
        password = getProp("password");
        prepareDriver();
        System.out.println("Driver fot native tests prepared");
    }

    @BeforeGroups(groups = {"web"}, description = "Prepare driver to run web test(s)")
    public void setUpWeb() throws Exception {
        propertyFileName = "web";
        platformName = "Android";
        prepareDriver();
        System.out.println("Driver for web tests prepared");
    }

    @AfterGroups(groups = {"native", "web"}, description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver().quit();
        System.out.println("Driver closed");
    }
}
