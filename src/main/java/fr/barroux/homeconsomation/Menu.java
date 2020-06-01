package fr.barroux.homeconsomation;

import org.w3c.dom.xpath.XPathResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Menu {

    private HashMap<String, String> options;
    private ArrayList<String> headers;

    public Menu()
    {
        options = new HashMap<>();
        headers = new ArrayList<>();
    }

    public void addHeaders(String header)
    {
        headers.add(header);
    }

    public void addEntries(String code, String option)
    {
        options.put(code, option);
    }

    public ArrayList<String> getEntries()
    {

        ArrayList<String> allEntries = new ArrayList<>();

        if (!headers.isEmpty()) {
            for (String s : headers) {
                allEntries.add(s);
            }
        }

        if (!options.isEmpty()) {
            for (Map.Entry<String, String> all : options.entrySet()) {
                String key = all.getKey();
                String value = all.getValue();
                String input = key + " - " + value;
                allEntries.add(input);
            }

        }

        return allEntries;

    }

}
