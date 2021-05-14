package com.divulgatudo.controller;

import java.util.List;
import java.util.Scanner;

import com.divulgatudo.model.Anuncio;
import com.divulgatudo.service.AnuncioService;

public class AnuncioController {

    static AnuncioService service = new AnuncioService();
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
       
        int op = 0;

        System.out.println("-=-=-=-=-=-=-=-= Seja bem vindo -=-=-=-=-=-=-=-=");
       
        do {
            System.out.println("\n [1] Cadastrar aununcio\n [2] Buscar anuncio\n [3] Sair\n");
            
            System.out.println("\t\nDigite a operação desejada: ");
            op = Integer.parseInt(s.nextLine());

            if( op == 1){
                System.out.println("Cadastrar um anuncio");
                service.cadastrarAnuncio(); 
            } 
            else if ( op == 2){
                filtro();
            }
        } while (op != 3);  
        s.close();
    }

    private static void filtro() {

        System.out.println("Buscar anuncio");
        System.out.println("\n [1] Buscar por cliente\n [2] Buscar periodo\n [3] buscar por Cliente e anuncio\n");

        int filtro = Integer.parseInt(s.nextLine());

        if(filtro == 1) {
            exibe_relatorio(service.relatorioPorCliente());
        } else if(filtro == 2) {
            exibe_relatorio(service.relatorioPorPerido());
        } else if(filtro == 3) {
            exibe_relatorio(service.relatorioPorClienteEPerido());
        } else {
            System.out.println("Opção invalida");
        }
    }

    private static void exibe_relatorio(List<Anuncio> relatorios) {
        System.out.println(relatorios);
    }
}
