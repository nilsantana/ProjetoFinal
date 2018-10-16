package com.example.nil.projetofinal;
/*
******************************************************
Instituto Federal de São Paulo - Campus Sertãozinho
Disciplina......: M4DADM
Programação de Computadores e Dispositivos Móveis
Aluno...........: Josenildo Santana Pinto
******************************************************
*/

/**
 * Created by Nil on 23/06/2018.
 */
//OBJETIVO.......: classe para manipular os registros
public class Registro {
    //OBJETIVO.......: declaração dos atributos que serão cadastrados
    private String nome;
    private String cpf;
    private String idade;
    private String telefone;
    private String email;

    Registro(String nome, String cpf, String idade, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.telefone = telefone;
        this.email = email;

    }

    //OBJETIVO.......: metodos get e set para recuperação e registro de dados cadastrais

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
