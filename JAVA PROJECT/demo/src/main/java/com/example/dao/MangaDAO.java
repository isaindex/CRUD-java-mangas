package com.example.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.database.ConnectionFactory;
import com.example.model.Manga;

public class MangaDAO{
    public void salvar (Manga manga) {
        String sql = " INSERT INTO mangas (titulo, review, volume, points) VALUES (?, ?, ?, ?)";
        try (
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
        )
        {
            stmt.setString(1, manga.getTitle());
            stmt.setString(2, manga.getReview());
            stmt.setInt(3, manga.getVolume());
            stmt.setInt(4, manga.getPoints());
            stmt.executeUpdate();

            System.out.println("Manga salvo com sucesso!");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

        public List<Manga> listar() {

        List<Manga> mangas = new ArrayList<>();

        String sql = "SELECT * FROM mangas";

        try (
            Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)
        ) {

            while (rs.next()) {

                Manga manga = new Manga();

                manga.setTitle(rs.getString("titulo"));
                manga.setReview(rs.getString("review"));
                manga.setVolume(rs.getInt("volume"));
                manga.setPoints(rs.getInt("points"));

                mangas.add(manga);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mangas;
    }

    
}