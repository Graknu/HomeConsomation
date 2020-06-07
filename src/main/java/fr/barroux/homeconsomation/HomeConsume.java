package fr.barroux.homeconsomation;

import fr.barroux.homeconsomation.database.DatabaseManager;
import fr.barroux.homeconsomation.menu.Menu;
import fr.barroux.homeconsomation.menu.MenuAction;
import fr.barroux.homeconsomation.options.CreateFounisseur;
import fr.barroux.homeconsomation.options.DeleteFournisseur;
import fr.barroux.homeconsomation.options.ListFournisseur;
import fr.barroux.homeconsomation.utils.ConsoleUtils;

import java.sql.SQLException;
import java.util.ArrayList;

public class HomeConsume {

    private static ArrayList<String> menuList;
    private static DatabaseManager db;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.setProperty( "file.encoding", "UTF-8" );
        db = new DatabaseManager("127.0.0.1", "root", "root", "homeconsomation");
        db.connnect();


        Menu menu = new Menu();

        menu.addHeaders(ConsoleUtils.textInfo("\nBienvenue !"));

        menu.addEntries("cf", "Créer un fournisseur", new CreateFounisseur());
        menu.addEntries("sf", "Supprimer un fournisseur", new DeleteFournisseur());
        menu.addEntries("lf", "Lister les fournisseurs", new ListFournisseur());

        menu.addEntries("c", "Créer une facture", new MenuAction() {
            @Override
            public boolean test() {
                return true;
            }

            @Override
            public void task() {
                System.out.println("Création facture");
            }
        });
        menu.addEntries("s", "Supprimer une facture", new MenuAction() {
            @Override
            public boolean test() {
                return true;
            }

            @Override
            public void task() {
                System.out.println("Supprimer facture");
            }
        });
        menu.addEntries("v", "Visualisation globale", new MenuAction() {
            @Override
            public boolean test() {
                return false;
            }

            @Override
            public void task() {
                System.out.println("Visualisation globale");
            }
        });
        menu.addEntries("q", "Quitter le programme", new MenuAction() {
            @Override
            public boolean test() {
                return true;
            }

            @Override
            public void task() throws SQLException {
                menu.quitMenu();
                db.close();
                System.out.println("Tacho bye !");
            }
        });

        menu.getEntries();

    }

    public static DatabaseManager getDB()
    {
        return db;
    }

}
