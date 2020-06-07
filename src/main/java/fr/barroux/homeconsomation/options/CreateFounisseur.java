package fr.barroux.homeconsomation.options;

import fr.barroux.homeconsomation.HomeConsume;
import fr.barroux.homeconsomation.database.DatabaseManager;
import fr.barroux.homeconsomation.menu.MenuAction;
import fr.barroux.homeconsomation.utils.ConsoleUtils;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateFounisseur implements MenuAction {

    DatabaseManager db = HomeConsume.getDB();
    private String name;
    Scanner ScInput = new Scanner(System.in);

    @Override
    public boolean test() throws SQLException {
        System.out.print("Saisir le nom du founisseur : ");
        name = ScInput.next();
        if (!db.isExist("fournisseurs", "nom", name))
        {
            return true;
        }
        else
        {
            System.out.println(ConsoleUtils.textWarning("Le fournisseur est déjà présent en base."));
            return false;
        }
    }

    @Override
    public void task() throws SQLException {
        System.out.println("-----------------------------------------");
        System.out.println(ConsoleUtils.textInfo("Type de fournnisseur : "));
        System.out.println("Electricité");
        System.out.println("Eau");
        System.out.println("Propriétaire");
        System.out.println("Opérateur");
        System.out.println("Assurances");
        System.out.println("-----------------------------------------");

        System.out.print("Saisir le type du founisseur : ");
        String type = ScInput.next();

            PreparedStatement statement = db.getConnect().prepareStatement("INSERT INTO fournisseurs (nom, type) VALUES (?, ?)");
            statement.setString(1, name);
            statement.setString(2, type);

            Integer op = statement.executeUpdate();

            if (op == 1)
            {
                System.out.println(ConsoleUtils.textSuccess("Fournisseur crée"));
            }
            else
            {
                System.out.println(ConsoleUtils.textWarning("Un problème est survenue, merci de conctacter l'administrateur !"));
            }
    }
}
