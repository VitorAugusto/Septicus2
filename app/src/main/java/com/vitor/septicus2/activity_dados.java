package com.vitor.septicus2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class activity_dados extends AppCompatActivity {

    CalculadoraSeptica minhaCalculadora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);
        minhaCalculadora = new CalculadoraSeptica();
    }


    public boolean todosOsCamposPreenchidos(){

        EditText campoNumeroPessoas = (EditText) findViewById(R.id.campoNumeroPessoas);

        RadioGroup padraoResidenciaRadioGroup = (RadioGroup) findViewById(R.id.padraoResidenciaRadioGroup);

        RadioGroup tipoResidenciaRadioGroup = (RadioGroup) findViewById(R.id.tipoResidenciaRadioGroup);

        RadioGroup temperaturaMediaRadioGroup = (RadioGroup) findViewById(R.id.radioGroupTemperaturaMedia);

        RadioGroup intervaloLimpezaRadioGroup = (RadioGroup) findViewById(R.id.radioIntervaloLimpeza);

        RadioGroup geometriaTanqueRadioGroup = (RadioGroup) findViewById(R.id.radioGeometriaTanque);

        EditText campoProfundidade = (EditText) findViewById(R.id.campoProfundidade);

        EditText campoInfiltracao = (EditText) findViewById(R.id.campoInfiltracao);

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

    public String getBotaoSelecionado(RadioGroup g){

        return null;
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


    public void mensagemErro(){
        //IMPLEMENTAR MENSAGEM DE ERRO FULL

        System.out.println("CAMPOS NÃO PREENCHIDOS TOTALMENTE !!!");
    }

    public void mensagemSucesso(){
        System.out.println("SUCESSO !! ");
    }

    public void gerarMemorial(View v){

        if(todosOsCamposPreenchidos()){
            mensagemSucesso();
        }else{
            mensagemErro();
        }

        TemplatePDF meuTemplate = new TemplatePDF(this);

        //meutemplate.fazerCoisas();

    }
}
