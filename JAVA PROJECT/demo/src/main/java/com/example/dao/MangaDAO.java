package com.example.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.database.ConnectionFactory;
import com.example.model.Manga;


public class MangaDAO{

    //DELETAR TUDO DO BD
    public void deletedAll(){
        String sql = "DELETE FROM mangas";

        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
// SALVAR DO OBJ MANGA PARA O BD
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
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
//LISTAR TODOS AS INFOS DO BD
    public List<Manga> listar() {
        List<Manga> mangas = new ArrayList<>();
        String sql = "SELECT * FROM mangas";

        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
        ) {
            while (rs.next()) {

                Manga manga = new Manga();

                manga.setId(rs.getInt("id"));
                manga.setTitle(rs.getString("titulo"));
                manga.setReview(rs.getString("review"));
                manga.setVolume(rs.getInt("volume"));
                manga.setPoints(rs.getInt("points"));


                mangas.add(manga);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return mangas;
    }
    // DELETAR UM ITEM ESPECIFICO DO BD
    public void deletar (int id){
        String sql = "DELETE FROM mangas WHERE id=?";

        try (
             Connection conn =ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)
        )
        {
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
// ATUALIZAR UM ITEM DO BD
    public void update (Manga manga){
        String sql = "UPDATE mangas SET titulo=?, review=?, volume=?, points=? WHERE id=?";

        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        )
        {
            stmt.setString(1, manga.getTitle());
            stmt.setString(2, manga.getReview());
            stmt.setInt(3, manga.getVolume());
            stmt.setInt(4, manga.getPoints());
            stmt.setInt(5, manga.getId());

            stmt.executeUpdate();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    // BUSCAR UM ITEM NO BD PELO SEU ID (CHAVE PRIMARIA)
    public Manga buscarPorId (int id){
        String sql = "SELECT * FROM mangas WHERE id=?";

        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)

                ) {
            stmt.setInt(1, id);
            Manga manga = new Manga();
            ResultSet rs = stmt.executeQuery();

            manga.setId(rs.getInt("id"));
            manga.setTitle(rs.getString("titulo"));
            manga.setReview(rs.getString("review"));
            manga.setVolume(rs.getInt("volume"));
            manga.setPoints(rs.getInt("points"));

            return manga;

        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
