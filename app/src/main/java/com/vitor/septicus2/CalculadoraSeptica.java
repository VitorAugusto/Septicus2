package com.vitor.septicus2;

import java.math.*;


public class CalculadoraSeptica { //faço os cálculos para o dimensionamento do tanque séptico

    int numeroDePessoas;

    int padraoDaResidencia;
    //1 - padrão alto
    //2 - padrão médio
    //3 - padrão baixo
    //4 - alojamento provisório
    int tipoDeResidencia;
    //5 - alojamento provisório
    //6 - apartamento
    //7 - casas populares ou rurais
    //8 - residência
    //9 - residência de luxo
    int temperaturaMediaMesMaisFrio;
    //10 - igual ou abaixo de 10c
    //11 - entre 10c a 20c
    //12 - igual ou superior a 20c
    int intervaloDeLimpeza;
    //13 - 01 ano
    //14 - 02 anos
    //15 - 03 anos
    //16 - 04 anos
    //17 - 05 anos
    int geometriaTanqueSeptico;
    //18 - Cilíndrico
    //19 - Retangular
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

        double calc1 = 1000 + numeroDePessoas;

        double calc2 = (getContribuicaoDespejos() * get_T_tempoDetencao());

        double calc3 = (get_K_temperaturaSobreIntervaloDeLimpeza() * 1);

        double calc4 = calc2 + calc3;

        double calc5 = numeroDePessoas * calc4;

        double calc6 = 1000 + calc5;

        return calc6;
    }

    public double transformarLitroMetroCub(double v){

        return (v/0.001);

    }


    //contribuição TOTAL de despejos
    public int getContribuicaoTotalDespejos(){
        return (numeroDePessoas * getContribuicaoDespejos());
    }

    //a contribuição de despejos depende do padrão da residência

    public int getContribuicaoDespejos(){
        //de acordo com o padrão da residência

        int contrDespejos = 0;

        switch (padraoDaResidencia){

            case 1:
                contrDespejos = 160;
                break;
            case 2:
                contrDespejos = 130;
                break;
            case 3:
                contrDespejos = 100;
                break;
            case 4:
                contrDespejos = 80;
                break;
        }
        return contrDespejos;

    }

    public double get_T_tempoDetencao(){
        //precisa da contribuição total
        int contrTotal = getContribuicaoTotalDespejos();
        double t = 0;

        if(contrTotal > 0 && contrTotal <= 1500){
            t = 1;
        }
        if(contrTotal >= 1501 && contrTotal <= 3000){
            t = 0.92;
        }
        if(contrTotal >= 3001 && contrTotal <= 4500){
            t = 0.83;
        }
        if(contrTotal >= 4501 && contrTotal <= 6000){
            t = 0.75;
        }
        if(contrTotal >= 6001 && contrTotal <= 7500){
            t = 0.67;
        }
        if(contrTotal >= 7501 && contrTotal <= 9000){
            t = 0.58;
        }
        if(contrTotal > 9000){
            t = 0.5;
        }

        return t;

    }


    public double get_K_temperaturaSobreIntervaloDeLimpeza(){
        //if cobrindo os anos
        double k = 0;

        if(intervaloDeLimpeza == 13){
            switch (temperaturaMediaMesMaisFrio){

                case 10:
                    k = 94;
                    break;
                case 11:
                    k = 65;
                    break;
                case 12:
                    k = 57;
                    break;
            }
        }

        if(intervaloDeLimpeza == 14){
            switch (temperaturaMediaMesMaisFrio){

                case 10:
                    k = 134;
                    break;
                case 11:
                    k = 105;
                    break;
                case 12:
                    k = 97;
                    break;
            }
        }

        if(intervaloDeLimpeza == 15){
            switch (temperaturaMediaMesMaisFrio){

                case 10:
                    k = 174;
                    break;
                case 11:
                    k = 145;
                    break;
                case 12:
                    k = 137;
                    break;
            }
        }

        if(intervaloDeLimpeza == 16){
            switch (temperaturaMediaMesMaisFrio){

                case 10:
                    k = 214;
                    break;
                case 11:
                    k = 183;
                    break;
                case 12:
                    k = 177;
                    break;
            }
        }

        if(intervaloDeLimpeza == 17){
            switch (temperaturaMediaMesMaisFrio){

                case 10:
                    k = 254;
                    break;
                case 11:
                    k = 225;
                    break;
                case 12:
                    k = 217;
                    break;
            }
        }

        return k;

    }


}
