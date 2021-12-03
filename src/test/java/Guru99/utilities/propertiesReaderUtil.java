package Guru99.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propertiesReaderUtil {

    private static Properties properties = new Properties();

    static {

        String pathOfConfigFile = "configuration.properties";

        try {
            FileInputStream fileInputStream = new FileInputStream(pathOfConfigFile);

            properties.load(fileInputStream);
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Properties file not found");

        }

    }
    public static String getProperty (String property) {return properties.getProperty(property);}
}
