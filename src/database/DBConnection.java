/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/cleaning_inventory";

    private static final String USER = "postgres";

    
    private static final String PASSWORD = "admin";

    public static Connection getConnection() {

        try {
            Connection conn =
                    DriverManager.getConnection(
                            URL,
                            USER,
                            PASSWORD);

            System.out.println("Database Connected Successfully!");

            return conn;

        } catch (SQLException e) {

            System.out.println("Connection Failed!");

            return null;
        }
        
        
        
    }
}
