package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utils {
    static Properties prop = new Properties();
    public static void loadPropertyFile() {
        try {
            System.out.println(System.getProperty("user.dir"));
            prop.load(new FileInputStream("config/config.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getProperty(String key) {

        loadPropertyFile();
        return prop.getProperty(key);

    }
}
