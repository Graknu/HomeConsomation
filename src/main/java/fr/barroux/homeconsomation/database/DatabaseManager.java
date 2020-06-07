package fr.barroux.homeconsomation.database;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseManager {

    private String ip;
    private String port = "3306";
    private String username;
    private String password;
    private String database;
    private String dbUrl;
    private Connection connect;

    public DatabaseManager(String dbIp, String dbUsername, String dbPassword, String dbDatabase) throws ClassNotFoundException {
        Class.forName( "com.mysql.jdbc.Driver" );

        ip = dbIp;
        username = dbUsername;
        password = dbPassword;
        database = dbDatabase;
        dbUrl = "jdbc:mysql://" + ip + ":" + port + "/" + database;

    }

    public void connnect() {
        try {
            connect = DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void close() throws SQLException {
        if (connect != null) {
            connect.close();
        }
    }

    public Statement getStatement() throws SQLException {
        Statement statement = connect.createStatement();

        return statement;
    }

    public Connection getConnect()
    {
        return connect;
    }

    public boolean isExist(String table,String column, String occurence) throws SQLException {
        ResultSet test = getStatement().executeQuery("SELECT * FROM " + table + ";");
        ArrayList<String> list = new ArrayList<>();

        while (test.next())
        {
            list.add(test.getString(column).toLowerCase());
        }

        if (list.contains(occurence.toLowerCase()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
