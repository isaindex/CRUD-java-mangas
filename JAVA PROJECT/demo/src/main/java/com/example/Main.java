package com.example;

import com.example.dao.MangaDAO;
import com.example.service.MangaService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       MangaService svc = new MangaService();
       Scanner sc = new Scanner(System.in);

       svc.cadastrarManga(sc);
       svc.listaMangas();


        }
    }