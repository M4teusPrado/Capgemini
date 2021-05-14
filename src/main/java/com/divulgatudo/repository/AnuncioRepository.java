package com.divulgatudo.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.divulgatudo.model.Anuncio;

public class AnuncioRepository {

    private List<Anuncio> anuncios = new ArrayList<>();

    public void salvar(Anuncio anuncio) {
        anuncios.add(anuncio);
        System.out.println(anuncios);
    }

    public List<Anuncio> obterAnuncioPorCliente(String cliente) {

        List<Anuncio> anunciosPorClientes = new ArrayList<>();

        for (Anuncio a : anuncios) 
            if(a.getCliente().equals(cliente)) 
                anunciosPorClientes.add(a);
        return anunciosPorClientes;
    }


    public List<Anuncio> obterAnuncioPorPerido(Date di, Date df) {
        List<Anuncio> anunciosPorPerido = new ArrayList<>();
        for (Anuncio a : anuncios) 
            if(a.getData_inicio().equals(di) && a.getData_termino().equals(df)) 
                anunciosPorPerido.add(a);
        return anunciosPorPerido;
    }


    public List<Anuncio> obterAnuncioPorClienteEPerido(String cliente,Date di, Date df) {
        List<Anuncio> anunciosPorClienteEPerido = new ArrayList<>();
        for (Anuncio a : anuncios) 
            if( a.getData_inicio().equals(di) && a.getData_termino().equals(df) && a.getCliente().equals(cliente))
                anunciosPorClienteEPerido.add(a);
        return anunciosPorClienteEPerido;
    }
}
