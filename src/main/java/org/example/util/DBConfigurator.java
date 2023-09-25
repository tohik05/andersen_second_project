package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfigurator {
    private static volatile Connection connection;
    private static final PropertiesLoader props = new PropertiesLoader();
    private static final String url = props.getDbUrl();
    private static final String user = props.getDbUser();
    private static final String password = props.getDbPassword();

    public static Connection getConnection (){
        if (connection == null){
            synchronized (DBConfigurator.class){
                if (connection == null){
                    initDbConnection();
                }
            }
        }
        return connection;
    }

    private static void initDbConnection(){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
