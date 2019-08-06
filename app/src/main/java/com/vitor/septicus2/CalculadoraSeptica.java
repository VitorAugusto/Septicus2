package com.vitor.septicus2;

import java.math.*;


public class CalculadoraSeptica { //faço os cálculos para o dimensionamento do tanque séptico

    public CalculadoraSeptica(){
        System.out.println("CALCULADORA CRIADA !");
    }


    public String getContribuicaoTotalDespejos(int numPessoas, String padraoResidencial){

        return null;

    }

    public String getVolumeUtil(){
        return null;
    }

    public double get_T_tempoDetencao(int contribuicaoDespejos){
        return 0;

    }


    public int get_K_temperaturaSobreIntervaloDeLimpeza(int intervaloLimpeza, int temp){
        //temp = 1 = igual ou abaixo de 10 c
        //temp = 2 = entre 10 a 20 c
        //temp = 3 = superior a 20c

        switch (intervaloLimpeza){
            case 1: //CASO
                if(temp == 1){
                    return 94;
                }
                if(temp == 2){
                    return 65;
                }
                if(temp == 3){
                    return 57;
                }
                break;
            case 2: //CASO
                if(temp == 1){
                    return 134;
                }
                if(temp == 2){
                    return 105;
                }
                if(temp == 3){
                    return 97;
                }
                break;
            case 3: //CASO
                if(temp == 1){
                    return 174;
                }
                if(temp == 2){
                    return 145;
                }
                if(temp == 3){
                    return 137;
                }
                break;
            case 4: //CASO
                if(temp == 1){
                    return 214;
                }
                if(temp == 2){
                    return 183;
                }
                if(temp == 3){
                    return 177;
                }
                break;
            case 5: //CASO
                if(temp == 1){
                    return 254;
                }
                if(temp == 2){
                    return 225;
                }
                if(temp == 3){
                    return 217;
                }
                break;

        }
        return 0;

    }


}
