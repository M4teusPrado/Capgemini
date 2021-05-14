package com.divulgatudo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.divulgatudo.model.Anuncio;
import com.divulgatudo.repository.AnuncioRepository;

public class AnuncioService {

    Scanner s = new Scanner(System.in);

    AnuncioRepository repository = new AnuncioRepository();
    RelatorioService relatorioService = new RelatorioService();
    
    public void cadastrarAnuncio() {
        Anuncio anuncio = new Anuncio();

        System.out.println("\t\nDigite o nome do anuncio: ");
        anuncio.setNome_do_anuncio(s.nextLine());

        System.out.println("\t\nDigite o cliente: ");
        anuncio.setCliente(s.nextLine());

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("\t\nDigite a data inicio: ");
        while(!valida_data_incial( recebe_data(format), anuncio)){
            System.out.println("\nData invalida!\n\tData digita menor que a data do sistema \n\nDigite a data correta: ");   
        }

        System.out.println("\t\nDigite a data final: ");
        while(!valida_data_final( recebe_data(format), anuncio)){
            System.out.println("\nData invalida!\n\tData digita menor que a data de inicio \n\nDigite a data correta: ");   
        }

        System.out.println("\t\nDigite o investimento: ");
        while(!recebe_investimento_dia(anuncio)) {
            System.out.println("\nValor invalido!\n\tValor digitado menor que R$ 0 \n\nDigite o investimento: ");   
        }

        relatorioService.criarRelatorio(anuncio);
        repository.salvar(anuncio);
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
                System.out.println("\nFormato da data invalido\n\tDigite nesse formato: dd/mm/yyy\n\n Digite a data correta: "); 
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

    private boolean valida_data_final(Date data_final, Anuncio anuncio) {
        if(data_final.after(anuncio.getData_inicio()) || data_final.equals(anuncio.getData_inicio())) {
            anuncio.setData_termino(data_final);
            return true;
        } 
        return false;
    }


    public Boolean recebe_investimento_dia(Anuncio anuncio){
        Double investimento_dia = 0.0;
        do{
            investimento_dia = Double.parseDouble(s.nextLine());
            if(investimento_dia >= 0) {
                anuncio.setInvestimento_dia(investimento_dia);
                return true;
            } else {
                return false;
            }   
        }while(true);

    }
   
}
