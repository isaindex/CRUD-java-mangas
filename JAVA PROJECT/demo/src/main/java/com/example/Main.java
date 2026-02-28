package com.example;
import java.util.List;
import java.util.Scanner; 

import com.example.dao.MangaDAO;
import com.example.model.Manga; 

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // Create an instance of the Manga class
        Manga mangaNew = new Manga();
    
        System.out.println("Digite o título do mangá:");
        String title = sc.nextLine();
        mangaNew.setTitle(title);
        
        System.out.println("Digite a sua opniao sobre esse mangá:");
        String review = sc.nextLine();
        mangaNew.setReview(review);

        System.out.println("Digite o número de volumes lidos:");
        int volume = sc.nextInt();
        mangaNew.setVolume(volume);

        System.out.println("Digite sua nota para esse mangá:");
        int points = sc.nextInt();
        mangaNew.setPoints(points);

        MangaDAO dao = new MangaDAO();
        dao.salvar(mangaNew);

        System.out.println("\n=== MANGÁS CADASTRADOS ===");

        List<Manga> lista = dao.listar();

        for (Manga m : lista) {
            System.out.println(m);
        }

        sc.close();
    
    }
}