package com.vitor.septicus2;

import java.math.*;


public class CalculadoraSeptica { //faço os cálculos para o dimensionamento do tanque séptico

    int numeroDePessoas;
    int padraoDaResidencia;
    int tipoDeResidencia;
    int temperaturaMediaMesMaisFrio;
    int intervaloDeLimpeza;
    int geometriaTanqueSeptico;
    double profundidadeDesejada;
    double coeficienteInfiltracao;

    public CalculadoraSeptica(){

        System.out.println("CALCULADORA CRIADA !");
    }

    public void SETAR_VALORES_CALCULADORA(int numPessoas,
                                     int padraoResidencia,
                                     int tipoResidencia,
                                     int temperaturaMedia,
                                     int intervaloLimpeza,
                                     int geometriaDoTanque,
                                     double profundidade,
                                     double coefInfiltracao){

        this.numeroDePessoas = numPessoas;
        this.padraoDaResidencia = padraoResidencia;
        this.tipoDeResidencia = tipoResidencia;
        this.temperaturaMediaMesMaisFrio = temperaturaMedia;
        this.intervaloDeLimpeza = intervaloLimpeza;
        this.geometriaTanqueSeptico = geometriaDoTanque;
        this.profundidadeDesejada = profundidade;
        this.coeficienteInfiltracao = coefInfiltracao;
    }

    public double getVolumeUtil(){

        return 0;
    }


    //contribuição TOTAL de despejos
    public int getContribuicaoTotalDespejos(){
        return (numeroDePessoas * getContribuicaoDespejos());
    }

    //a contribuição de despejos depende do padrão da residência

    public int getContribuicaoDespejos(){
        //DEFINIR PARÂMETROS E REFAZER

        return 0;

    }

    public double get_T_tempoDetencao(){
        //DEFINIR PARÂMETROS E REFAZER

        return 0;

    }


    public double get_K_temperaturaSobreIntervaloDeLimpeza(){
        //DEFINIR PARÂMETROS E REFAZER

        return 0;

    }


}
