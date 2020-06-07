package fr.barroux.homeconsomation;

import fr.barroux.homeconsomation.menu.Menu;
import fr.barroux.homeconsomation.menu.MenuAction;
import fr.barroux.homeconsomation.options.factures.CreateTelecomFacture;
import fr.barroux.homeconsomation.utils.ConsoleUtils;

import java.sql.SQLException;

public class CreateFacture implements MenuAction {

    private Menu menuFacture;

    @Override
    public boolean test() throws SQLException {
        return true;
    }

    @Override
    public void task() throws SQLException {

        menuFacture = new Menu();
        menuFacture.addHeaders(ConsoleUtils.textInfo("Création des factures"));
        menuFacture.addEntries("t", "Créer facture télécoms", new CreateTelecomFacture());
        menuFacture.addEntries("q", "Revenir au menu principale", new MenuAction() {
            @Override
            public boolean test() throws SQLException {
                return true;
            }

            @Override
            public void task() throws SQLException {
                menuFacture.quitMenu();
            }
        });

        menuFacture.getEntries();

    }
}
