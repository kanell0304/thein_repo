package java_0612.com.gjl.dbconnecttest;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	
    private static final String URL = "jdbc:postgresql://localhost:5432/dvdrental";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    public static Connection getConnection()
            throws Exception {

        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }
}