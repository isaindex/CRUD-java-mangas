package com.example;

public class Main {
    public static void main(String[] args) {

       MangaService svc = new MangaService();
       Scanner sc = new Scanner(System.in);

       svc.cadastrarManga(sc);
       svc.listaMangas();


        }
    }