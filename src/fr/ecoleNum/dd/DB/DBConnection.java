package fr.ecoleNum.dd.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private static Connection connection;

    private DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            Properties env = Env.getEnv();

            String id = env.getProperty("id");
            String password = env.getProperty("password");
            String database = env.getProperty("database");
            String ip = env.getProperty("ip");

            connection = DriverManager.getConnection("jdbc:mysql://"+ip+"/"+database, id, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static Connection  getInstance() {
        if (connection == null) {
            new DBConnection();
        }
        return connection;
    }

}
