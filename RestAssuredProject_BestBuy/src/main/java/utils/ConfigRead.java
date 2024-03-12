package utils;

import java.io.*;
import java.util.Properties;

public class ConfigRead {
    public static Properties configProperties(String fileName) throws IOException {
       fileName = fileName.trim();
       Properties configProperties = new Properties();
       InputStream inStream = new FileInputStream(fileName);
       configProperties.load(inStream);
       return configProperties;
    }
}
