package com.divulgatudo.model;

public class Relatorio{

    private int qtd_max_visualizacoes;
    private int qtd_max_clicks;
    private int qtd_max_compartilhamento;

    public int getQtd_max_visualizacoes() {
        return qtd_max_visualizacoes;
    }
    public void aumentaQtd_max_visualizacoes(int qtd_max_visualizacoes) {
        this.qtd_max_visualizacoes += qtd_max_visualizacoes;
    }
    public int getQtd_max_clicks() {
        return qtd_max_clicks;
    }
    public void aumentaQtd_max_clicks(float clicks) {
        this.qtd_max_clicks += clicks;
    }
    public int getQtd_max_compartilhamento() {
        return qtd_max_compartilhamento;
    }
    public void aumentaQtd_max_compartilhamento(int qtd_max_compartilhamento) {
        this.qtd_max_compartilhamento += qtd_max_compartilhamento;
    }

    public Relatorio() {}

    public Relatorio(int qtd_max_visualizacoes, int qtd_max_clicks, int qtd_max_compartilhamento) {
        this.qtd_max_visualizacoes = qtd_max_visualizacoes;
        this.qtd_max_clicks = qtd_max_clicks;
        this.qtd_max_compartilhamento = qtd_max_compartilhamento;
    }

    

    
}
