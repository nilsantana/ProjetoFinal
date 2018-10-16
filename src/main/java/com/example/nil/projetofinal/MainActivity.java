package com.example.nil.projetofinal;


/*
******************************************************
Instituto Federal de São Paulo - Campus Sertãozinho
Disciplina......: M4DADM
Programação de Computadores e Dispositivos Móveis
Aluno...........: Josenildo Santana Pinto
******************************************************
*/

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    // OBJETIVO.......:  declaração da atributo botão Inserir Dados
    Button btVaiTelacadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // OBJETIVO.......: Inicialização e chamada do objeto botão
        btVaiTelacadastro = (Button) findViewById(R.id.btVai);
        btVaiTelacadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaTelaCadastro();
            }
        });
    }
    // OBJETIVO.......: método no botão Inserir dados que chama a próxima Activity
    void chamaTelaCadastro(){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,SecondActivity.class);
        startActivity(intent);
        finish();

    }
}
