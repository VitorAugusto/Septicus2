package com.vitor.septicus2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dimensionarClick(View v){ //quando o usuário clicar em DIMENSIONAR

        Intent intent = new Intent(this, activity_dados.class);
        startActivity(intent);
    }
}
