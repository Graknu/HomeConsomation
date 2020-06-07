package fr.barroux.homeconsomation.menu;

import java.sql.SQLException;

public interface MenuAction {

    boolean test() throws SQLException;

    void task() throws SQLException;
}
