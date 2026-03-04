package com.example;

import com.example.dao.MangaDAO;
import com.example.service.MangaService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MangaService svc = new MangaService();
        Scanner sc = new Scanner(System.in);
        int rUsuario = 0;

        while (rUsuario != 6){
            System.out.println("");
            System.out.println("Bem vindo ao Crud Mangas, selecione oq preferir:");
            System.out.println("1- cadastrar mangás \n2- listar mangás \n3- deletar \n4- atualizar manga \n5- deletar tudo \n6- Buscar mangás\n7- sair");
            rUsuario = sc.nextInt();

            switch (rUsuario) {
                case 1:
                    svc.cadastrarManga(sc);
                    break;
                case 2:
                    svc.listaMangas();
                    break;
                case 3:
                    svc.deletarManga(sc);
                    break;
                case 4:
                    svc.atualizarManga(sc);
                    break;
                case 5:
                    svc.deletarTudo(sc);
                    break;
                case 6:
                    svc.buscarManga(sc);
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
            }
    }
}}