package com.pragmatic.selenium.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static final Properties properties = new Properties();

    static {
        try {
            FileInputStream inputStream = new FileInputStream("src/test/resources/config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ConfigurationReader() {
    }

    /**
     *
     * @param key is a field in properties file eg: BASE_URL
     * @return key in properties file
     */
    public static String get(String key){
        return  properties.getProperty(key).trim();//Key is a field in properties file
    }

    public static String getBaseURL(){
        return get("BASE_URL");
    }

    public static String getBrowser(){
        return get("BROWSER");
    }

    public static int getTimeout(){
        String timeout = get("TIMEOUT");
        return Integer.parseInt(timeout);
    }
}
