package fr.barroux.homeconsomation.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    private HashMap<String, String> options;
    private HashMap<String, MenuAction> actions;
    private ArrayList<String> headers;
    private Boolean isactive;

    public Menu()
    {
        options = new HashMap<>();
        headers = new ArrayList<>();
        actions = new HashMap<>();
        isactive = false;
    }

    public void addHeaders(String header)
    {
        headers.add(header);
    }

    public void addEntries(String code, String option, MenuAction action)
    {
        options.put(code, option);
        actions.put(code, action);
    }

    public void getEntries()
    {
        isactive = true;
        String choice = "";
        MenuAction actionChoice;
        ArrayList<String> allEntries = new ArrayList<>();
        Scanner ScInput = new Scanner(System.in);

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

        while (isactive)
        {
            for (String s : allEntries)
            {
                System.out.println(s);
            }

            System.out.println("Saisir le code menu : ");
            choice = ScInput.next();

            if (options.containsKey(choice))
            {
                actionChoice = actions.get(choice);
                actionChoice.task();
            } else
            {
                System.out.println("Code inconnu.");
            }

        }


    }

    public void quitMenu()
    {
        isactive = false;
    }

}
