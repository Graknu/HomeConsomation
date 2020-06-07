package fr.barroux.homeconsomation.options;

import fr.barroux.homeconsomation.HomeConsume;
import fr.barroux.homeconsomation.database.DatabaseManager;
import fr.barroux.homeconsomation.menu.MenuAction;
import fr.barroux.homeconsomation.utils.ConsoleUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DeleteFournisseur implements MenuAction {

    DatabaseManager db = HomeConsume.getDB();
    Scanner scanner = new Scanner(System.in);
    HashMap<Integer, String> fournisseurs;

    @Override
    public boolean test() throws SQLException {
        return true;
    }

    @Override
    public void task() throws SQLException {
        fournisseurs = new HashMap<>();

        ResultSet result = db.getStatement().executeQuery("SELECT * FROM fournisseurs");
        System.out.println("-----------------------------------------");
        System.out.println(ConsoleUtils.textInfo("Liste des fournnisseurs : "));
        while (result.next())
        {
            System.out.println(result.getInt("id") + " - " + result.getString("nom") + " - " + result.getString("type"));
            fournisseurs.put(result.getInt("id"), result.getString("nom"));
        }
        System.out.println("-----------------------------------------");
        System.out.print("Saisir le numéro du founisseur à supprimer : ");
        Integer choice = scanner.nextInt();

        if (fournisseurs.containsKey(choice))
        {
            PreparedStatement statement = db.getConnect().prepareStatement("DELETE FROM fournisseurs WHERE id = ?");
            statement.setInt(1, choice);
            Integer op = statement.executeUpdate();

            if (op == 1)
            {
                System.out.println(ConsoleUtils.textSuccess("Fournisseur supprimé avec succès !"));
            }
            else
            {
                System.out.println(ConsoleUtils.textWarning("Un problème est survenue, merci de conctacter l'administrateur !"));
            }

        }
        else
        {
            System.out.println(ConsoleUtils.textWarning("Le fournisseur est inexistant !"));
        }



    }
}
