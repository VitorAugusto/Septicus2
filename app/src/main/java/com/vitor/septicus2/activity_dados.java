package com.vitor.septicus2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class activity_dados extends AppCompatActivity {

    CalculadoraSeptica minhaCalculadora;
    RadioGroup padraoResidenciaRadioGroup;
    EditText campoNumeroPessoas;
    RadioGroup tipoResidenciaRadioGroup;
    RadioGroup temperaturaMediaRadioGroup;
    RadioGroup intervaloLimpezaRadioGroup;
    RadioGroup geometriaTanqueRadioGroup;
    EditText campoProfundidade;
    EditText campoInfiltracao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);
        minhaCalculadora = new CalculadoraSeptica();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public boolean todosOsCamposPreenchidos(){

        campoNumeroPessoas = (EditText) findViewById(R.id.campoNumeroPessoas);

        padraoResidenciaRadioGroup = (RadioGroup) findViewById(R.id.padraoResidenciaRadioGroup);

        tipoResidenciaRadioGroup = (RadioGroup) findViewById(R.id.tipoResidenciaRadioGroup);

        temperaturaMediaRadioGroup = (RadioGroup) findViewById(R.id.radioGroupTemperaturaMedia);

        intervaloLimpezaRadioGroup = (RadioGroup) findViewById(R.id.radioIntervaloLimpeza);

        geometriaTanqueRadioGroup = (RadioGroup) findViewById(R.id.radioGeometriaTanque);

        campoProfundidade = (EditText) findViewById(R.id.campoProfundidade);

        campoInfiltracao = (EditText) findViewById(R.id.campoInfiltracao);

        if(campoTextoVazio(campoNumeroPessoas)
            ||
                campoTextoVazio(campoProfundidade)
            ||
                campoTextoVazio(campoInfiltracao)
            ||
                botaoRadioVazio(padraoResidenciaRadioGroup)
            ||
                botaoRadioVazio(tipoResidenciaRadioGroup)
            ||
                botaoRadioVazio(temperaturaMediaRadioGroup)
            ||
                botaoRadioVazio(intervaloLimpezaRadioGroup)
            ||
                botaoRadioVazio(geometriaTanqueRadioGroup)){

            return false;
        }else{
            return true;
        }


    }

    public int getBotaoSelecionadoPosicao(RadioGroup g){ //RECEBE O ID REAL DO BOTÃO SELECIONADO E RETORNA A POSIÇÃO ABSOLUTA.
        int absolutaPosicao = 0;

        switch(g.getCheckedRadioButtonId()){

            case 2131230756:
                absolutaPosicao = 1;
                break;
            case 2131230767:
                absolutaPosicao = 2;
                break;
            case 2131230768:
                absolutaPosicao = 3;
                break;
            case 2131230769:
                absolutaPosicao = 4;
                break;
            case 2131230770:
                absolutaPosicao = 5;
                break;
            case 2131230771:
                absolutaPosicao = 6;
                break;
            case 2131230772:
                absolutaPosicao = 7;
                break;
            case 2131230773:
                absolutaPosicao = 8;
                break;
            case 2131230774:
                absolutaPosicao = 9;
                break;
            case 2131230757:
                absolutaPosicao = 10;
                break;
            case 2131230758:
                absolutaPosicao = 11;
                break;
            case 2131230759:
                absolutaPosicao = 12;
                break;
            case 2131230760:
                absolutaPosicao = 13;
                break;
            case 2131230761:
                absolutaPosicao = 14;
                break;
            case 2131230762:
                absolutaPosicao = 15;
                break;
            case 2131230763:
                absolutaPosicao = 16;
                break;
            case 2131230764:
                absolutaPosicao = 17;
                break;
            case 2131230765:
                absolutaPosicao = 18;
                break;
            case 2131230766:
                absolutaPosicao = 19;
                break;
        }

        return absolutaPosicao;
    }

    public int getNumeroPessoas(){

        return(Integer.parseInt(campoNumeroPessoas.getText().toString()));

    }

    public double getProfundidade(){
        return (Double.parseDouble(campoProfundidade.getText().toString()));
    }

    public double getCoeficiente(){
        return (Double.parseDouble(campoInfiltracao.getText().toString()));
    }

    public boolean campoTextoVazio(EditText myText){

        return myText.getText().toString().trim().length() == 0;
    }

    public boolean botaoRadioVazio(RadioGroup myRadio){

        if(myRadio.getCheckedRadioButtonId() == -1 ){
            return true;
        }else{
            return false;
        }
    }


    public void startMemorialGenProcedure(View v){

        if(todosOsCamposPreenchidos()){ //se todos os campos estiverem preenchidos
            MANDAR_VALORES_CALCULADORA();

            if(minhaCalculadora.checkProfundidadeMinimaMaxima()){ //se a profundidade estiver entre a mínima e a máxima

                System.out.println("GERANDO MEMORIAL !!!!");

            }else{
                if(minhaCalculadora.getProfundidadeMinima() >= getProfundidade()){
                    lancarErro(3,String.valueOf(minhaCalculadora.getProfundidadeMinima()));
                }
                if(minhaCalculadora.getProfundidadeMaxima() <= getProfundidade()){
                    lancarErro(4,String.valueOf(minhaCalculadora.getProfundidadeMaxima()));
                }
            }

        }else{

            lancarErro(1,"");

        }






    }

    public void MANDAR_VALORES_CALCULADORA(){

        minhaCalculadora.SETAR_VALORES_CALCULADORA(getNumeroPessoas(),
                getBotaoSelecionadoPosicao(padraoResidenciaRadioGroup),
                getBotaoSelecionadoPosicao(tipoResidenciaRadioGroup),
                getBotaoSelecionadoPosicao(temperaturaMediaRadioGroup),
                getBotaoSelecionadoPosicao(intervaloLimpezaRadioGroup),
                getBotaoSelecionadoPosicao(geometriaTanqueRadioGroup),
                getProfundidade(),
                getCoeficiente());

    }

    public void lancarErro(int codigo, String dados){
        AlertDialog.Builder criadorErro = new AlertDialog.Builder(this);
        AlertDialog erro  = null;

        switch (codigo){
            case 1:
                criadorErro.setMessage("PREENCHA TODOS OS CAMPOS");
                criadorErro.setCancelable(true);
                break;
            case 2:
                criadorErro.setMessage("VALORES INVÁLIDOS");
                criadorErro.setCancelable(true);
                break;
            case 3:
                criadorErro.setMessage("PROFUNDIDADE MÍNIMA EXIGIDA : \n" + dados + " metros");
                criadorErro.setCancelable(true);
                break;
            case 4:
                criadorErro.setMessage("PROFUNDIDADE MÁXIMA EXIGIDA : \n" + dados + " metros");
                criadorErro.setCancelable(true);
                break;
            case 5:
                criadorErro.setMessage("GERANDO MEMORIAL...");
                criadorErro.setCancelable(true);
                break;

        }

        criadorErro.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        erro = criadorErro.create();

        erro.show();



    }

    public void gerarMemorial(View v){

    }
}
