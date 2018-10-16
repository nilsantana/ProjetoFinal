package com.example.nil.projetofinal;
/*
******************************************************
Instituto Federal de São Paulo - Campus Sertãozinho
Disciplina......: M4DADM
Programação de Computadores e Dispositivos Móveis
Aluno...........: Josenildo Santana Pinto
******************************************************
*/

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class SecondActivity extends AppCompatActivity {
// OBJETIVO.......: criação de atributos para correspondentes aos botões e campos na activity e do DBHelper
    private DBHelper db;
    EditText etNome, etCpf, etIdade, etTelefone, etEmail;
    Button btInserir, btListar, btVoltaMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
// OBJETIVO.......: Inicialização do botões e campos na campos na activity
        this.db = new DBHelper(this);
        etNome = (EditText) findViewById(R.id.etNome);
        etCpf = (EditText) findViewById(R.id.etCpf);
        etIdade = (EditText) findViewById(R.id.etIdade);
        etTelefone = (EditText) findViewById(R.id.etTelefone);
        etEmail = (EditText) findViewById(R.id.etEmail);

        btInserir = (Button) findViewById(R.id.btInserir);
        btListar = (Button) findViewById(R.id.btListar);
        btVoltaMain = (Button) findViewById(R.id.btVoltar);

// OBJETIVO.......:  criação da ação de inserção no banco de dados no onclick do botão inserir
        btInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etNome.getText().length()>0 && etCpf.getText().length()>0 && etIdade.getText().length()>0 && etTelefone.getText().length()>0 && etEmail.getText().length()>0){
                    db.insert(etNome.getText().toString(),etCpf.getText().toString(),etIdade.getText().toString(),etTelefone.getText().toString(),etEmail.getText().toString());
                    AlertDialog.Builder adb = new  AlertDialog.Builder(SecondActivity.this);
                    adb.setTitle("Sucesso!");
                    adb.setMessage("Cadastro Realizado!");
                    adb.show();

                    etNome.setText("");
                    etCpf.setText("");
                    etIdade.setText("");
                    etTelefone.setText("");
                    etEmail.setText("");

                }
                else {
                    AlertDialog.Builder adb = new  AlertDialog.Builder(SecondActivity.this);
                    adb.setTitle("Erro!");
                    adb.setMessage("Todos os campos devem ser preenchidos!");
                    adb.show();

                    etNome.setText("");
                    etCpf.setText("");
                    etIdade.setText("");
                    etTelefone.setText("");
                    etEmail.setText("");

                }
            }
        });
// OBJETIVO.......:   criação da ação de listar os registros do banco de dados no onclick do botão listar registros
        btListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Registro> registros = db.queryGetAll();
                if (registros == null){
                    AlertDialog.Builder adb = new  AlertDialog.Builder(SecondActivity.this);
                    adb.setTitle("Mensagem!");
                    adb.setMessage("Não há registros cadastrados!");
                    adb.show();

                    etNome.setText("");
                    etCpf.setText("");
                    etIdade.setText("");
                    etTelefone.setText("");
                    etEmail.setText("");
                    return;

                }
//OBJETIVO.......: Ação de interação na listagem do banco de dados no onclick do botão listar registros com mensagem para o usuário
                for (int i=0; i<registros.size(); i++){
                    Registro registro = (Registro) registros.get(i);
                    AlertDialog.Builder adb = new  AlertDialog.Builder(SecondActivity.this);
                    adb.setTitle("Registro " + i);
                    adb.setMessage("Nome: " + registro.getNome()+"\nCPF: "+ registro.getCpf()+"\nIdade: "+registro.getIdade()+"\nTelefone: "+registro.getTelefone()+"\nEmai: "+registro.getEmail());
                    adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    adb.show();


                }
            }
        });
//OBJETIVO.......: criação da ação de retorno à tela principal no onclick do botão voltar
        btVoltaMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaTelaMain();
            }
        });

    }
//OBJETIVO.......:  método de retorno do botão voltar
    void chamaTelaMain(){
        Intent intent = new Intent();
        intent.setClass(SecondActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
