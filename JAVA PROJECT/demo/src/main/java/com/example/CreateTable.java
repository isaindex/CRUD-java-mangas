package com.example;
import java.sql.Connection;
import java.sql.Statement;

import com.example.database.ConnectionFactory;

public class CreateTable {

    public static void main(String[] args) {

        String sql = """
            CREATE TABLE mangas (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                titulo TEXT,
                review VARCHAR(255),
                volume INTEGER,
                points INTEGER
            );
        """;

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Tabela criada!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}