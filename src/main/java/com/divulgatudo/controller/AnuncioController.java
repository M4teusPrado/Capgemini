package com.divulgatudo.controller;

import java.util.Scanner;

import com.divulgatudo.service.CadastrarAnuncio;

public class AnuncioController {
    public static void main(String[] args) {
       
        Scanner s = new Scanner(System.in);
        int op = 0;

        System.out.println("-=-=-=-=-=-=-=-= Seja bem vindo -=-=-=-=-=-=-=-=");
       
        do {
            System.out.println("\n [1] Cadastrar aununcio\n [2] Buscar anuncio\n [3] Sair\n");
            
            System.out.println("\t\nDigite a operação desejada: ");
            op = Integer.parseInt(s.nextLine());

            if( op == 1){
                System.out.println("Cadastrar um anuncio");
                cadastrarAnuncio();
            } else if ( op == 2) {
                System.out.println("Buscar anuncio");

            }
        } while (op != 3);
        
        s.close();
    }

    public static Boolean cadastrarAnuncio() {
        CadastrarAnuncio service = new CadastrarAnuncio();
        return service.cadastrarAnuncio();
    }
}
