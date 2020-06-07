package fr.barroux.homeconsomation.menu;

import fr.barroux.homeconsomation.utils.ConsoleUtils;

import java.sql.SQLException;
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

    public int getEntries() throws SQLException {
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

            System.out.print("Saisir le code menu : ");
            choice = ScInput.next();
            System.out.print("\n");

            if (options.containsKey(choice))
            {
                actionChoice = actions.get(choice);
                if (actionChoice.test() != false)
                {
                    actionChoice.task();
                }
            } else
            {
                System.out.println(ConsoleUtils.textWarning("Code inconnu."));
            }

        }

        return 0;
    }

    public void quitMenu()
    {
        isactive = false;
    }

}
