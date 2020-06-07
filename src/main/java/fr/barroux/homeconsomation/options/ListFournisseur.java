package fr.barroux.homeconsomation.options;

import fr.barroux.homeconsomation.HomeConsume;
import fr.barroux.homeconsomation.database.DatabaseManager;
import fr.barroux.homeconsomation.menu.MenuAction;
import fr.barroux.homeconsomation.utils.ConsoleUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ListFournisseur implements MenuAction {

    DatabaseManager db = HomeConsume.getDB();

    @Override
    public boolean test() {
        return true;
    }

    @Override
    public void task() throws SQLException {
        System.out.println(ConsoleUtils.textInfo("Liste des fournisseurs"));
        System.out.println("Nom    -    Type");
        ResultSet result = db.getStatement().executeQuery("SELECT * FROM fournisseurs;");
        while (result.next())
        {
            System.out.println("-----------------------------------------");
            System.out.println(result.getString("nom")  + "    -    " + result.getString("type"));
        }
        System.out.println("-----------------------------------------");

    }
}
