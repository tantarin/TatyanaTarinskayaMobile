package hw_2.scenarios;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import hw_2.setup.Driver;

import java.io.IOException;

public class Hooks extends Driver {
    protected String email;
    protected String username;
    protected String password;

    @BeforeGroups(groups = {"native"}, description = "Prepare driver to run native test(s)")
    public void setUpNative() throws Exception {
        propertyFileName = "native";
        email = getProp("email");
        username = getProp("username");
        password = getProp("password");
        prepareDriver();
        System.out.println("Driver fot native tests prepared");
    }

    @BeforeGroups(groups = {"web"}, description = "Prepare driver to run web test(s)")
    public void setUpWeb() throws Exception {
        propertyFileName = "web";
        prepareDriver();
        System.out.println("Driver for web tests prepared");
    }

    @AfterGroups(groups = {"native", "web"}, description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver().quit();
        System.out.println("Driver closed");
    }
}
