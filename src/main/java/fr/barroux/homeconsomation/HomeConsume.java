package fr.barroux.homeconsomation;

import java.util.ArrayList;

public class HomeConsume {

    private static ArrayList<String> menuList;

    public static void main(String[] args) {

        Menu menu = new Menu();

        menu.addHeaders("Bienvenue !");
        menu.addEntries("a", "Ajouter une facture");
        menu.addEntries("c", "Consulter les factures");

        menuList = menu.getEntries();

        for (String s : menuList){
            System.out.println(s);
        }

    }

}
