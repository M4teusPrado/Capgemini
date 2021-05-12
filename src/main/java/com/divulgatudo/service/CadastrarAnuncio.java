package com.divulgatudo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.divulgatudo.model.Anuncio;

public class CadastrarAnuncio {

    Scanner s = new Scanner(System.in);
    
    public Boolean cadastrarAnuncio() {
        Anuncio anuncio = new Anuncio();

        System.out.println("\t\nDigite o nome do anuncio: ");
        anuncio.setNome_do_anuncio(s.nextLine());

        System.out.println("\t\nDigite o cliente: ");
        anuncio.setCliente(s.nextLine());
        
        System.out.println("\t\nDigite a data inicio: ");
        while( !valida_data(anuncio) ) 
            System.out.println("Data invalida !\n\nDigite a data inicio: ");

        System.out.println("\t\nDigite a data final: ");
        while( !valida_data(anuncio) ) 
            System.out.println("Data invalida !\n\nDigite a data final: ");

        return null;
    }

    private boolean valida_data(Anuncio anuncio) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            format.setLenient(false);
            anuncio.setData_inicio(format.parse(s.nextLine()));
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
