package com.example.service;

import com.example.dao.MangaDAO;
import com.example.database.ConnectionFactory;
import com.example.model.Manga;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MangaService {

    MangaDAO dao = new MangaDAO();
    Scanner sc = new Scanner(System.in);

    public void cadastrarManga(Scanner sc) {
        Manga mangaNew = new Manga();

        System.out.println("Digite o título do mangá:");
        mangaNew.setTitle(sc.nextLine());

        System.out.println("Digite a sua opniao sobre esse mangá:");
        mangaNew.setReview(sc.nextLine());

        System.out.println("Digite o número de volumes lidos:");
        mangaNew.setVolume(sc.nextInt());

        System.out.println("Digite sua nota para esse mangá:");
        mangaNew.setPoints(sc.nextInt());
        sc.close();

        dao.salvar(mangaNew);
    }

    public void listaMangas(){
        List<Manga> listaMangas = dao.listar();

        if (listaMangas.isEmpty()){
            System.out.println("LISTA DE MANGAS VAZIA!");
            return;
        }

        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("==== MANGAS CADASTRADOS ====");

        for (Manga manga : listaMangas){
            System.out.println("ID" + manga.getId());
            System.out.println("Titulo: " + manga.getTitle());
            System.out.println("Sua review: " + manga.getReview());
            System.out.println("Volumes lidos: " + manga.getVolume());
            System.out.println("Sua nota: " + manga.getPoints());
        }
    }
}