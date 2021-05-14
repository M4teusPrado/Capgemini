package com.divulgatudo.model;

import java.util.Date;

public class Anuncio {

    private Long id_anuncio;
    private String nome_do_anuncio;
    private String cliente;
    private Date data_inicio;
    private Date data_termino;
    private Double investimento_dia;
    
    private Relatorio relatorio;

    public Long getId_anuncio() {
        return id_anuncio;
    }
    public void setId_anuncio(Long id_anuncio) {
        this.id_anuncio = id_anuncio;
    }
    public String getNome_do_anuncio() {
        return nome_do_anuncio;
    }
    public void setNome_do_anuncio(String nome_do_anuncio) {
        this.nome_do_anuncio = nome_do_anuncio;
    }
    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public Date getData_inicio() {
        return data_inicio;
    }
    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }
    public Date getData_termino() {
        return data_termino;
    }
    public void setData_termino(Date data_termino) {
        this.data_termino = data_termino;
    }
    public double getInvestimento_dia() {
        return investimento_dia;
    }
    public void setInvestimento_dia(Double investimento_dia) {
        this.investimento_dia = investimento_dia;
    }

    public Relatorio getRelatorio() {
        return relatorio;
    }
    public void setRelatorio(Relatorio relatorio) {
        this.relatorio = relatorio;
    }
    public Anuncio() { }

    public Anuncio(
                    Long id_anuncio, 
                    String nome_do_anuncio, 
                    String cliente, 
                    Date data_inicio, 
                    Date data_termino,
                    Double investimento_dia,
                    Relatorio relatorio
                ){
        this.id_anuncio = id_anuncio;
        this.nome_do_anuncio = nome_do_anuncio;
        this.cliente = cliente;
        this.data_inicio = data_inicio;
        this.data_termino = data_termino;
        this.investimento_dia = investimento_dia;
        this.relatorio = relatorio;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_anuncio == null) ? 0 : id_anuncio.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Anuncio other = (Anuncio) obj;
        if (id_anuncio == null) {
            if (other.id_anuncio != null)
                return false;
        } else if (!id_anuncio.equals(other.id_anuncio))
            return false;
        return true;
    }


}
