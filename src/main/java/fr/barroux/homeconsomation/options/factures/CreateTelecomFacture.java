package fr.barroux.homeconsomation.options.factures;

import fr.barroux.homeconsomation.HomeConsume;
import fr.barroux.homeconsomation.database.DatabaseManager;
import fr.barroux.homeconsomation.menu.MenuAction;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateTelecomFacture implements MenuAction {

    private DatabaseManager db = HomeConsume.getDB();
    private Date date = new Date();

    @Override
    public boolean test() throws SQLException {
        return true;
    }

    @Override
    public void task() throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(sdf.format(date));

    }
}
