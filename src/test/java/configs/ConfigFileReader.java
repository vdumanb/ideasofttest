package configs;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {
    private static Properties properties;
    private static final String propertyFilePath = "src//test//java//configs//test.properties";
    //private static final String propertyFilePath = "src//test//java//configs//uat.properties";

    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("test.properties not found at " + propertyFilePath);
        }
    }
    public static String fileProperty (String key){
        String driverPath = properties.getProperty(key);
        if (driverPath != null) return driverPath;
        else throw new RuntimeException("key not specified in the file.");
    }


}
