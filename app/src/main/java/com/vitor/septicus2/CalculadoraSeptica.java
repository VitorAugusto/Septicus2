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

/*        double calc1 = 1000 + numeroDePessoas;
        double calc2 = (getContribuicaoDespejos() * get_T_tempoDetencao()) + get_K_temperaturaSobreIntervaloDeLimpeza();

        double calcFinal = calc1 * calc2;*/

        return (get_K_temperaturaSobreIntervaloDeLimpeza());
    }


    //contribuição TOTAL de despejos
    public int getContribuicaoTotalDespejos(){
        return (numeroDePessoas * getContribuicaoDespejos());
    }

    //a contribuição de despejos depende do padrão da residência
    public int getContribuicaoDespejos(){

        switch (padraoDaResidencia){
            case 1:
                return 160; //padrão alto
            case 2:
                return 130; //padrão médio
            case 3:
                return 100; //padrão baixo
            case 4:
                return 80; //alojamento provisório

        }
        return 0;

    }

    public double get_T_tempoDetencao(){
        int contribuicaoDespejos = getContribuicaoTotalDespejos(); //PRA PEGAR O T, EU PRECISO DO TOTAL DE DESPEJOS

        if(contribuicaoDespejos > 0 && contribuicaoDespejos <= 1500){
            return 1;
        }
        if(contribuicaoDespejos >= 1501 && contribuicaoDespejos <= 3000){
            return 0.92;
        }
        if(contribuicaoDespejos >= 3001 && contribuicaoDespejos <= 4500){
            return 0.83;
        }
        if(contribuicaoDespejos >= 4501 && contribuicaoDespejos <= 6000){
            return 0.75;
        }
        if(contribuicaoDespejos >= 6001 && contribuicaoDespejos <= 7500){
            return 0.67;
        }
        if(contribuicaoDespejos >= 7501 && contribuicaoDespejos <= 9000){
            return 0.58;
        }
        if(contribuicaoDespejos > 9000){
            return 0.5;
        }

        return 0;

    }


    public double get_K_temperaturaSobreIntervaloDeLimpeza(){
        //temp = 1 = igual ou abaixo de 10 c
        //temp = 2 = entre 10 a 20 c
        //temp = 3 = superior a 20c

        int intervaloLimpeza = intervaloDeLimpeza;

        System.out.println("MEU INTERVALO DE LIMPEZA : " + intervaloLimpeza);

        int temp = temperaturaMediaMesMaisFrio;

        System.out.println("MINHA TEMPERATURA MÉDIA MAIS FRIO : " + temp);

        double valorK = 0;



        switch (intervaloLimpeza){
            case 1: //CASO
                if(temp == 1){
                    valorK = 94;
                }
                if(temp == 2){
                    valorK = 65;
                }
                if(temp == 3){
                    valorK = 57;
                }
                break;
            case 2: //CASO
                if(temp == 1){
                    valorK =  134;
                }
                if(temp == 2){
                    valorK = 105;
                }
                if(temp == 3){
                    valorK = 97;
                }
                break;
            case 3: //CASO
                if(temp == 1){
                    valorK = 174;
                }
                if(temp == 2){
                    valorK = 145;
                }
                if(temp == 3){
                    valorK = 137;
                }
                break;
            case 4: //CASO
                if(temp == 1){
                    valorK = 214;
                }
                if(temp == 2){
                    valorK =  183;
                }
                if(temp == 3){
                    valorK = 177;
                }
                break;
            case 5: //CASO
                if(temp == 1){
                    valorK = 254;
                }
                if(temp == 2){
                    valorK = 225;
                }
                if(temp == 3){
                    valorK =  217;
                }
                break;

        }return valorK;

    }


}
