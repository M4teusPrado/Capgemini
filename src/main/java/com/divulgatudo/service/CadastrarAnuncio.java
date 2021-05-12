package com.divulgatudo.service;

// import java.text.SimpleDateFormat;
// import java.util.Date;
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


        //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        

        System.out.println("\t\nDigite a data inicio: ");
        
        

        return null;
    }


}
