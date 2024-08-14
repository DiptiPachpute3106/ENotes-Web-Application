package com.Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static Connection con;

    public static Connection getCon()
    {
        try {
            if (con == null || con.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver"); // Use "com.mysql.jdbc.Driver" for MySQL Connector/J 5.1
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enotes", "root", "root");
                System.out.println("Database connected successfully");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
        }
        return con;
    }
}
