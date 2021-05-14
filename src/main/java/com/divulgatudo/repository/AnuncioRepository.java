package com.divulgatudo.repository;

import java.util.ArrayList;
import java.util.List;

import com.divulgatudo.model.Anuncio;

public class AnuncioRepository {

    private List<Anuncio> anuncios = new ArrayList<>();

    public void salvar(Anuncio anuncio) {
        anuncios.add(anuncio);

        System.out.println(anuncios);
    }

    public List<Anuncio> obterTodosAnuncios() {
        return anuncios;
    }
}
