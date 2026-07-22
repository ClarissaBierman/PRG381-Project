package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/cleaninginventory";

    private static final String USER =
            "postgres";

    private static final String PASSWORD =
            "admin";

    public static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database Connected");

        }
        catch(ClassNotFoundException | SQLException ex){

            System.out.println(ex.getMessage());

        }

        return con;
    }
}