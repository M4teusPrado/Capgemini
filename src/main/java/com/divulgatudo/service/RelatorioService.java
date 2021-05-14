package com.divulgatudo.service;

import com.divulgatudo.model.Anuncio;
import com.divulgatudo.model.Relatorio;

public class RelatorioService {
    
    public Anuncio criar_relatorio(Anuncio anuncio){
        Relatorio relatorio = new Relatorio();
    
        int visualizacoes = (int) (anuncio.getInvestimento_dia() * 30);
        relatorio.aumentaQtd_max_visualizacoes( visualizacoes );
       
        // 1 dia = 86400000 milisegundos (24 * 60 * 60 * 1000).
        long diferencaEmDias = (anuncio.getData_termino().getTime() - anuncio.getData_inicio().getTime()) / 86400000L;

        sub_totais(relatorio, visualizacoes, 4);
        relatorio.multiplicaValoresPeloPerido(diferencaEmDias);
        anuncio.setRelatorio(relatorio);
        return anuncio;
    }

    public Relatorio sub_totais(Relatorio relatorio, float visualizacoes, int eficiencia){
        if(eficiencia > 0){
            float clicks = qtd_clicks(visualizacoes);
            relatorio.aumentaQtd_max_clicks((int) clicks);

            float compartilhamentos =  qtd_compartilhamentos(clicks);
            relatorio.aumentaQtd_max_compartilhamento((int) compartilhamentos);

            float visualizacoes_extras = qtd_visualizacoes_extras(compartilhamentos);
            relatorio.aumentaQtd_max_visualizacoes((int) visualizacoes_extras);

            return sub_totais(relatorio, visualizacoes_extras, eficiencia - 1);
        }
        return relatorio;
    }
    
    public int qtd_compartilhamentos(float clicks){
        //Relação - 20 clicks = 3 compartilhamentos
        return Math.round((clicks * 3) / 20); 
    }

    public int qtd_clicks(float visualizacoes){
        //Relação: 100 visualizações = 12 clicks
        return Math.round(( visualizacoes * 12 ) / 100);
    } 

    public int qtd_visualizacoes_extras(float compartilhamentos){
        //Relação: 1 compartilhamento = 40 visualizações     
        return Math.round((compartilhamentos * 40));
    }
}
