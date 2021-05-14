package com.divulgatudo.service;

import com.divulgatudo.model.Anuncio;
import com.divulgatudo.model.Relatorio;

public class RelatorioService {
    
    //A cada 100 pessoas que visualizam o anúncio 12 clicam nele.
    //A cada 20 pessoas que clicam no anúncio 3 compartilham nas redes sociais.
    //Cada compartilhamento nas redes sociais gera 40 novas visualizações.
    //30 pessoas visualizam o anúncio original (não compartilhado) a cada R$ 1,00 investido.
    //O mesmo anúncio é compartilhado no máximo 4 vezes em sequência
    //(1ª pessoa -> compartilha -> 2ª pessoa -> compartilha - > 3ª pessoa -> compartilha -> 4ª pessoa)

    
    public Anuncio criarRelatorio(Anuncio anuncio){
        Relatorio relatorio = new Relatorio();

        int visualizacoes = (int) (anuncio.getInvestimento_dia() * 30);
        relatorio.aumentaQtd_max_visualizacoes( visualizacoes );
        
        anuncio.setRelatorio(sub_totais(relatorio, visualizacoes, 4));
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
