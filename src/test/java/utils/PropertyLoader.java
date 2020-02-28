package test.java.utils;

import java.util.ResourceBundle;

public class PropertyLoader {
    private static ResourceBundle src = ResourceBundle.getBundle("config");

    public static String getProperty(String value){
        return src.getString(value);
    }

}
