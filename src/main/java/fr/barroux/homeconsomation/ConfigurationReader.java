package fr.barroux.homeconsomation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConfigurationReader {

    private String filePath;
    private Properties properties;

    public ConfigurationReader(String fileConfig)
    {
        this.filePath = fileConfig;

        properties = new Properties();

        InputStream is = null;

        try {
            is = new FileInputStream(fileConfig);
            properties.load(is);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String read(String key)
    {
        return properties.getProperty(key);
    }

    public boolean keyIsPresent(String key)
    {
        if (properties.containsKey(key))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}