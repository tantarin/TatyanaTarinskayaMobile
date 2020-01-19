package hw_3.setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class TestProperties {
    public static String propertyFileName;

    private Properties currentProps = new Properties();

    private Properties getCurrentProps() throws IOException {
        FileInputStream in = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/"+propertyFileName+".properties");
        currentProps.load(in);
        in.close();
        return currentProps;
    }

    protected String getProp(String propKey) throws IOException {
        if(!currentProps.containsKey(propKey)) currentProps = getCurrentProps();
        return currentProps.getProperty(propKey, null);
    }
}
