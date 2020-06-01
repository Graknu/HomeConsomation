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
    private List<String> illimtyExcluded;

    public ConfigurationReader(String fileConfig)
    {
        this.filePath = fileConfig;
        this.illimtyExcluded = new ArrayList<>();

        properties = new Properties();

        InputStream is = null;

        try {
            is = new FileInputStream(fileConfig);
            properties.load(is);

            String[] excluded = read("illimityexcluded").split(",");

            if (excluded.length != 0) {
                for (int i = 0; i < excluded.length; i++) {
                    illimtyExcluded.add(excluded[i]);
                }
            }


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

    public boolean isExcluded(String codeAccount)
    {
        if (illimtyExcluded.contains(codeAccount))
        {
            return true;
        }
        else
        {
            return false;
        }
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