package com.divulgatudo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("\t\nDigite a data inicio: ");
        while(!valida_data_incial( recebe_data(format), anuncio)){
            System.out.println("\nData invalida!\n\tData digita menor que a data do sistema \n\nDigite a data inicio: ");   
        }

        return true;
    }


    public Date recebe_data(SimpleDateFormat format){
        format.setLenient(false);
        Date data = null;
        Boolean flag = false;
        do{
            try {
                data = format.parse(s.nextLine());
                flag = true;        
            }catch (ParseException e){ 
                System.out.println("\nFormato da data invalido\n\tDigite nesse formato: dd/mm/yyy\n\n Digite a data inicio: "); 
            }
        }while(!flag);
        return data;
    }

    private boolean valida_data_incial(Date data_inicio, Anuncio anuncio) {
        Date data_atual = new Date();
        if(data_inicio.after(data_atual) || data_inicio.equals(data_atual) ) {
            anuncio.setData_inicio(data_inicio);
            return true;
        } 
        return false;
    }
}
