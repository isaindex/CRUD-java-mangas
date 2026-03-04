package com.example.service;

import com.example.dao.MangaDAO;
import com.example.model.Manga;

import java.util.List;
import java.util.Scanner;

public class MangaService {

    MangaDAO dao = new MangaDAO();

    //===============
    //DELETAR TODOS OS MANGÁS
    //===============
    public void deletarTudo(Scanner sc){
        System.out.println("Tem certeza que deseja deletar tudo? (s/n)");
        String userResponse = sc.next();
        if (userResponse.equals("s")){
            dao.deletedAll();
            System.out.println("Mangas deletados com sucesso!");
        }else {
            System.out.println("Cancelar");
        }
    }
    //======================
    //CADASTRAR MANGA NOVO
    //======================
    public void cadastrarManga(Scanner sc) {
        Manga mangaNew = new Manga();

        System.out.println("Digite o título do mangá:");
        sc.nextLine();
        mangaNew.setTitle(sc.nextLine());

        System.out.println("Digite a sua opniao sobre esse mangá:");
        mangaNew.setReview(sc.nextLine());

        System.out.println("Digite o número de volumes lidos:");
        mangaNew.setVolume(sc.nextInt());

        System.out.println("Digite sua nota para esse mangá:");
        mangaNew.setPoints(sc.nextInt());

        sc.nextLine();

        dao.salvar(mangaNew);

        System.out.println("Manga Cadastrado com Sucesso!");
    }

    //===============
    //LISTAR TODOS OS MANGAS
    //===============
    public void listaMangas(){
        List<Manga> listaMangas = dao.listar();

        if (listaMangas.isEmpty()){
            System.out.println("LISTA DE MANGAS VAZIA!");
            return;
        }
        System.out.println("===================== MANGAS CADASTRADOS ===================");

        for (Manga manga : listaMangas){
            System.out.println("ID = " + manga.getId());
            System.out.println("Titulo: " + manga.getTitle());
            System.out.println("Sua review: " + manga.getReview());
            System.out.println("Volumes lidos: " + manga.getVolume());
            System.out.println("Sua nota: " + manga.getPoints());
            System.out.println("=======================================");
        }
        System.out.println("LISTA DE MANGAS ENCONTRADA!");
    }

    //===============
    //DELETAR
    //===============
    public void deletarManga(Scanner sc){
        System.out.println("Digite o ID do manga que deseja deletar do banco: ");
        int id = sc.nextInt();
        dao.deletar(id);
        System.out.println("Item Deletado!");
    }

    //===============
    //ATUALIZAR
    //===============
    public void atualizarManga(Scanner sc){

        System.out.println("Digite o ID do manga que deseja atualizar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Manga manga = new Manga();
        manga.setId(id);

        System.out.println("Novo Titulo:");
        manga.setTitle(sc.nextLine());

        System.out.println("Nova Avaliação:");
        manga.setReview(sc.nextLine());

        System.out.println("Novo numero de volumes:");
        manga.setVolume(sc.nextInt());
        sc.nextLine();

        System.out.println("Nova pontuação:");
        manga.setVolume(sc.nextInt());

        dao.update(manga);


    }
    //===============
    //BUSCAR MANGA POR ID
    //===============
    public void buscarManga(Scanner sc){
        System.out.println("Digite o ID do manga que deseja buscar: ");
        int id = sc.nextInt();
        Manga manga = dao.buscarPorId(id);

       if(manga != null){
        System.out.println("ID = " + manga.getId());
        System.out.println("Titulo: " + manga.getTitle());
        System.out.println("Sua review: " + manga.getReview());
        System.out.println("Volumes lidos: " + manga.getVolume());
        System.out.println("Sua nota: " + manga.getPoints());
        System.out.println("=======================================");
       }
       else {
           System.out.println("ID não encontrado");
       }
    }
}