package fr.barroux.homeconsomation;

import fr.barroux.homeconsomation.menu.Menu;
import fr.barroux.homeconsomation.menu.MenuAction;

import java.util.ArrayList;

public class HomeConsume {

    private static ArrayList<String> menuList;

    public static void main(String[] args) {

        Menu menu = new Menu();

        menu.addHeaders("Bienvenue !");
        menu.addEntries("a", "Ajouter une facture", new MenuAction() {
            @Override
            public void task() {
                System.out.println("Code a");
            }
        });
        menu.addEntries("c", "Consulter les factures", new MenuAction() {
            @Override
            public void task() {
                System.out.println("Code c");
            }
        });
        menu.addEntries("q", "Quitter le programme", new MenuAction() {
            @Override
            public void task() {
                menu.quitMenu();
                System.out.println("Tacho bye !");
            }
        });

        menu.getEntries();

    }

}
