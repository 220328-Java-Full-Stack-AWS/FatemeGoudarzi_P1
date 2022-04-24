package com.revature.util;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionManager {
    private static Connection connection;

    ConnectionManager(){};

    public static Connection getConnection()  {
        if (connection == null) {
            connection = connect();
        }
        return connection;
    }

    private static Connection connect() {

        try{
            Class.forName("org.postgresql.Driver");
            Properties props = new Properties();
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream input = loader.getResourceAsStream("application.properties");
            props.load(input);
            String ConnectionString = "jdbc:postgresql://" +
                    props.getProperty("hostname") + ":" +
                    props.getProperty("port") + "/" +
                    props.getProperty("dbname");
            String username = props.getProperty("username");
            String password = props.getProperty("password");
            System.out.println(ConnectionString);
            connection = DriverManager.getConnection(ConnectionString, username, password);
        } catch(Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
