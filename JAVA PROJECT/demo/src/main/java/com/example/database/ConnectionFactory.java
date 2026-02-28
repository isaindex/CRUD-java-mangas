package com.example.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    // banco de dados local
    private static final String URL = "jdbc:sqlite:mangas.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}